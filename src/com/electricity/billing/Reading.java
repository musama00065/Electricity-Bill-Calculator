package com.electricity.billing;

/**
 * Base class representing an electricity meter reading.
 * This class encapsulates the reading value from an electricity meter.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class Reading {
    protected long value;
    
    /**
     * Constructs a Reading object with the specified value.
     * 
     * @param value The meter reading value (in kWh)
     */
    public Reading(long value) {
        this.value = value;
    }
    
    /**
     * Gets the reading value.
     * 
     * @return The meter reading value
     */
    public long getValue() {
        return value;
    }
    
    /**
     * Sets the reading value.
     * 
     * @param value The new meter reading value
     */
    public void setValue(long value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
