package com.cn.carbon;

import com.cn.carbon.data.EmissionFactors;

public final class ElectricityCalculator implements CategoryCalculator {
    private static final String FACTOR_KEY = "electricity.lbs_per_kwh";
    private static final double LBS_TO_KG = 0.453592;
    private static final double KG_PER_METRIC_TON = 1_000.0;

    @Override
    public double calculate(UserInput input) {
        // 1. Get lbs CO2 per kWh
        double lbsPerKwh = EmissionFactors.get().factor(FACTOR_KEY);
        // 2. Total lbs CO2
        double totalLbs = input.kwhElectricity() * lbsPerKwh;
        // 3. Convert lbs -> kg (1 lb = 0.453592 kg), then kg -> metric tons
        return (totalLbs * LBS_TO_KG) / KG_PER_METRIC_TON;
    }

    @Override
    public String name() {
        return "Electricity";
    }
}
