package com.electricity.billing;

/**
 * Represents the previous meter reading.
 * This class extends Reading to specifically represent historical meter readings.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class PreviousReading extends Reading {
    
    /**
     * Constructs a PreviousReading object with the specified value.
     * 
     * @param value The previous meter reading value (in kWh)
     */
    public PreviousReading(long value) {
        super(value);
    }
}
