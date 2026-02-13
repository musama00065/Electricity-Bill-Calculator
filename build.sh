#!/bin/bash

echo "========================================"
echo "Building Electricity Billing System"
echo "========================================"
echo ""

mkdir -p bin

echo "Compiling Java files..."
javac -encoding UTF-8 -d bin -sourcepath src src/com/electricity/billing/*.java

if [ $? -eq 0 ]; then
    echo ""
    echo "========================================"
    echo "Build successful!"
    echo "========================================"
    echo ""
    echo "To run the application:"
    echo "  java -cp bin com.electricity.billing.Main"
    echo ""
else
    echo ""
    echo "========================================"
    echo "Build failed!"
    echo "========================================"
    exit 1
fi
