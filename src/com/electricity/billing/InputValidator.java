package com.electricity.billing;

/**
 * Utility class for validating user inputs in the electricity billing system.
 * Provides static methods to validate various input types.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class InputValidator {
    
    /**
     * Validates if a string represents a valid positive long number.
     * 
     * @param input The input string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidLong(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        
        try {
            long value = Long.parseLong(input.trim());
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Parses a string to a long value, returning 0 if invalid.
     * 
     * @param input The input string to parse
     * @return The parsed long value, or 0 if invalid
     */
    public static long parseLong(String input) {
        if (!isValidLong(input)) {
            return 0;
        }
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    /**
     * Validates if a string is not empty (after trimming).
     * 
     * @param input The input string to validate
     * @return true if not empty, false otherwise
     */
    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }
    
    /**
     * Validates if a connection type is valid.
     * 
     * @param connectionType The connection type to validate
     * @return true if valid (Domestic or Commercial), false otherwise
     */
    public static boolean isValidConnectionType(String connectionType) {
        if (connectionType == null) {
            return false;
        }
        String type = connectionType.trim().toLowerCase();
        return type.equals("domestic") || type.equals("commercial");
    }
    
    /**
     * Validates if current reading is greater than or equal to previous reading.
     * 
     * @param previousReading The previous reading value
     * @param currentReading The current reading value
     * @return true if valid, false otherwise
     */
    public static boolean isValidReadingOrder(long previousReading, long currentReading) {
        return currentReading >= previousReading;
    }
    
    /**
     * Validates all inputs for bill calculation.
     * 
     * @param customerName The customer name (can be empty)
     * @param connectionType The connection type
     * @param previousReadingStr The previous reading as string
     * @param currentReadingStr The current reading as string
     * @return Validation result message, empty string if valid
     */
    public static String validateBillInputs(String customerName, String connectionType, 
                                           String previousReadingStr, String currentReadingStr) {
        if (!isValidConnectionType(connectionType)) {
            return "Please select a valid connection type (Domestic or Commercial).";
        }
        
        if (!isValidLong(previousReadingStr)) {
            return "Please enter a valid positive number for previous reading.";
        }
        
        if (!isValidLong(currentReadingStr)) {
            return "Please enter a valid positive number for current reading.";
        }
        
        long prevReading = parseLong(previousReadingStr);
        long currReading = parseLong(currentReadingStr);
        
        if (!isValidReadingOrder(prevReading, currReading)) {
            return "Current reading must be greater than or equal to previous reading.";
        }
        
        return ""; // Valid
    }
}
