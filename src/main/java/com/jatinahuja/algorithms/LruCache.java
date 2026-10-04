package com.jatinahuja.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class LruCache<K, V> {
    private final int capacity;
    private final Map<K, V> entries;

    public LruCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.entries = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LruCache.this.capacity;
            }
        };
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(entries.get(Objects.requireNonNull(key, "key")));
    }

    public void put(K key, V value) {
        entries.put(
                Objects.requireNonNull(key, "key"),
                Objects.requireNonNull(value, "value"));
    }

    public int size() {
        return entries.size();
    }
}
