# Project Structure Documentation

## Directory Layout

```
Electricity-Billing-System/
│
├── src/                                    # Source code directory
│   └── com/
│       └── electricity/
│           └── billing/                   # Main package
│               ├── Main.java               # Application entry point
│               ├── MainWindow.java         # Main GUI window
│               ├── Reading.java            # Base reading class
│               ├── PreviousReading.java    # Previous reading model
│               ├── CurrentReading.java     # Current reading model
│               ├── Customer.java           # Customer data model
│               ├── Bill.java               # Bill data model
│               ├── BillCalculator.java     # Business logic for calculations
│               ├── InputValidator.java     # Input validation utilities
│               └── UITheme.java            # UI theme configuration
│
├── bin/                                    # Compiled class files (generated)
│   └── com/
│       └── electricity/
│           └── billing/
│               └── *.class                 # Compiled Java classes
│
├── README.md                               # Main project documentation
├── QUICKSTART.md                           # Quick start guide
├── PROJECT_STRUCTURE.md                    # This file
├── LICENSE                                 # MIT License
├── .gitignore                              # Git ignore rules
├── build.bat                               # Windows build script
├── run.bat                                 # Windows run script
├── build.sh                                # Linux/Mac build script
└── run.sh                                  # Linux/Mac run script
```

## Package Structure

### Package: `com.electricity.billing`

All classes are organized under the `com.electricity.billing` package for proper namespace management.

## Class Descriptions

### Core Classes

1. **Main.java**
   - Entry point of the application
   - Initializes the GUI on the Event Dispatch Thread
   - Sets system look and feel

2. **MainWindow.java**
   - Main GUI window class
   - Extends `JFrame`
   - Manages all UI components and event handlers
   - Handles user interactions

### Model Classes

3. **Reading.java**
   - Base class for meter readings
   - Contains protected `value` field
   - Provides getter/setter methods

4. **PreviousReading.java**
   - Extends `Reading`
   - Represents previous meter reading

5. **CurrentReading.java**
   - Extends `Reading`
   - Represents current meter reading

6. **Customer.java**
   - Customer data model
   - Stores: name, connection type, meter number, address
   - Provides validation methods

7. **Bill.java**
   - Bill data model
   - Contains customer, readings, and calculated amount
   - Generates formatted bill summary
   - Includes bill date/time

### Business Logic Classes

8. **BillCalculator.java**
   - Core calculation logic
   - Implements tiered pricing structure
   - Supports Domestic and Commercial connections
   - Provides pricing information

### Utility Classes

9. **InputValidator.java**
   - Static utility methods for input validation
   - Validates numeric inputs, connection types, reading order
   - Provides comprehensive validation for bill inputs

10. **UITheme.java**
    - Centralized theme configuration
    - Defines colors, fonts, dimensions
    - Ensures consistent UI appearance

## Design Patterns Used

### 1. Model-View-Controller (MVC-like)
- **Model**: `Customer`, `Bill`, `Reading` classes
- **View**: `MainWindow` GUI components
- **Controller**: `BillCalculator`, `InputValidator`

### 2. Inheritance
- `Reading` → `PreviousReading` / `CurrentReading`
- Demonstrates OOP inheritance principles

### 3. Encapsulation
- Private fields with public getters/setters
- Protected fields in base class

### 4. Utility Pattern
- `InputValidator` and `UITheme` as utility classes
- Static methods for common operations

## File Organization Principles

1. **Separation of Concerns**
   - Each class has a single, well-defined responsibility
   - Business logic separated from UI code
   - Data models separated from presentation

2. **Package Organization**
   - All classes in `com.electricity.billing` package
   - Follows Java package naming conventions

3. **Build Organization**
   - Source files in `src/`
   - Compiled files in `bin/`
   - Scripts in root directory

## Dependencies

### Java Standard Library Only
- `javax.swing.*` - GUI components
- `java.awt.*` - Layout and graphics
- `java.util.*` - Utilities (StringBuilder, etc.)
- `java.time.*` - Date/time handling

No external dependencies required!

## Compilation Output

When compiled, the `bin/` directory will contain:
```
bin/
└── com/
    └── electricity/
        └── billing/
            ├── Main.class
            ├── MainWindow.class
            ├── Reading.class
            ├── PreviousReading.class
            ├── CurrentReading.class
            ├── Customer.class
            ├── Bill.class
            ├── BillCalculator.class
            ├── InputValidator.class
            └── UITheme.class
```

## Build Process

1. **Compilation**: `javac` compiles `.java` files to `.class` files
2. **Output**: Classes placed in `bin/` directory maintaining package structure
3. **Execution**: `java` runs `Main.class` with classpath pointing to `bin/`

## IDE Configuration

### Recommended IDE Settings

- **Source Root**: `src/`
- **Output Root**: `bin/`
- **Encoding**: UTF-8
- **Java Version**: 8 or higher

### Project Settings

- Mark `src` as Sources Root
- Mark `bin` as Output Root (if using IDE)
- Set encoding to UTF-8 for all files

---

This structure follows Java best practices and makes the project maintainable and scalable.
