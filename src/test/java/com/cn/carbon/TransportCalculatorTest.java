package com.cn.carbon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransportCalculatorTest {
    @Test
    void calculatesTransportEmissionsCorrectly() {
        // 12,000 miles driven; with 404 g/mile -> 12,000*404 = 4,848,000 g = 4.848 t
        UserInput input = new UserInput(12_000, 0, 0);
        CategoryCalculator calc = new TransportCalculator();
        double result = calc.calculate(input);
        assertEquals(4.848, result, 0.001, "Expected ~4.848 tons CO2e");
    }
}
