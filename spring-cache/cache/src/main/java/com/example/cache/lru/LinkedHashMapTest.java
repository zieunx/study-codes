package com.example.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        testLinkedHashMap();
        testLRU();
    }

    private static void testLinkedHashMap() {
        System.out.println("====[LinkedHashMap test]====");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        // linkedHashMap 초기화
        for (int i = 1; i <= 10; i++) {
            linkedHashMap.put("key-" + i, "value-" + i);
        }

        // linkedHashMap 값 추가 및 업데이트
        linkedHashMap.put("key-5", "value-5-update");
        linkedHashMap.put("key-11", "value-11-insert");
        linkedHashMap.put("key-2", "value-2-update");

        for (Map.Entry<String, String> stringEntry : linkedHashMap.entrySet()) {
            System.out.println(stringEntry);
        }
        System.out.println();
    }

    private static void testLRU() {
        System.out.println("====[LRU test]====");
        LRU<String, String> lru = new LRU<>(10);

        // linkedHashMap 초기화
        for (int i = 1; i <= 10; i++) {
            lru.put("key-" + i, "value-" + i);
        }

        lru.get("key-3");
        lru.get("key-3");
        lru.get("key-3");
        lru.get("key-3");
        lru.get("key-3");
        lru.get("key-3");
        lru.get("key-3");

        // linkedHashMap 값 추가 및 업데이트
        lru.put("key-5", "value-5-update");
        lru.put("key-11", "value-11-insert");
        lru.put("key-2", "value-2-update");

        for (Map.Entry<String, String> stringEntry : lru.entrySet()) {
            System.out.println(stringEntry);
        }
        System.out.println();
    }
}
