package com.cn.carbon;

/**
 * Common interface for all emission-category calculators.
 */
public interface CategoryCalculator {
    /**
     * Calculate emissions (in metric tons) for this category.
     * 
     * @param input all user inputs
     * @return total emissions (t CO2e)
     */
    double calculate(UserInput input);

    /** Human-readable name for this category. */
    String name();
}
