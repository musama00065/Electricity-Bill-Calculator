# Quick Start Guide

## Prerequisites
- Java JDK 8 or higher installed
- Command line access (Terminal/Command Prompt)

## Quick Start (Windows)

1. **Build the project:**
   ```bash
   build.bat
   ```

2. **Run the application:**
   ```bash
   run.bat
   ```

## Quick Start (Linux/Mac)

1. **Make scripts executable:**
   ```bash
   chmod +x build.sh run.sh
   ```

2. **Build the project:**
   ```bash
   ./build.sh
   ```

3. **Run the application:**
   ```bash
   ./run.sh
   ```

## Manual Compilation

If you prefer to compile manually:

```bash
# Compile
javac -encoding UTF-8 -d bin -sourcepath src src/com/electricity/billing/*.java

# Run
java -cp bin com.electricity.billing.Main
```

## Using an IDE

### IntelliJ IDEA
1. Open the project folder
2. Mark `src` as Sources Root
3. Run `Main.java`

### Eclipse
1. Import as Java Project
2. Set source folder to `src`
3. Run `Main.java`

### NetBeans
1. Open Project
2. Select the project folder
3. Run `Main.java`

## Troubleshooting

### "javac: command not found"
- Ensure JDK is installed and added to PATH
- Verify with: `java -version` and `javac -version`

### "ClassNotFoundException"
- Ensure you're running from the project root directory
- Check that `bin` folder contains compiled classes

### Encoding Issues
- The project uses UTF-8 encoding
- If you see encoding errors, ensure your terminal supports UTF-8

## Features to Try

1. **Calculate a Bill:**
   - Enter customer details
   - Select connection type (Domestic/Commercial)
   - Enter previous and current readings
   - Click "Calculate Bill"

2. **View Pricing Info:**
   - Click "Pricing Info" button
   - See current tiered pricing structure

3. **Reset Form:**
   - Click "Reset" to clear all fields

## Example Calculation

**Input:**
- Connection Type: Domestic
- Previous Reading: 1000 kWh
- Current Reading: 1250 kWh

**Result:**
- Units Consumed: 250 kWh
- Calculation:
  - First 100 units: 100 × PKR 20 = PKR 2,000
  - Next 150 units: 150 × PKR 30 = PKR 4,500
  - **Total: PKR 6,500**

---

For more details, see [README.md](README.md)
