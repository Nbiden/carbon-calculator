package com.cn.carbon;

import java.util.Map;

public final class ReportGenerator {
    /**
     * Pretty-prints category breakdown and total CO₂e.
     */
    public static void prettyPrint(Map<String, Double> emissions) {
        // 1. Sum all category values
        double total = emissions.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        // 2. Header
        System.out.println("\n==== Annual CO\\u2082e Emissions ===");

        // 3. Print each category
        emissions.forEach((category, value) -> System.out.printf("%-12s : %.2f t%n", category, value));

        // 4. Separator and total
        System.out.println("------------------------------");
        System.out.printf("Total        : %.2f t%n", total);

        // 5. Comparison to U.S. average (~15 t)
        System.out.printf("US average ~15 t -> you are %.0f%% of avg%n",
                100 * total / 15.0);

    }
}
