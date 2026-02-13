package com.electricity.billing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an electricity bill with all relevant information.
 * This class encapsulates bill details including customer info, readings, and calculated amount.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class Bill {
    private Customer customer;
    private PreviousReading previousReading;
    private CurrentReading currentReading;
    private long unitsConsumed;
    private double totalAmount;
    private LocalDateTime billDate;
    
    /**
     * Constructs a Bill object with customer and readings.
     * 
     * @param customer The customer for this bill
     * @param previousReading The previous meter reading
     * @param currentReading The current meter reading
     * @param totalAmount The calculated total amount
     */
    public Bill(Customer customer, PreviousReading previousReading, 
                CurrentReading currentReading, double totalAmount) {
        this.customer = customer;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.unitsConsumed = currentReading.getValue() - previousReading.getValue();
        this.totalAmount = totalAmount;
        this.billDate = LocalDateTime.now();
    }
    
    // Getters
    public Customer getCustomer() {
        return customer;
    }
    
    public PreviousReading getPreviousReading() {
        return previousReading;
    }
    
    public CurrentReading getCurrentReading() {
        return currentReading;
    }
    
    public long getUnitsConsumed() {
        return unitsConsumed;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public LocalDateTime getBillDate() {
        return billDate;
    }
    
    /**
     * Gets a formatted string representation of the bill date.
     * 
     * @return Formatted date string
     */
    public String getFormattedBillDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return billDate.format(formatter);
    }
    
    /**
     * Generates a detailed bill summary as a string.
     * 
     * @return Formatted bill summary
     */
    public String generateBillSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("===============================================\n");
        summary.append("        ELECTRICITY BILL STATEMENT\n");
        summary.append("===============================================\n\n");
        
        summary.append("Bill Date        : ").append(getFormattedBillDate()).append("\n");
        summary.append("Customer Name    : ").append(customer.hasValidName() ? customer.getName() : "N/A").append("\n");
        
        if (customer.getMeterNumber() != null && !customer.getMeterNumber().isEmpty()) {
            summary.append("Meter Number     : ").append(customer.getMeterNumber()).append("\n");
        }
        
        if (customer.getAddress() != null && !customer.getAddress().isEmpty()) {
            summary.append("Address          : ").append(customer.getAddress()).append("\n");
        }
        
        summary.append("Connection Type   : ").append(customer.getConnectionType()).append("\n");
        summary.append("-----------------------------------------------\n");
        summary.append("Previous Reading  : ").append(previousReading.getValue()).append(" kWh\n");
        summary.append("Current Reading   : ").append(currentReading.getValue()).append(" kWh\n");
        summary.append("Units Consumed    : ").append(unitsConsumed).append(" kWh\n");
        summary.append("-----------------------------------------------\n");
        summary.append("Total Amount Due  : PKR ").append(String.format("%.2f", totalAmount)).append("\n");
        summary.append("===============================================\n");
        summary.append("           THANK YOU FOR YOUR BUSINESS!\n");
        summary.append("===============================================\n");
        
        return summary.toString();
    }
    
    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                ", unitsConsumed=" + unitsConsumed +
                ", totalAmount=" + totalAmount +
                ", billDate=" + getFormattedBillDate() +
                '}';
    }
}
