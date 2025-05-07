package com.cn.carbon;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class FootprintCalculatorTest {
    @Test
    void aggregatesAllCategoriesCorrectly() {
        // Input: 10,000 mi, 1000 kWh, 100 therms
        UserInput input = new UserInput(10_000, 1000, 100);
        Map<String, Double> result = new FootprintCalculator().run(input);

        // Expected:
        // Transport: 10_000 * 404 g = 4,040,000 g = 4.04 t
        assertEquals(4.04, result.get("Transport"), 0.001);

        // Electricity: (1000*0.81 lb)*0.453592 = 367.41 kg = 0.36741 t
        assertEquals(0.36741, result.get("Electricity"), 0.0001);

        // Natural Gas: 100*5.3 = 530 kg = 0.53 t
        assertEquals(0.53, result.get("Natural Gas"), 0.0001);
    }

}
