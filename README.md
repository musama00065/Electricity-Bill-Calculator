#  Electricity Billing System

A simple GUI-based electricity billing application built with Java Swing.

## Features

- Calculate electricity bills based on meter readings
- Support for Domestic and Commercial connections
- Tiered pricing structure
- Modern, user-friendly interface
- Input validation and error handling

## Requirements

- Java JDK 8 or higher

## How to Run

### Quick Start

**Windows:**
```bash
build.bat
run.bat
```

**Linux/Mac:**
```bash
chmod +x build.sh run.sh
./build.sh
./run.sh
```

### Manual Compilation

```bash
# Compile
javac -encoding UTF-8 -d bin -sourcepath src src/com/electricity/billing/*.java

# Run
java -cp bin com.electricity.billing.Main
```

## Pricing Structure

### Domestic Connection
- 0-100 units: PKR 20.00 per kWh
- 101-300 units: PKR 30.00 per kWh
- Above 300 units: PKR 40.00 per kWh

### Commercial Connection
- 0-100 units: PKR 25.00 per kWh
- 101-300 units: PKR 35.00 per kWh
- Above 300 units: PKR 45.00 per kWh

## Project Structure

```
src/com/electricity/billing/
├── Main.java              # Entry point
├── MainWindow.java        # GUI window
├── Reading.java           # Base reading class
├── PreviousReading.java   # Previous reading
├── CurrentReading.java    # Current reading
├── Customer.java          # Customer model
├── Bill.java              # Bill model
├── BillCalculator.java    # Calculation logic
├── InputValidator.java    # Input validation
└── UITheme.java           # UI theme
```

## Usage

1. Enter customer details (optional)
2. Select connection type (Domestic/Commercial)
3. Enter previous and current meter readings
4. Click "Calculate Bill" to see the result

## License

MIT License

## Author

Electricity Billing System
