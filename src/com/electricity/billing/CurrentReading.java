package com.electricity.billing;

/**
 * Represents the current meter reading.
 * This class extends Reading to specifically represent the current meter reading.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class CurrentReading extends Reading {
    
    /**
     * Constructs a CurrentReading object with the specified value.
     * 
     * @param value The current meter reading value (in kWh)
     */
    public CurrentReading(long value) {
        super(value);
    }
}
