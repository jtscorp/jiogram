package io.jiogram.dispatcher;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

class UpdateContextTest {

    private final UpdateContext context = new UpdateContext(null, null);

    @Test
    void puttingNull_removesTheKeyInsteadOfThrowing() {
        context.put("raw_state", "Form.NAME");

        context.put("raw_state", null);

        assertNull(context.get("raw_state"));
        assertFalse(context.data().containsKey("raw_state"));
    }

    @Test
    void mergingAMapWithNullValues_doesNotThrow() {
        Map<String, Object> filterData = new HashMap<>();
        filterData.put("command", "start");
        filterData.put("optional", null);

        context.merge(filterData);

        assertEquals("start", context.get("command"));
        assertFalse(context.data().containsKey("optional"));
    }
}
