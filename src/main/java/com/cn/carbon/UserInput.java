package com.cn.carbon;

/**
 * Simple record to hold user inputs for all categories.
 */
public record UserInput(
        double milesDriven,
        double kwhElectricity,
        double thermsGas) {
}
