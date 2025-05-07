package com.cn.carbon;

import com.cn.carbon.data.EmissionFactors;

public final class NaturalGasCalculator implements CategoryCalculator {
    private static final String FACTOR_KEY = "natural_gas.kg_per_therm";
    private static final double KG_PER_METRIC_TON = 1_000.0;

    @Override
    public double calculate(UserInput input) {
        // 1. Get kg CO2 per therm
        double kgPerTherm = EmissionFactors.get().factor(FACTOR_KEY);
        // 2. Total kg CO2
        double totalKg = input.thermsGas() * kgPerTherm;
        // 3. Convert kg -> metric tons
        return totalKg / KG_PER_METRIC_TON;
    }

    @Override
    public String name() {
        return "Natural Gas";
    }
}
