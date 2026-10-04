package com.jatinahuja.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class LruCacheTest {
    @Test
    void evictsLeastRecentlyUsedEntryWhenCapacityIsExceeded() {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.get(1);
        cache.put(3, "three");

        assertEquals("one", cache.get(1).orElseThrow());
        assertEquals("three", cache.get(3).orElseThrow());
        assertEquals(2, cache.size());
        assertEquals(Optional.empty(), cache.get(2), "Entry 2 should have been evicted");
    }

    @Test
    void updatingAnEntryRefreshesItsValueAndRecency() {
        LruCache<String, Integer> cache = new LruCache<>(2);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("a", 10);
        cache.put("c", 3);

        assertEquals(10, cache.get("a").orElseThrow());
        assertEquals(3, cache.get("c").orElseThrow());
        assertEquals(Optional.empty(), cache.get("b"));
        assertEquals(2, cache.size());
    }

    @Test
    void supportsCapacityOneAndReportsMissesWithoutThrowing() {
        LruCache<String, String> cache = new LruCache<>(1);
        assertEquals(Optional.empty(), cache.get("missing"));
        cache.put("first", "one");
        cache.put("second", "two");

        assertEquals(Optional.empty(), cache.get("first"));
        assertEquals("two", cache.get("second").orElseThrow());
    }

    @Test
    void rejectsInvalidCapacityAndNullKeysOrValues() {
        assertThrows(IllegalArgumentException.class, () -> new LruCache<>(0));

        LruCache<String, String> cache = new LruCache<>(1);
        assertThrows(NullPointerException.class, () -> cache.get(null));
        assertThrows(NullPointerException.class, () -> cache.put(null, "value"));
        assertThrows(NullPointerException.class, () -> cache.put("key", null));
    }
}
