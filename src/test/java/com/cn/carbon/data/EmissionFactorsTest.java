package com.cn.carbon.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmissionFactorsTest {
    @Test
    void factorsLoaded() {
        // Expect 404 grams/mile for transport.gasoline_grams_per_mile
        double actual = EmissionFactors.get()
                .factor("transport.gasoline_grams_per_mile");
        assertEquals(404.0, actual, 0.0001);
    }
}
