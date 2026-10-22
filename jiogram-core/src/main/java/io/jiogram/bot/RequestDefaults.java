package io.jiogram.bot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
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
 * What a request type can contain is worked out once per class from its properties: the
 * parameters of its single {@link JsonCreator @JsonCreator} constructor (or the components of a
 * record, on runtimes that have records), read back through accessor methods named like the
 * properties. Classes without such a constructor are left untouched.
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
        if (plan.slots.isEmpty()) {
            return value;
        }
        Object[] args = plan.read(value);
        boolean changed = false;
        for (Slot slot : plan.slots) {
            Object current = args[slot.index];
            Object filled = filled(slot, current, args);
            if (filled != current) {
                args[slot.index] = filled;
                changed = true;
            }
        }
        return changed ? plan.create(args) : value;
    }

    private @Nullable Object filled(Slot slot, @Nullable Object current, Object[] args) {
        switch (slot.kind) {
            case PARSE_MODE:
                return current == null && defaults.parseMode() != null && slot.noEntities(args)
                    ? defaults.parseMode() : current;
            case LINK_PREVIEW:
                return current == null && !defaults.linkPreview()
                    ? new LinkPreviewOptions(true, null, null, null, null) : current;
            case PROTECT_CONTENT:
                return current == null && defaults.protectContent() ? Boolean.TRUE : current;
            case NESTED:
                return current == null ? null : fill(current);
            case NESTED_LIST:
                return current == null ? null : fillAll((List<?>) current);
            default:
                throw new IllegalStateException("Unknown slot kind " + slot.kind);
        }
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

    /** One property that gets a default, or that holds values which may get defaults. */
    private static final class Slot {

        final int index;
        final Kind kind;
        /** For {@link Kind#PARSE_MODE}: the entities fields that replace it. */
        final int[] entityIndexes;

        Slot(int index, Kind kind, int[] entityIndexes) {
            this.index = index;
            this.kind = kind;
            this.entityIndexes = entityIndexes;
        }

        boolean noEntities(Object[] args) {
            for (int entityIndex : entityIndexes) {
                if (args[entityIndex] != null) {
                    return false;
                }
            }
            return true;
        }
    }

    /** How to read and rebuild one type, and which of its properties get defaults. */
    private static final class Plan {

        final Method @Nullable [] accessors;
        final @Nullable Constructor<?> constructor;
        final List<Slot> slots;

        Plan(Method @Nullable [] accessors, @Nullable Constructor<?> constructor, List<Slot> slots) {
            this.accessors = accessors;
            this.constructor = constructor;
            this.slots = slots;
        }

        Object[] read(Object value) {
            Method[] accessors = Objects.requireNonNull(this.accessors);
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
            Constructor<?> constructor = Objects.requireNonNull(this.constructor);
            try {
                return constructor.newInstance(args);
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException(
                    "Failed to apply default bot properties to " + constructor.getDeclaringClass().getName(), e);
            }
        }
    }

    /**
     * The properties of a type: the constructor that creates it, and per constructor parameter
     * its JSON name, declared type and the accessor that reads it back.
     */
    private static final class Properties {

        final Constructor<?> constructor;
        final String[] jsonNames;
        final Class<?>[] types;
        final Type[] genericTypes;
        final Method[] accessors;

        Properties(Constructor<?> constructor, String[] jsonNames, Class<?>[] types, Type[] genericTypes,
                   Method[] accessors) {
            this.constructor = constructor;
            this.jsonNames = jsonNames;
            this.types = types;
            this.genericTypes = genericTypes;
            this.accessors = accessors;
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
        Properties properties = propertiesOf(type);
        if (properties == null) {
            return NOTHING;
        }
        inProgress.add(type);
        int count = properties.jsonNames.length;
        Map<String, Integer> indexByName = new HashMap<>();
        for (int i = 0; i < count; i++) {
            indexByName.put(properties.jsonNames[i], i);
        }

        List<Slot> slots = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = properties.jsonNames[i];
            Class<?> raw = properties.types[i];
            if (raw == ParseMode.class && (name.equals("parse_mode") || name.endsWith("_parse_mode"))) {
                slots.add(new Slot(i, Kind.PARSE_MODE, entityIndexes(name, indexByName)));
            } else if (raw == LinkPreviewOptions.class && name.equals("link_preview_options")) {
                slots.add(new Slot(i, Kind.LINK_PREVIEW, new int[0]));
            } else if (raw == Boolean.class && name.equals("protect_content")
                    && TelegramMethod.class.isAssignableFrom(type)) {
                slots.add(new Slot(i, Kind.PROTECT_CONTENT, new int[0]));
            } else if (Collection.class.isAssignableFrom(raw)) {
                Type generic = properties.genericTypes[i];
                if (raw == List.class && generic instanceof ParameterizedType
                        && mayContainDefaults(((ParameterizedType) generic).getActualTypeArguments()[0], inProgress)) {
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

        for (Method accessor : properties.accessors) {
            accessor.setAccessible(true);
        }
        properties.constructor.setAccessible(true);
        return new Plan(properties.accessors, properties.constructor, List.copyOf(slots));
    }

    /**
     * Whether a value of this declared type (a class with properties, or an interface of such
     * classes) can need defaults.
     */
    private static boolean mayContainDefaults(Type declared, Set<Class<?>> inProgress) {
        if (!(declared instanceof Class<?>)) {
            return false;
        }
        Class<?> type = (Class<?>) declared;
        if (!type.getName().startsWith(PACKAGE_PREFIX)) {
            return false;
        }
        if (inProgress.contains(type)) {
            // A cycle: assume yes; filling such a value just finds nothing to change.
            return true;
        }
        if (type.isInterface()) {
            JsonSubTypes subtypes = type.getAnnotation(JsonSubTypes.class);
            if (subtypes == null) {
                // An open interface (e.g. InputMessageContent): its implementations are not known
                // here, so the value's own class decides at run time.
                return true;
            }
            for (JsonSubTypes.Type subtype : subtypes.value()) {
                if (mayContainDefaults(subtype.value(), inProgress)) {
                    return true;
                }
            }
            return false;
        }
        Plan known = PLANS.get(type);
        Plan plan = known != null ? known : buildPlan(type, inProgress);
        if (known == null) {
            PLANS.putIfAbsent(type, plan);
        }
        return !plan.slots.isEmpty();
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

    /**
     * Finds how to read and rebuild a type: its single {@code @JsonCreator} constructor, or else
     * the canonical constructor of a record. Returns null for anything else, and for a type whose
     * constructor parameters cannot all be matched to an accessor.
     */
    private static @Nullable Properties propertiesOf(Class<?> type) {
        if (type.isInterface() || type.isEnum() || type.isArray() || type.isPrimitive()
                || Modifier.isAbstract(type.getModifiers())) {
            return null;
        }
        Constructor<?> creator = jsonCreator(type);
        if (creator != null) {
            return creatorProperties(type, creator);
        }
        return recordProperties(type);
    }

    /** The one constructor annotated with {@code @JsonCreator} (not delegating); null if none or several. */
    private static @Nullable Constructor<?> jsonCreator(Class<?> type) {
        Constructor<?> found = null;
        for (Constructor<?> constructor : type.getDeclaredConstructors()) {
            JsonCreator annotation = constructor.getAnnotation(JsonCreator.class);
            if (annotation == null || annotation.mode() == JsonCreator.Mode.DISABLED) {
                continue;
            }
            if (found != null || annotation.mode() == JsonCreator.Mode.DELEGATING) {
                return null;
            }
            found = constructor;
        }
        return found;
    }

    private static @Nullable Properties creatorProperties(Class<?> type, Constructor<?> constructor) {
        Parameter[] parameters = constructor.getParameters();
        Class<?>[] types = constructor.getParameterTypes();
        Type[] genericTypes = constructor.getGenericParameterTypes();
        if (genericTypes.length != types.length) {
            // Synthetic parameters (e.g. of an inner class) are not part of getGenericParameterTypes().
            genericTypes = types;
        }
        String[] jsonNames = new String[parameters.length];
        Method[] accessors = new Method[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            JsonProperty property = parameter.getAnnotation(JsonProperty.class);
            String jsonName = property != null && !property.value().isEmpty()
                ? property.value()
                : parameter.isNamePresent() ? parameter.getName() : null;
            if (jsonName == null) {
                return null;
            }
            Method accessor = accessor(type, javaNameCandidates(type, parameter, jsonName), types[i]);
            if (accessor == null) {
                return null;
            }
            jsonNames[i] = jsonName;
            accessors[i] = accessor;
        }
        return new Properties(constructor, jsonNames, types, genericTypes, accessors);
    }

    /**
     * The Java name of a constructor parameter, in order of preference: the field carrying the
     * same {@code @JsonProperty} name (as in the generated types), the parameter's own name when
     * compiled with {@code -parameters}, and the JSON name itself.
     */
    private static List<String> javaNameCandidates(Class<?> type, Parameter parameter, String jsonName) {
        List<String> names = new ArrayList<>(3);
        for (Field field : type.getDeclaredFields()) {
            JsonProperty property = field.getAnnotation(JsonProperty.class);
            if (!Modifier.isStatic(field.getModifiers()) && property != null && jsonName.equals(property.value())) {
                names.add(field.getName());
            }
        }
        if (parameter.isNamePresent()) {
            names.add(parameter.getName());
        }
        names.add(jsonName);
        return names;
    }

    /** A no-argument instance method with one of the names, returning the property's type. */
    private static @Nullable Method accessor(Class<?> type, List<String> names, Class<?> propertyType) {
        for (String name : names) {
            Method method = findMethod(type, name);
            if (method != null && !Modifier.isStatic(method.getModifiers())
                    && propertyType.isAssignableFrom(method.getReturnType())) {
                return method;
            }
        }
        return null;
    }

    private static @Nullable Method findMethod(Class<?> type, String name) {
        for (Class<?> current = type; current != null && current != Object.class; current = current.getSuperclass()) {
            try {
                return current.getDeclaredMethod(name);
            } catch (NoSuchMethodException e) {
                // Look further up.
            }
        }
        return null;
    }

    /**
     * The canonical constructor and components of a record. Records exist from Java 16 on, while
     * this branch compiles for Java 11, so they are read reflectively; on older runtimes nothing
     * is a record.
     */
    private static @Nullable Properties recordProperties(Class<?> type) {
        Object[] components;
        try {
            Method isRecord = Class.class.getMethod("isRecord");
            if (!Boolean.TRUE.equals(isRecord.invoke(type))) {
                return null;
            }
            components = (Object[]) Class.class.getMethod("getRecordComponents").invoke(type);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Cannot read the components of " + type.getName(), e);
        }
        if (components == null) {
            return null;
        }
        String[] jsonNames = new String[components.length];
        Class<?>[] types = new Class<?>[components.length];
        Type[] genericTypes = new Type[components.length];
        Method[] accessors = new Method[components.length];
        try {
            for (int i = 0; i < components.length; i++) {
                Object component = components[i];
                Method accessor = (Method) component.getClass().getMethod("getAccessor").invoke(component);
                String name = (String) component.getClass().getMethod("getName").invoke(component);
                JsonProperty property = accessor.getAnnotation(JsonProperty.class);
                if (property == null) {
                    property = type.getDeclaredField(name).getAnnotation(JsonProperty.class);
                }
                jsonNames[i] = property != null && !property.value().isEmpty() ? property.value() : name;
                types[i] = accessor.getReturnType();
                genericTypes[i] = accessor.getGenericReturnType();
                accessors[i] = accessor;
            }
            return new Properties(type.getDeclaredConstructor(types), jsonNames, types, genericTypes, accessors);
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            throw new IllegalStateException("Record without a canonical constructor: " + type.getName(), e);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Cannot read the components of " + type.getName(), e);
        }
    }
}
