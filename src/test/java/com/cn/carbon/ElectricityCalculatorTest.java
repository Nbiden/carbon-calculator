package com.cn.carbon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElectricityCalculatorTest {
    @Test
    void calculatesElectricityEmissionsCorrectly() {
        // Given 1,000 kWh; 0.81 lb/kWh -> 810 lb -> 810*0.453592=367.41 kg -> 0.36741 t
        UserInput input = new UserInput(0, 1000, 0);
        CategoryCalculator calc = new ElectricityCalculator();
        double result = calc.calculate(input);
        assertEquals(0.36741, result, 0.0001, "Expected ~0.36741 metric tons CO2e");
    }
}
