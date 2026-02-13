@echo off
echo Compiling ElectricityBillingGUI.java...
javac ElectricityBillingGUI.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo Running application...
    java ElectricityBillingGUI
) else (
    echo Compilation failed!
    pause
)
