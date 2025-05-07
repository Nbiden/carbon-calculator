package com.cn.carbon;

import java.util.Scanner;
import com.cn.carbon.UserInput;
import com.cn.carbon.FootprintCalculator;
import com.cn.carbon.ReportGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Carbon Calculator MVP starting up...");

        // 1. Create Scanner for console input
        Scanner scanner = new Scanner(System.in);

        // 2. Prompt for annual miles driven
        System.out.print("Enter annual miles driven:");
        double miles = scanner.nextDouble();

        // 3. Prompt for annual electricity usage
        System.out.print("Enter annual electricity (kWh): ");
        double kwh = scanner.nextDouble();

        // 4. Prompt for annual natural gas (therms)
        System.out.print("Enter annual natural gas (therms): ");
        double therms = scanner.nextDouble();

        // 5. Build input object
        UserInput input = new UserInput(miles, kwh, therms);

        // 6. Compute emissions
        var results = new FootprintCalculator().run(input);

        // 7. Display the report
        ReportGenerator.prettyPrint(results);

        // 8. Close scanner
        scanner.close();
    }
}
