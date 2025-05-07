package com.cn.carbon;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class ReportGeneratorTest {
    @Test
    void prettyPrintOutputsCorrectFormat() {
        // 1) Prepare a small sample map
        Map<String, Double> emissions = Map.of(
                "A", 1.0,
                "B", 2.5);

        // 2) Capture System.out
        var out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 3) Invoke prettyPrint
        ReportGenerator.prettyPrint(emissions);

        // 4) Restore original (optional)
        System.setOut(System.out);

        // 5) Convert to string
        String output = out.toString();

        // 6) Check header
        assertTrue(output.contains("\n==== Annual CO\\u2082e Emissions ==="),
                "Should print header");

        // 7) Check each category line
        String expectedA = String.format("%-12s : %.2f t", "A", 1.0);
        assertTrue(output.contains(expectedA),
                () -> "Expected line: `" + expectedA + "` but got:\n" + output);

        String expectedB = String.format("%-12s : %.2f t", "B", 2.5);
        assertTrue(output.contains(expectedB),
                () -> "Expected line: `" + expectedB + "` but got:\n" + output);

        // 8) Check total and generate it with the same %-12s : %.2f t format
        double expectedTotalValue = 1.0 + 2.5; // sum of your sample map entries
        String expectedTotalLine = String.format("%-12s : %.2f t", "Total", expectedTotalValue);
        assertTrue(output.contains(expectedTotalLine),
                () -> "Expected total line `" + expectedTotalLine + "` but got:\n" + output);

        // 9) Check US average comparison (3.5/15 = 0.23)
        assertTrue(output.matches("(?s).*you are 23% of avg.*"),
                "Should report ~23% of US avg");
    }
}