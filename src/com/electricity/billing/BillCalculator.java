package com.electricity.billing;

/**
 * Calculates electricity bills based on meter readings and connection type.
 * This class implements a tiered pricing structure for different connection types.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class BillCalculator {
    
    // Domestic rates (PKR per kWh)
    private static final double DOMESTIC_RATE_TIER1 = 20.0;  // 0-100 units
    private static final double DOMESTIC_RATE_TIER2 = 30.0;  // 101-300 units
    private static final double DOMESTIC_RATE_TIER3 = 40.0;  // Above 300 units
    
    // Commercial rates (PKR per kWh)
    private static final double COMMERCIAL_RATE_TIER1 = 25.0;  // 0-100 units
    private static final double COMMERCIAL_RATE_TIER2 = 35.0;  // 101-300 units
    private static final double COMMERCIAL_RATE_TIER3 = 45.0;  // Above 300 units
    
    // Tier thresholds
    private static final long TIER1_THRESHOLD = 100;
    private static final long TIER2_THRESHOLD = 300;
    
    /**
     * Calculates the bill amount based on readings and connection type.
     * 
     * @param previousReading The previous meter reading
     * @param currentReading The current meter reading
     * @param connectionType The connection type (Domestic/Commercial)
     * @return The calculated bill amount, or 0 if invalid
     * @throws IllegalArgumentException if readings are invalid or connection type is unknown
     */
    public double calculateBill(PreviousReading previousReading, 
                                CurrentReading currentReading, 
                                String connectionType) throws IllegalArgumentException {
        
        long units = currentReading.getValue() - previousReading.getValue();
        
        // Validate readings
        if (units < 0) {
            throw new IllegalArgumentException(
                "Error: Current reading cannot be less than previous reading!");
        }
        
        if (previousReading.getValue() < 0 || currentReading.getValue() < 0) {
            throw new IllegalArgumentException(
                "Error: Meter readings cannot be negative!");
        }
        
        // Calculate based on connection type
        if (connectionType.equalsIgnoreCase("domestic")) {
            return calculateDomesticBill(units);
        } else if (connectionType.equalsIgnoreCase("commercial")) {
            return calculateCommercialBill(units);
        } else {
            throw new IllegalArgumentException(
                "Invalid connection type! Must be 'Domestic' or 'Commercial'.");
        }
    }
    
    /**
     * Calculates bill for domestic connection using tiered pricing.
     * 
     * @param units The number of units consumed
     * @return The calculated bill amount
     */
    private double calculateDomesticBill(long units) {
        double billAmount = 0.0;
        
        if (units <= TIER1_THRESHOLD) {
            // Tier 1: 0-100 units
            billAmount = units * DOMESTIC_RATE_TIER1;
        } else if (units <= TIER2_THRESHOLD) {
            // Tier 1: 0-100 units
            billAmount = TIER1_THRESHOLD * DOMESTIC_RATE_TIER1;
            // Tier 2: 101-300 units
            billAmount += (units - TIER1_THRESHOLD) * DOMESTIC_RATE_TIER2;
        } else {
            // Tier 1: 0-100 units
            billAmount = TIER1_THRESHOLD * DOMESTIC_RATE_TIER1;
            // Tier 2: 101-300 units
            billAmount += (TIER2_THRESHOLD - TIER1_THRESHOLD) * DOMESTIC_RATE_TIER2;
            // Tier 3: Above 300 units
            billAmount += (units - TIER2_THRESHOLD) * DOMESTIC_RATE_TIER3;
        }
        
        return billAmount;
    }
    
    /**
     * Calculates bill for commercial connection using tiered pricing.
     * 
     * @param units The number of units consumed
     * @return The calculated bill amount
     */
    private double calculateCommercialBill(long units) {
        double billAmount = 0.0;
        
        if (units <= TIER1_THRESHOLD) {
            // Tier 1: 0-100 units
            billAmount = units * COMMERCIAL_RATE_TIER1;
        } else if (units <= TIER2_THRESHOLD) {
            // Tier 1: 0-100 units
            billAmount = TIER1_THRESHOLD * COMMERCIAL_RATE_TIER1;
            // Tier 2: 101-300 units
            billAmount += (units - TIER1_THRESHOLD) * COMMERCIAL_RATE_TIER2;
        } else {
            // Tier 1: 0-100 units
            billAmount = TIER1_THRESHOLD * COMMERCIAL_RATE_TIER1;
            // Tier 2: 101-300 units
            billAmount += (TIER2_THRESHOLD - TIER1_THRESHOLD) * COMMERCIAL_RATE_TIER2;
            // Tier 3: Above 300 units
            billAmount += (units - TIER2_THRESHOLD) * COMMERCIAL_RATE_TIER3;
        }
        
        return billAmount;
    }
    
    /**
     * Gets the pricing information for a connection type.
     * 
     * @param connectionType The connection type
     * @return Formatted string with pricing information
     */
    public String getPricingInfo(String connectionType) {
        StringBuilder info = new StringBuilder();
        info.append("Pricing Structure (").append(connectionType).append("):\n");
        
        if (connectionType.equalsIgnoreCase("domestic")) {
            info.append("  • 0-100 units    : PKR ").append(DOMESTIC_RATE_TIER1).append(" per kWh\n");
            info.append("  • 101-300 units  : PKR ").append(DOMESTIC_RATE_TIER2).append(" per kWh\n");
            info.append("  • Above 300 units: PKR ").append(DOMESTIC_RATE_TIER3).append(" per kWh\n");
        } else if (connectionType.equalsIgnoreCase("commercial")) {
            info.append("  • 0-100 units    : PKR ").append(COMMERCIAL_RATE_TIER1).append(" per kWh\n");
            info.append("  • 101-300 units  : PKR ").append(COMMERCIAL_RATE_TIER2).append(" per kWh\n");
            info.append("  • Above 300 units: PKR ").append(COMMERCIAL_RATE_TIER3).append(" per kWh\n");
        }
        
        return info.toString();
    }
}
