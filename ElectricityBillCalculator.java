import java.util.Scanner;

class ElectricityBill {

    private int consumerNo;
    private String consumerName;
    private int prevReading;
    private int currReading;
    private String ebType;

    public ElectricityBill(int consumerNo, String consumerName, int prevReading, int currReading, String ebType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.prevReading = prevReading;
        this.currReading = currReading;
        this.ebType = ebType;
    }

    public double calculateBill() {
        int unitsConsumed = currReading - prevReading;
        double amount = 0;

        if (ebType.equalsIgnoreCase("domestic")) {

            if (unitsConsumed <= 100)
                amount = unitsConsumed * 5.0;
            else if (unitsConsumed <= 200)
                amount = 100 * 5.0 + (unitsConsumed - 100) * 10.0;
            else if (unitsConsumed <= 500)
                amount = 100 * 5.0 + 100 * 10.0 + (unitsConsumed - 200) * 15.0;
            else
                amount = 100 * 5.0 + 100 * 10.0 + 300 * 15.0 + (unitsConsumed - 500) * 20.0;

        } else if (ebType.equalsIgnoreCase("commercial")) {

            if (unitsConsumed <= 100)
                amount = unitsConsumed * 10.0;
            else if (unitsConsumed <= 200)
                amount = 100 * 10.0 + (unitsConsumed - 100) * 15.0;
            else if (unitsConsumed <= 500)
                amount = 100 * 10.0 + 100 * 15.0 + (unitsConsumed - 200) * 20.0;
            else
                amount = 100 * 10.0 + 100 * 15.0 + 300 * 20.0 + (unitsConsumed - 500) * 25.0;

        } else {
            System.out.println("Invalid connection type!");
        }

        return amount;
    }

    public void displayBill() {
        System.out.println("\nElectricity Bill");
        System.out.println("Consumer Number: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Units Consumed: " + (currReading - prevReading));
        System.out.println("Type of Connection: " + ebType);
        System.out.println("Bill Amount: Rs. " + calculateBill());
    }
}

public class ElectricityBillCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        int consumerNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        String consumerName = sc.nextLine();

        System.out.print("Enter Previous Month Reading: ");
        int prevReading = sc.nextInt();

        System.out.print("Enter Current Month Reading: ");
        int currReading = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Type of EB Connection (Domestic/Commercial): ");
        String ebType = sc.nextLine();

        ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, prevReading, currReading, ebType);
        bill.displayBill();

        sc.close();
    }
}
