import java.util.*;
import java.lang.Math;

class Reading {
    protected long value;

    public Reading(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}

class PreviousReading extends Reading {
    public PreviousReading(long value) {
        super(value);
    }
}

class CurrentReading extends Reading {
    public CurrentReading(long value) {
        super(value);
    }
}

class CalculateBill {
    double billpay;

    public void Bill(PreviousReading prev, CurrentReading curr, String type) {
        long units = curr.getValue() - prev.getValue();

        if (units < 0) {
            System.out.println("Error: Current reading cannot be less than previous reading!");
            billpay = 0;
            return;
        }

        if (type.equalsIgnoreCase("domestic")) {
            if (units < 100)
                billpay = units * 20.0;
            else if (units <= 300)
                billpay = 100 * 20.0 + (units - 100) * 30.0;
            else
                billpay = 100 * 20.0 + 200 * 30.0 + (units - 300) * 40.0;

        } else if (type.equalsIgnoreCase("commercial")) {
            if (units < 100)
                billpay = units * 25.0;
            else if (units <= 300)
                billpay = 100 * 25.0 + (units - 100) * 35.0;
            else
                billpay = 100 * 25.0 + 200 * 35.0 + (units - 300) * 45.0;
        } else {
            System.out.println("Invalid connection type!");
            billpay = 0;
        }
    }
}

public class ElectricityBillingSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------------------");
        System.out.println("            ELECTRICITY BILL CALCULATOR");
        System.out.println("----------------------------------------------------");

        System.out.print("Enter Connection Type (Domestic / Commercial): ");
        String type = sc.nextLine().trim();

        System.out.print("Enter Previous Month Reading: ");
        long prevVal = sc.nextLong();
        PreviousReading prev = new PreviousReading(prevVal);

        System.out.print("Enter Current Month Reading: ");
        long currVal = sc.nextLong();
        CurrentReading curr = new CurrentReading(currVal);

        CalculateBill bill = new CalculateBill();
        bill.Bill(prev, curr, type);

        long unitsConsumed = curr.getValue() - prev.getValue();

        System.out.println("-----------------------------------------------------------");
        System.out.println("Connection Type : " + type);
        System.out.println("Previous Reading: " + prev.getValue());
        System.out.println("Current Reading : " + curr.getValue());
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Total Amount to be paid : PKR " + Math.round(bill.billpay * 100.0) / 100.0);
        System.out.println("-----------------------------------------------------------");
        System.out.println("THANK YOU!");
        System.out.println("-----------------------------------------------------------");
    }
}
