package com.cn.carbon;

import com.cn.carbon.data.EmissionFactors;

public final class ElectricityCalculator implements CategoryCalculator {
    @Override
    public double calculate(UserInput input) {
        // 1. Get lbs CO2 per kWh
        double lbsPerKwh = EmissionFactors.get().factor("electricity.lbs_per_kwh");
        // 2. Total lbs CO2
        double totalLbs = input.kwhElectricity() * lbsPerKwh;
        // 3. Convert lbs -> kg (1 lb = 0.453592 kg), then kg -> metric tons
        double totalKg = totalLbs * 0.453592;
        return totalKg / 1_000.0;
    }

    @Override
    public String name() {
        return "Electricity";
    }
}
