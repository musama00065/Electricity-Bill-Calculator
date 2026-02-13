#!/bin/bash

echo "========================================"
echo "Running Electricity Billing System"
echo "========================================"
echo ""

if [ ! -f "bin/com/electricity/billing/Main.class" ]; then
    echo "Error: Application not compiled!"
    echo "Please run build.sh first."
    exit 1
fi

java -cp bin com.electricity.billing.Main
