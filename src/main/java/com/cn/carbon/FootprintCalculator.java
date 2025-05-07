package com.cn.carbon;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class FootprintCalculator {
    private final List<CategoryCalculator> calculators = List.of(
            new TransportCalculator(),
            new ElectricityCalculator(),
            new NaturalGasCalculator());

    /**
     * Runs all calculators and returns a mapp from category name to emissions (t
     * CO2e).
     */
    public Map<String, Double> run(UserInput input) {
        return calculators.stream()
                .collect(Collectors.toMap(
                        CategoryCalculator::name,
                        calc -> calc.calculate(input)));
    }
}
