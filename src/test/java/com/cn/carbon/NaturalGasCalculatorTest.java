package com.cn.carbon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NaturalGasCalculatorTest {
    @Test
    void calculatesNaturalGasEmissionsCorrectly() {
        // Given 1,000 therms; 5.3 kg/therm -> 530 kg -> 0.53 t
        UserInput input = new UserInput(0, 0, 100);
        CategoryCalculator calc = new NaturalGasCalculator();
        double result = calc.calculate(input);
        assertEquals(0.53, result, 0.0001, "Expected ~0.53 metric tons CO2e");
    }

}
