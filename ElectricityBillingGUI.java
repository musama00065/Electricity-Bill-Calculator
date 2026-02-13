import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;

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

class CalculateBill {
    double billpay;

    public void Bill(PreviousReading prev, CurrentReading curr, String type) {
        long units = curr.getValue() - prev.getValue();

        if (units < 0) {
            JOptionPane.showMessageDialog(null, "Error: Current reading cannot be less than previous reading!");
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
            JOptionPane.showMessageDialog(null, "Invalid connection type!");
            billpay = 0;
        }
    }
}

public class ElectricityBillingGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Frame setup
        JFrame frame = new JFrame("Electricity Billing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        Color primary = new Color(33, 150, 243);
        Color background = new Color(245, 245, 245);
        Color cardBackground = Color.WHITE;

        frame.getContentPane().setBackground(background);

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(primary);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JLabel titleLabel = new JLabel("Electricity Bill Calculator");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        headerPanel.add(titleLabel);

        frame.add(headerPanel, BorderLayout.NORTH);

        // Main content panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        mainPanel.setBackground(background);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input card
        JPanel inputCard = new JPanel(new GridBagLayout());
        inputCard.setBackground(cardBackground);
        inputCard.setBorder(BorderFactory.createTitledBorder("Customer & Meter Details"));

        GridBagConstraints ic = new GridBagConstraints();
        ic.insets = new Insets(8, 8, 8, 8);
        ic.fill = GridBagConstraints.HORIZONTAL;
        ic.weightx = 1.0;

        int row = 0;

        // Customer name
        ic.gridx = 0;
        ic.gridy = row;
        ic.weightx = 0.3;
        inputCard.add(new JLabel("Customer Name:"), ic);

        JTextField fieldCustomerName = new JTextField();
        ic.gridx = 1;
        ic.gridy = row;
        ic.weightx = 0.7;
        inputCard.add(fieldCustomerName, ic);

        // Connection type
        row++;
        ic.gridx = 0;
        ic.gridy = row;
        ic.weightx = 0.3;
        inputCard.add(new JLabel("Connection Type:"), ic);

        String[] types = {"Domestic", "Commercial"};
        JComboBox<String> comboType = new JComboBox<>(types);
        ic.gridx = 1;
        ic.gridy = row;
        ic.weightx = 0.7;
        inputCard.add(comboType, ic);

        // Previous reading
        row++;
        ic.gridx = 0;
        ic.gridy = row;
        ic.weightx = 0.3;
        inputCard.add(new JLabel("Previous Reading (kWh):"), ic);

        JTextField textPrev = new JTextField();
        ic.gridx = 1;
        ic.gridy = row;
        ic.weightx = 0.7;
        inputCard.add(textPrev, ic);

        // Current reading
        row++;
        ic.gridx = 0;
        ic.gridy = row;
        ic.weightx = 0.3;
        inputCard.add(new JLabel("Current Reading (kWh):"), ic);

        JTextField textCurr = new JTextField();
        ic.gridx = 1;
        ic.gridy = row;
        ic.weightx = 0.7;
        inputCard.add(textCurr, ic);

        // Result card
        JPanel resultCard = new JPanel(new GridBagLayout());
        resultCard.setBackground(cardBackground);
        resultCard.setBorder(BorderFactory.createTitledBorder("Bill Summary"));

        GridBagConstraints rc = new GridBagConstraints();
        rc.insets = new Insets(6, 6, 6, 6);
        rc.fill = GridBagConstraints.HORIZONTAL;
        rc.weightx = 1.0;

        // Units consumed
        rc.gridx = 0;
        rc.gridy = 0;
        rc.weightx = 0.4;
        resultCard.add(new JLabel("Units Consumed:"), rc);

        JLabel labelUnitsValue = new JLabel("-");
        labelUnitsValue.setFont(new Font("Segoe UI", Font.BOLD, 14));
        rc.gridx = 1;
        rc.gridy = 0;
        rc.weightx = 0.6;
        resultCard.add(labelUnitsValue, rc);

        // Total amount
        rc.gridx = 0;
        rc.gridy = 1;
        rc.weightx = 0.4;
        resultCard.add(new JLabel("Total Amount (PKR):"), rc);

        JLabel labelAmountValue = new JLabel("-");
        labelAmountValue.setFont(new Font("Segoe UI", Font.BOLD, 14));
        rc.gridx = 1;
        rc.gridy = 1;
        rc.weightx = 0.6;
        resultCard.add(labelAmountValue, rc);

        // Detailed area
        rc.gridx = 0;
        rc.gridy = 2;
        rc.gridwidth = 2;
        rc.weightx = 1.0;
        rc.fill = GridBagConstraints.BOTH;
        rc.weighty = 1.0;

        JTextArea textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        resultCard.add(scrollPane, rc);

        // Add cards to main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(inputCard, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(resultCard, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.setBackground(background);

        JButton btnCalculate = new JButton("Calculate");
        JButton btnReset = new JButton("Reset");
        JButton btnExit = new JButton("Exit");

        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnExit);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = fieldCustomerName.getText().trim();
                    String type = comboType.getSelectedItem().toString();
                    long prevVal = Long.parseLong(textPrev.getText().trim());
                    long currVal = Long.parseLong(textCurr.getText().trim());

                    PreviousReading prev = new PreviousReading(prevVal);
                    CurrentReading curr = new CurrentReading(currVal);

                    CalculateBill bill = new CalculateBill();
                    bill.Bill(prev, curr, type);

                    long unitsConsumed = currVal - prevVal;

                    labelUnitsValue.setText(String.valueOf(unitsConsumed));
                    labelAmountValue.setText(String.format("PKR %.2f", bill.billpay));

                    StringBuilder output = new StringBuilder();
                    output.append("Customer Name : ")
                            .append(name.isEmpty() ? "N/A" : name)
                            .append("\n");
                    output.append("Connection Type : ").append(type).append("\n");
                    output.append("Previous Reading : ").append(prevVal).append(" kWh\n");
                    output.append("Current Reading  : ").append(currVal).append(" kWh\n");
                    output.append("Units Consumed   : ").append(unitsConsumed).append(" kWh\n");
                    output.append("Total Amount     : ")
                            .append(String.format("PKR %.2f", bill.billpay))
                            .append("\n");
                    output.append("---------------------------------------------\n");
                    output.append("THANK YOU!");

                    textArea.setText(output.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid input! Please enter numeric values for readings.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,
                            "An unexpected error occurred: " + ex.getMessage());
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldCustomerName.setText("");
                textPrev.setText("");
                textCurr.setText("");
                comboType.setSelectedIndex(0);
                labelUnitsValue.setText("-");
                labelAmountValue.setText("-");
                textArea.setText("");
                fieldCustomerName.requestFocus();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
