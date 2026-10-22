package io.jiogram.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Fills {@link DefaultBotProperties} into the unset fields of an outgoing request, like aiogram's
 * {@code Default(...)} markers, including the objects nested in it:
 * <ul>
 *   <li>the default parse mode into {@code parse_mode} and every {@code *_parse_mode} field
 *       (captions of media in a group, inline query results, poll questions and options, quotes,
 *       ...), unless the matching entities field is set, since entities replace the parse mode;</li>
 *   <li>disabled link previews into {@code link_preview_options};</li>
 *   <li>{@code protect_content} of the method itself.</li>
 * </ul>
 * What a request type can contain is worked out once per class from its record components.
 */
final class RequestDefaults {

    /** Nested values are only searched in Telegram types, not in arbitrary application classes. */
    private static final String PACKAGE_PREFIX = "io.jiogram.";
    private static final Map<Class<?>, Plan> PLANS = new ConcurrentHashMap<>();
    private static final Plan NOTHING = new Plan(null, null, List.of());

    private final DefaultBotProperties defaults;

    RequestDefaults(DefaultBotProperties defaults) {
        this.defaults = defaults;
    }

    /**
     * Returns the method with the defaults filled in, or the same instance when there was nothing
     * to fill in.
     */
    @SuppressWarnings("unchecked")
    <T> TelegramMethod<T> apply(TelegramMethod<T> method) {
        if (defaults.parseMode() == null && !defaults.protectContent() && defaults.linkPreview()) {
            return method;
        }
        return (TelegramMethod<T>) fill(method);
    }

    private Object fill(Object value) {
        Plan plan = planFor(value.getClass());
        if (plan.slots().isEmpty()) {
            return value;
        }
        Object[] args = plan.read(value);
        boolean changed = false;
        for (Slot slot : plan.slots()) {
            Object current = args[slot.index()];
            Object filled = switch (slot.kind()) {
                case PARSE_MODE -> current == null && defaults.parseMode() != null && slot.noEntities(args)
                    ? defaults.parseMode() : current;
                case LINK_PREVIEW -> current == null && !defaults.linkPreview()
                    ? new LinkPreviewOptions(true, null, null, null, null) : current;
                case PROTECT_CONTENT -> current == null && defaults.protectContent() ? Boolean.TRUE : current;
                case NESTED -> current == null ? null : fill(current);
                case NESTED_LIST -> current == null ? null : fillAll((List<?>) current);
            };
            if (filled != current) {
                args[slot.index()] = filled;
                changed = true;
            }
        }
        return changed ? plan.create(args) : value;
    }

    private List<?> fillAll(List<?> values) {
        List<Object> filled = new ArrayList<>(values.size());
        boolean changed = false;
        for (Object value : values) {
            Object result = value == null ? null : fill(value);
            changed |= result != value;
            filled.add(result);
        }
        return changed ? Collections.unmodifiableList(filled) : values;
    }

    private enum Kind { PARSE_MODE, LINK_PREVIEW, PROTECT_CONTENT, NESTED, NESTED_LIST }

    /**
     * @param entityIndexes for {@link Kind#PARSE_MODE}: the entities fields that replace it
     */
    private record Slot(int index, Kind kind, int[] entityIndexes) {

        boolean noEntities(Object[] args) {
            for (int entityIndex : entityIndexes) {
                if (args[entityIndex] != null) {
                    return false;
                }
            }
            return true;
        }
    }

    /** How to read and rebuild one record type, and which of its components get defaults. */
    private record Plan(Method @Nullable [] accessors, @Nullable Constructor<?> constructor, List<Slot> slots) {

        Object[] read(Object value) {
            Object[] args = new Object[accessors.length];
            try {
                for (int i = 0; i < accessors.length; i++) {
                    args[i] = accessors[i].invoke(value);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new IllegalStateException("Cannot read " + value.getClass().getName(), e);
            }
            return args;
        }

        Object create(Object[] args) {
            try {
                return constructor.newInstance(args);
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException(
                    "Failed to apply default bot properties to " + constructor.getDeclaringClass().getName(), e);
            }
        }
    }

    private static Plan planFor(Class<?> type) {
        Plan plan = PLANS.get(type);
        if (plan == null) {
            // Not computeIfAbsent: building a plan builds the plans of nested types too.
            plan = buildPlan(type, new HashSet<>());
            Plan raced = PLANS.putIfAbsent(type, plan);
            if (raced != null) {
                plan = raced;
            }
        }
        return plan;
    }

    private static Plan buildPlan(Class<?> type, Set<Class<?>> inProgress) {
        if (!type.isRecord()) {
            return NOTHING;
        }
        inProgress.add(type);
        RecordComponent[] components = type.getRecordComponents();
        Map<String, Integer> indexByName = new HashMap<>();
        for (int i = 0; i < components.length; i++) {
            indexByName.put(jsonName(components[i]), i);
        }

        List<Slot> slots = new ArrayList<>();
        for (int i = 0; i < components.length; i++) {
            RecordComponent component = components[i];
            String name = jsonName(component);
            Class<?> raw = component.getType();
            if (raw == ParseMode.class && (name.equals("parse_mode") || name.endsWith("_parse_mode"))) {
                slots.add(new Slot(i, Kind.PARSE_MODE, entityIndexes(name, indexByName)));
            } else if (raw == LinkPreviewOptions.class && name.equals("link_preview_options")) {
                slots.add(new Slot(i, Kind.LINK_PREVIEW, new int[0]));
            } else if (raw == Boolean.class && name.equals("protect_content")
                    && TelegramMethod.class.isAssignableFrom(type)) {
                slots.add(new Slot(i, Kind.PROTECT_CONTENT, new int[0]));
            } else if (Collection.class.isAssignableFrom(raw)) {
                if (raw == List.class && component.getGenericType() instanceof ParameterizedType list
                        && mayContainDefaults(list.getActualTypeArguments()[0], inProgress)) {
                    slots.add(new Slot(i, Kind.NESTED_LIST, new int[0]));
                }
            } else if (mayContainDefaults(raw, inProgress)) {
                slots.add(new Slot(i, Kind.NESTED, new int[0]));
            }
        }
        inProgress.remove(type);
        if (slots.isEmpty()) {
            return NOTHING;
        }

        Method[] accessors = new Method[components.length];
        Class<?>[] parameterTypes = new Class<?>[components.length];
        for (int i = 0; i < components.length; i++) {
            accessors[i] = components[i].getAccessor();
            accessors[i].setAccessible(true);
            parameterTypes[i] = components[i].getType();
        }
        try {
            Constructor<?> constructor = type.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
            return new Plan(accessors, constructor, List.copyOf(slots));
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Record without a canonical constructor: " + type.getName(), e);
        }
    }

    /** Whether a value of this declared type (a record, or an interface of records) can need defaults. */
    private static boolean mayContainDefaults(Type declared, Set<Class<?>> inProgress) {
        if (!(declared instanceof Class<?> type) || !type.getName().startsWith(PACKAGE_PREFIX)) {
            return false;
        }
        if (inProgress.contains(type)) {
            // A cycle: assume yes; filling such a value just finds nothing to change.
            return true;
        }
        if (type.isRecord()) {
            Plan known = PLANS.get(type);
            Plan plan = known != null ? known : buildPlan(type, inProgress);
            if (known == null) {
                PLANS.putIfAbsent(type, plan);
            }
            return !plan.slots().isEmpty();
        }
        if (type.isSealed()) {
            for (Class<?> subtype : type.getPermittedSubclasses()) {
                if (mayContainDefaults(subtype, inProgress)) {
                    return true;
                }
            }
            return false;
        }
        // An open interface (e.g. InputMessageContent): its implementations are not known here,
        // so the value's own class decides at run time.
        return type.isInterface();
    }

    /** {@code parse_mode} is replaced by {@code entities}/{@code caption_entities}, {@code x_parse_mode} by {@code x_entities}. */
    private static int[] entityIndexes(String parseModeName, Map<String, Integer> indexByName) {
        List<String> names = parseModeName.equals("parse_mode")
            ? List.of("entities", "caption_entities")
            : List.of(parseModeName.substring(0, parseModeName.length() - "parse_mode".length()) + "entities");
        return names.stream()
            .map(indexByName::get)
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private static String jsonName(RecordComponent component) {
        JsonProperty property = component.getAccessor().getAnnotation(JsonProperty.class);
        if (property == null) {
            property = component.getAnnotation(JsonProperty.class);
        }
        return property != null && !property.value().isEmpty() ? property.value() : component.getName();
    }
}
