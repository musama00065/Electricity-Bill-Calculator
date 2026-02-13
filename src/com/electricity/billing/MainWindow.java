package com.electricity.billing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Main GUI window for the Electricity Billing System.
 * Provides a modern, user-friendly interface for calculating electricity bills.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class MainWindow extends JFrame {
    
    // Components
    private JTextField fieldCustomerName;
    private JTextField fieldMeterNumber;
    private JTextArea fieldAddress;
    private JComboBox<String> comboConnectionType;
    private JTextField fieldPreviousReading;
    private JTextField fieldCurrentReading;
    
    private JLabel labelUnitsValue;
    private JLabel labelAmountValue;
    private JTextArea textAreaBillSummary;
    
    private JButton btnCalculate;
    private JButton btnReset;
    private JButton btnExit;
    private JButton btnPricingInfo;
    
    private BillCalculator billCalculator;
    
    /**
     * Constructs the main window and initializes all components.
     */
    public MainWindow() {
        billCalculator = new BillCalculator();
        initializeComponents();
        setupLayout();
        attachEventHandlers();
        setWindowProperties();
    }
    
    /**
     * Initializes all GUI components.
     */
    private void initializeComponents() {
        // Input fields
        fieldCustomerName = createTextField();
        fieldMeterNumber = createTextField();
        fieldAddress = new JTextArea(3, 20);
        fieldAddress.setLineWrap(true);
        fieldAddress.setWrapStyleWord(true);
        fieldAddress.setFont(UITheme.FONT_BODY);
        
        String[] connectionTypes = {"Domestic", "Commercial"};
        comboConnectionType = new JComboBox<>(connectionTypes);
        comboConnectionType.setFont(UITheme.FONT_BODY);
        
        fieldPreviousReading = createTextField();
        fieldCurrentReading = createTextField();
        
        // Result labels
        labelUnitsValue = new JLabel("-");
        labelUnitsValue.setFont(UITheme.FONT_SUBHEADING);
        labelUnitsValue.setForeground(UITheme.PRIMARY_COLOR);
        
        labelAmountValue = new JLabel("-");
        labelAmountValue.setFont(UITheme.FONT_SUBHEADING);
        labelAmountValue.setForeground(UITheme.SUCCESS_COLOR);
        
        // Bill summary text area
        textAreaBillSummary = new JTextArea(10, 30);
        textAreaBillSummary.setEditable(false);
        textAreaBillSummary.setLineWrap(true);
        textAreaBillSummary.setWrapStyleWord(true);
        textAreaBillSummary.setFont(new Font("Courier New", Font.PLAIN, 11));
        textAreaBillSummary.setBackground(UITheme.BACKGROUND_LIGHT);
        
        // Buttons
        btnCalculate = createPrimaryButton("Calculate Bill");
        btnReset = createSecondaryButton("Reset");
        btnExit = createSecondaryButton("Exit");
        btnPricingInfo = createSecondaryButton("Pricing Info");
    }
    
    /**
     * Creates a styled text field.
     */
    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(UITheme.FONT_BODY);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UITheme.BORDER_COLOR),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        return field;
    }
    
    /**
     * Creates a primary styled button.
     */
    private JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(UITheme.FONT_BUTTON);
        button.setBackground(UITheme.BUTTON_PRIMARY_BG);
        button.setForeground(UITheme.BUTTON_PRIMARY_FG);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 35));
        return button;
    }
    
    /**
     * Creates a secondary styled button.
     */
    private JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(UITheme.FONT_BUTTON);
        button.setBackground(UITheme.BUTTON_SECONDARY_BG);
        button.setForeground(UITheme.BUTTON_SECONDARY_FG);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(UITheme.BORDER_COLOR));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(100, 35));
        return button;
    }
    
    /**
     * Sets up the layout of the window.
     */
    private void setupLayout() {
        setLayout(new BorderLayout(UITheme.COMPONENT_PADDING, UITheme.COMPONENT_PADDING));
        getContentPane().setBackground(UITheme.BACKGROUND_LIGHT);
        
        // Header
        add(createHeader(), BorderLayout.NORTH);
        
        // Main content
        add(createMainContent(), BorderLayout.CENTER);
        
        // Footer buttons
        add(createButtonPanel(), BorderLayout.SOUTH);
    }
    
    /**
     * Creates the header panel.
     */
    private JPanel createHeader() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(UITheme.PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel titleLabel = new JLabel("⚡ Electricity Billing System");
        titleLabel.setFont(UITheme.FONT_TITLE);
        titleLabel.setForeground(UITheme.TEXT_ON_PRIMARY);
        
        headerPanel.add(titleLabel);
        return headerPanel;
    }
    
    /**
     * Creates the main content panel with input and result cards.
     */
    private JPanel createMainContent() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(UITheme.BACKGROUND_LIGHT);
        mainPanel.setBorder(new EmptyBorder(UITheme.CARD_PADDING, UITheme.CARD_PADDING, 
                                           UITheme.CARD_PADDING, UITheme.CARD_PADDING));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        
        // Input card
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(createInputCard(), gbc);
        
        // Result card
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(createResultCard(), gbc);
        
        return mainPanel;
    }
    
    /**
     * Creates the input card panel.
     */
    private JPanel createInputCard() {
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(UITheme.CARD_BACKGROUND);
        card.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(UITheme.BORDER_COLOR),
            "Customer & Meter Information",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            UITheme.FONT_SUBHEADING
        ));
        card.setBorder(BorderFactory.createCompoundBorder(
            card.getBorder(),
            new EmptyBorder(UITheme.CARD_PADDING, UITheme.CARD_PADDING, 
                          UITheme.CARD_PADDING, UITheme.CARD_PADDING)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        int row = 0;
        
        // Customer Name
        addLabelAndField(card, gbc, row++, "Customer Name:", fieldCustomerName);
        
        // Meter Number
        addLabelAndField(card, gbc, row++, "Meter Number:", fieldMeterNumber);
        
        // Address
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;
        card.add(new JLabel("Address:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = row++;
        gbc.weightx = 0.7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.3;
        JScrollPane addressScroll = new JScrollPane(fieldAddress);
        addressScroll.setBorder(BorderFactory.createLineBorder(UITheme.BORDER_COLOR));
        card.add(addressScroll, gbc);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Connection Type
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;
        card.add(new JLabel("Connection Type:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = row++;
        gbc.weightx = 0.7;
        card.add(comboConnectionType, gbc);
        
        // Separator
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        card.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;
        
        // Previous Reading
        addLabelAndField(card, gbc, row++, "Previous Reading (kWh):", fieldPreviousReading);
        
        // Current Reading
        addLabelAndField(card, gbc, row++, "Current Reading (kWh):", fieldCurrentReading);
        
        return card;
    }
    
    /**
     * Helper method to add a label and field to a panel.
     */
    private void addLabelAndField(JPanel panel, GridBagConstraints gbc, int row, 
                                  String labelText, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;
        JLabel label = new JLabel(labelText);
        label.setFont(UITheme.FONT_BODY);
        panel.add(label, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 0.7;
        panel.add(field, gbc);
    }
    
    /**
     * Creates the result card panel.
     */
    private JPanel createResultCard() {
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(UITheme.CARD_BACKGROUND);
        card.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(UITheme.BORDER_COLOR),
            "Bill Summary",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            UITheme.FONT_SUBHEADING
        ));
        card.setBorder(BorderFactory.createCompoundBorder(
            card.getBorder(),
            new EmptyBorder(UITheme.CARD_PADDING, UITheme.CARD_PADDING, 
                          UITheme.CARD_PADDING, UITheme.CARD_PADDING)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Units Consumed
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        JLabel unitsLabel = new JLabel("Units Consumed:");
        unitsLabel.setFont(UITheme.FONT_BODY);
        card.add(unitsLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        card.add(labelUnitsValue, gbc);
        
        // Total Amount
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.4;
        JLabel amountLabel = new JLabel("Total Amount (PKR):");
        amountLabel.setFont(UITheme.FONT_BODY);
        card.add(amountLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.6;
        card.add(labelAmountValue, gbc);
        
        // Separator
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        card.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;
        
        // Bill Summary Text Area
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane scrollPane = new JScrollPane(textAreaBillSummary);
        scrollPane.setBorder(BorderFactory.createLineBorder(UITheme.BORDER_COLOR));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        card.add(scrollPane, gbc);
        
        return card;
    }
    
    /**
     * Creates the button panel.
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.setBackground(UITheme.BACKGROUND_LIGHT);
        buttonPanel.setBorder(new EmptyBorder(5, 10, 10, 10));
        
        buttonPanel.add(btnPricingInfo);
        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnExit);
        
        return buttonPanel;
    }
    
    /**
     * Attaches event handlers to components.
     */
    private void attachEventHandlers() {
        // Calculate button
        btnCalculate.addActionListener(e -> calculateBill());
        
        // Reset button
        btnReset.addActionListener(e -> resetForm());
        
        // Exit button
        btnExit.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        
        // Pricing Info button
        btnPricingInfo.addActionListener(e -> showPricingInfo());
        
        // Enter key support for text fields
        KeyAdapter enterKeyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateBill();
                }
            }
        };
        
        fieldPreviousReading.addKeyListener(enterKeyAdapter);
        fieldCurrentReading.addKeyListener(enterKeyAdapter);
    }
    
    /**
     * Calculates the bill and updates the display.
     */
    private void calculateBill() {
        String customerName = fieldCustomerName.getText().trim();
        String meterNumber = fieldMeterNumber.getText().trim();
        String address = fieldAddress.getText().trim();
        String connectionType = (String) comboConnectionType.getSelectedItem();
        String prevReadingStr = fieldPreviousReading.getText().trim();
        String currReadingStr = fieldCurrentReading.getText().trim();
        
        // Validate inputs
        String validationError = InputValidator.validateBillInputs(
            customerName, connectionType, prevReadingStr, currReadingStr
        );
        
        if (!validationError.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                validationError,
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        try {
            // Parse readings
            long prevReading = InputValidator.parseLong(prevReadingStr);
            long currReading = InputValidator.parseLong(currReadingStr);
            
            // Create objects
            Customer customer = new Customer(customerName, connectionType, meterNumber, address);
            PreviousReading previousReading = new PreviousReading(prevReading);
            CurrentReading currentReading = new CurrentReading(currReading);
            
            // Calculate bill
            double totalAmount = billCalculator.calculateBill(
                previousReading, currentReading, connectionType
            );
            
            // Create bill object
            Bill bill = new Bill(customer, previousReading, currentReading, totalAmount);
            
            // Update display
            labelUnitsValue.setText(String.valueOf(bill.getUnitsConsumed()) + " kWh");
            labelAmountValue.setText(String.format("PKR %.2f", bill.getTotalAmount()));
            textAreaBillSummary.setText(bill.generateBillSummary());
            
            // Success message
            JOptionPane.showMessageDialog(
                this,
                "Bill calculated successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Calculation Error",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "An unexpected error occurred: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    /**
     * Resets the form to its initial state.
     */
    private void resetForm() {
        fieldCustomerName.setText("");
        fieldMeterNumber.setText("");
        fieldAddress.setText("");
        comboConnectionType.setSelectedIndex(0);
        fieldPreviousReading.setText("");
        fieldCurrentReading.setText("");
        labelUnitsValue.setText("-");
        labelAmountValue.setText("-");
        textAreaBillSummary.setText("");
        fieldCustomerName.requestFocus();
    }
    
    /**
     * Shows pricing information dialog.
     */
    private void showPricingInfo() {
        String connectionType = (String) comboConnectionType.getSelectedItem();
        String info = billCalculator.getPricingInfo(connectionType);
        
        JOptionPane.showMessageDialog(
            this,
            info,
            "Pricing Information",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * Sets window properties.
     */
    private void setWindowProperties() {
        setTitle("Electricity Billing System");
        setSize(UITheme.WINDOW_WIDTH, UITheme.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        
        // Set application icon (if available)
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        } catch (Exception e) {
            // Icon not found, continue without it
        }
    }
}
