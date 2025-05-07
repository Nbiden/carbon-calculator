package com.cn.carbon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserInputTest {
    @Test
    void accessorsReturnCorrectValues() {
        // Given
        double miles = 123.4;
        double kwh = 567.8;
        double therms = 90.12;

        // When
        UserInput ui = new UserInput(miles, kwh, therms);

        // Then
        assertEquals(miles, ui.milesDriven(), "milesDriven()");
        assertEquals(kwh, ui.kwhElectricity(), "kwhElectricity()");
        assertEquals(therms, ui.thermsGas(), "thermsGas()");
    }
}
