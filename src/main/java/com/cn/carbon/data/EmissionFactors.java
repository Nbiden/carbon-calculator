package com.cn.carbon.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class EmissionFactors {
    private static EmissionFactors INSTANCE;
    private final Map<String, Double> map = new ConcurrentHashMap<>();

    private EmissionFactors() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("emission_factors.json")) {
            JsonNode root = new ObjectMapper().readTree(in);
            root.fields().forEachRemaining(category -> {
                String catName = category.getKey();
                category.getValue().fields().forEachRemaining(prop -> {
                    String key = catName + "." + prop.getKey();
                    double value = prop.getValue().asDouble();
                    map.put(key, value);
                });
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to load emission factors", e);
        }
    }

    public static EmissionFactors get() {
        if (INSTANCE == null) {
            INSTANCE = new EmissionFactors();
        }
        return INSTANCE;
    }

    public double factor(String key) {
        Double v = map.get(key);
        if (v == null)
            throw new IllegalArgumentException("No factor for: " + key);
        return v;
    }
}
