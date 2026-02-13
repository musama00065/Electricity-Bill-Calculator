@echo off
echo ========================================
echo Running Electricity Billing System
echo ========================================
echo.

if not exist "bin\com\electricity\billing\Main.class" (
    echo Error: Application not compiled!
    echo Please run build.bat first.
    pause
    exit /b 1
)

java -cp bin com.electricity.billing.Main
