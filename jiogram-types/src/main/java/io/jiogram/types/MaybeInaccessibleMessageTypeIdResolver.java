package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

/**
 * Custom Jackson type id resolver for {@link MaybeInaccessibleMessage}.
 *
 * <p>The Telegram Bot API uses the {@code date} field to discriminate between the two
 * {@code MaybeInaccessibleMessage} variants:
 * <ul>
 *   <li>{@code date == 0} &rarr; {@link InaccessibleMessage}</li>
 *   <li>{@code date != 0} &rarr; {@link Message} (any non-zero Unix timestamp)</li>
 * </ul>
 *
 * <p>Jackson's standard {@code @JsonSubTypes} mechanism cannot express this pattern
 * because it does exact string matching on discriminator values; real Telegram
 * messages contain Unix timestamps such as {@code 1775538971}, which never match
 * the literal strings {@code "0"} or {@code "nonzero"}. This resolver implements
 * the value-based "0 vs non-zero" semantics by treating any incoming type id other
 * than the literal string {@code "0"} as a regular {@link Message}.
 */
public final class MaybeInaccessibleMessageTypeIdResolver extends TypeIdResolverBase {

    @Override
    public String idFromValue(Object value) {
        return idFromValueAndType(value, value == null ? null : value.getClass());
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> suggestedType) {
        return value instanceof InaccessibleMessage ? "0" : "nonzero";
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) {
        Class<?> target = "0".equals(id) ? InaccessibleMessage.class : Message.class;
        return context.constructType(target);
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}
