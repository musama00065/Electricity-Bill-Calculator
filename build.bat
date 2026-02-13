@echo off
echo ========================================
echo Building Electricity Billing System
echo ========================================
echo.

if not exist "bin" mkdir bin

echo Compiling Java files...
javac -encoding UTF-8 -d bin -sourcepath src src/com/electricity/billing/*.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo Build successful!
    echo ========================================
    echo.
    echo To run the application:
    echo   java -cp bin com.electricity.billing.Main
    echo.
) else (
    echo.
    echo ========================================
    echo Build failed!
    echo ========================================
    exit /b 1
)
