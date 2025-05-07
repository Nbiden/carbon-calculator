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

    @Test
    void factorWithUnknownKeyThrows() {
        assertThrows(IllegalArgumentException.class, () -> EmissionFactors.get().factor("no.such.key"));
    }

    @Test
    void getReturnsSameInstance() {
        var a = EmissionFactors.get();
        var b = EmissionFactors.get();
        assertSame(a, b, "Should return the same singleton instance");
    }
}
