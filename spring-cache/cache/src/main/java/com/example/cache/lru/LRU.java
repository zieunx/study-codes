package com.example.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K, V> extends LinkedHashMap<K, V> {
    private int size;

    public LRU(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static <K, V> LRU<K, V> newInstance(int size) {
        return new LRU<>(size);
    }
}
