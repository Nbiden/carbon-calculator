package com.cn.carbon;

import com.cn.carbon.data.EmissionFactors;

public final class NaturalGasCalculator implements CategoryCalculator {
    @Override
    public double calculate(UserInput input) {
        // 1. Get kg CO2 per therm
        double kgPerTherm = EmissionFactors.get().factor("natural_gas.kg_per_therm");
        // 2. Total kg CO2
        double totalKg = input.thermsGas() * kgPerTherm;
        // 3. Convert kg -> metric tons
        return totalKg / 1_000.0;
    }

    @Override
    public String name() {
        return "Natural Gas";
    }
}
