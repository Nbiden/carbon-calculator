package com.cn.carbon;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void mainPrintsAllCategoriesForZeroInput() throws IOException {
        // 1) Prepare simulated user input: three lines “0”
        String simulatedInput = "0\n0\n0\n";
        ByteArrayInputStream inStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inStream);

        // 2) Capture System.out
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outStream);
        PrintStream oldOut = System.out;
        System.setOut(ps);

        // 3) Run main
        Main.main(new String[] {});

        // 4) Restore original streams
        System.setOut(oldOut);

        // 5) Get the output text
        String output = outStream.toString();

        // 6) Assert it mentions each category and the total
        assertTrue(output.contains("Transport"), "Should mention Transport");
        assertTrue(output.contains("Electricity"), "Should mention Electricity");
        assertTrue(output.contains("Natural Gas"), "Should mention Natural Gas");
        assertTrue(output.contains("Total"), "Should mention Total");
    }
}
