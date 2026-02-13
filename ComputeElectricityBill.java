// Reading classes remain the same
class Reading {
    protected long value;
    public Reading(long value) { this.value = value; }
    public long getValue() { return value; }
}

class PreviousReading extends Reading {
    public PreviousReading(long value) { super(value); }
}

class CurrentReading extends Reading {
    public CurrentReading(long value) { super(value); }
}

// Base Abstract Class for Bill Calculation
abstract class CalculateBill {
    // billpay sirf unit cost ko store karega (Fixed charge aur tax baad mein lagega)
    protected double unitCost = 0; 
    protected long unitsConsumed;
    
    // Abstract method to calculate unit cost (Polymorphism)
    public abstract void calculateUnitCost(); 
    protected abstract double getFixedCharge();

    public long getUnitsConsumed() { return unitsConsumed; }
    public double getUnitCost() { return unitCost; }
    public double getNetPayable() { return unitCost + getFixedCharge(); }

    // Final method for common calculations (Taxes and Surcharges)
    public final double getFinalBill(PreviousReading prev, CurrentReading curr) {
        unitsConsumed = curr.getValue() - prev.getValue();

        if (unitsConsumed < 0) {
            JOptionPane.showMessageDialog(null, "Error: Current reading cannot be less than previous reading!");
            return 0; // Return 0 if units are negative
        }

        // Step 1: Calculate cost based on units (Implemented in subclasses)
        calculateUnitCost();
        
        // Step 2: Add Fixed Charge and get Net Payable
        double netPayable = unitCost + getFixedCharge();

        // Step 3: Add Government Tax (GST @ 17%)
        double gstRate = 0.17;
        double gstAmount = netPayable * gstRate;
        
        double totalBill = netPayable + gstAmount;
        
        return totalBill;
    }
}

// Subclass for Domestic Calculation (Slab Logic)
class DomesticBill extends CalculateBill {
    
    @Override
    protected void calculateUnitCost() {
        if (unitsConsumed < 100)
            unitCost = unitsConsumed * 20.0;
        else if (unitsConsumed <= 300)
            unitCost = 100 * 20.0 + (unitsConsumed - 100) * 30.0;
        else
            unitCost = 100 * 20.0 + 200 * 30.0 + (unitsConsumed - 300) * 40.0;
    }
    
    @Override
    protected double getFixedCharge() {
        return 150.00; // Domestic Fixed Charge
    }
}

// Subclass for Commercial Calculation (Slab Logic)
class CommercialBill extends CalculateBill {
    
    @Override
    protected void calculateUnitCost() {
        if (unitsConsumed < 100)
            unitCost = unitsConsumed * 25.0;
        else if (unitsConsumed <= 300)
            unitCost = 100 * 25.0 + (unitsConsumed - 100) * 35.0;
        else
            unitCost = 100 * 25.0 + 200 * 35.0 + (unitsConsumed - 300) * 45.0;
    }
    
    @Override
    protected double getFixedCharge() {
        return 500.00; // Commercial Fixed Charge
    }
}