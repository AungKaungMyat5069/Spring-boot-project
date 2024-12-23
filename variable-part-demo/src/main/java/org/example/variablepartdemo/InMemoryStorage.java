package org.example.variablepartdemo;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;

import java.util.Set;

public class InMemoryStorage {

    private HashMap<String, Byte[]> memoryStorage = new HashMap<>();


    public void store(String key, byte[] some) {
        memoryStorage.entrySet()
    }

    public Set<String> getNames() {
        return  memoryStorage.keySet();
    }


}
