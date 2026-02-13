package com.electricity.billing;

/**
 * Represents a customer in the electricity billing system.
 * This class stores customer information including name and connection type.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class Customer {
    private String name;
    private String connectionType;
    private String meterNumber;
    private String address;
    
    /**
     * Constructs a Customer object with name and connection type.
     * 
     * @param name The customer's name
     * @param connectionType The type of connection (Domestic/Commercial)
     */
    public Customer(String name, String connectionType) {
        this.name = name != null ? name.trim() : "";
        this.connectionType = connectionType != null ? connectionType.trim() : "";
    }
    
    /**
     * Constructs a Customer object with all details.
     * 
     * @param name The customer's name
     * @param connectionType The type of connection (Domestic/Commercial)
     * @param meterNumber The meter number
     * @param address The customer's address
     */
    public Customer(String name, String connectionType, String meterNumber, String address) {
        this.name = name != null ? name.trim() : "";
        this.connectionType = connectionType != null ? connectionType.trim() : "";
        this.meterNumber = meterNumber != null ? meterNumber.trim() : "";
        this.address = address != null ? address.trim() : "";
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name != null ? name.trim() : "";
    }
    
    public String getConnectionType() {
        return connectionType;
    }
    
    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType != null ? connectionType.trim() : "";
    }
    
    public String getMeterNumber() {
        return meterNumber;
    }
    
    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber != null ? meterNumber.trim() : "";
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address != null ? address.trim() : "";
    }
    
    /**
     * Checks if the customer has a valid name.
     * 
     * @return true if name is not empty, false otherwise
     */
    public boolean hasValidName() {
        return name != null && !name.isEmpty();
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", meterNumber='" + meterNumber + '\'' +
                '}';
    }
}
