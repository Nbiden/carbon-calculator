package com.cn.carbon;

import com.cn.carbon.data.EmissionFactors;

public final class TransportCalculator implements CategoryCalculator {
    @Override
    public double calculate(UserInput input) {
        // 1. Fetch grams CO2 per mile factor
        double gramsPerMile = EmissionFactors.get().factor("transport.gasoline_grams_per_mile");
        // 2. Multiply by miles driven
        double totalGrams = input.milesDriven() * gramsPerMile;
        // 3. Convert grams -> metric tons: 1 metric ton = 1,000,000 grams
        return totalGrams / 1_000_000.0;
    }

    @Override
    public String name() {
        return "Transport";
    }
}
