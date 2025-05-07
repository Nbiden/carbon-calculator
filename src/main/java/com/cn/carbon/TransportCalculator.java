package com.cn.carbon;

import com.cn.carbon.data.EmissionFactors;

public final class TransportCalculator implements CategoryCalculator {

    private static final String FACTOR_KEY = "transport.gasoline_grams_per_mile";
    private static final double GRAMS_PER_METRIC_TON = 1_000_000.0;

    @Override
    public double calculate(UserInput input) {
        // 1. Fetch grams CO2 per mile factor
        double gramsPerMile = EmissionFactors.get().factor(FACTOR_KEY);
        // 2. Multiply by miles driven
        double totalGrams = input.milesDriven() * gramsPerMile;
        // 3. Convert grams -> metric tons: 1 metric ton = 1,000,000 grams
        return totalGrams / GRAMS_PER_METRIC_TON;
    }

    @Override
    public String name() {
        return "Transport";
    }
}
