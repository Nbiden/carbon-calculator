# Personal Carbon Footprint Calculator

**A Java CLI tool to estimate your annual CO₂e emissions**  
Calculates emissions from driving, electricity, and natural gas using official EPA/EIA/DEFRA factors.

## Features

- Transport, electricity, and natural gas categories
- Input validation for non-negative values
- Breakdown and total with comparison to U.S. average (~15 t)

## Prerequisites

- Java 17+
- Maven 3.9+

## Build & Run

```bash
mvn clean package
java -jar target/carbon-calculator-1.0-SNAPSHOT-shaded.jar
```

Or via Maven exec:

```bash
mvn clean compile exec:java
```

## Usage Example

```yaml
Enter annual miles driven: 12000
Enter annual electricity (kWh): 1000
Enter annual natural gas (therms): 100

=== Annual CO₂e Emissions ===
Transport    : 4.85 t
Electricity  : 0.37 t
Natural Gas  : 0.53 t
------------------------------
Total        : 5.75 t
US average ~15 t → you are 38% of avg
```

## References

- EPA passenger vehicle factor (~404 g/mi)  
  Source: EPA Greenhouse Gas Equivalencies Calculator
- EIA average electricity emission factor (~0.81 lb/kWh)
  Source: EIA 2023
- EPA residential natural gas factor (~5.3 kg/therm)
  Source: EPA Home Energy tables
- DEFRA 2024 aviation factors (for future flights feature)

## License

MIT © Noah Biden
