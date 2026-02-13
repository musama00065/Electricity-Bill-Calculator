package com.electricity.billing;

import javax.swing.*;

/**
 * Main entry point for the Electricity Billing System application.
 * This class initializes and displays the GUI application.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class Main {
    
    /**
     * Main method that launches the application.
     * Uses SwingUtilities.invokeLater to ensure thread safety for GUI components.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Set system look and feel for better appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // If system look and feel fails, use default
            System.err.println("Warning: Could not set system look and feel. Using default.");
        }
        
        // Launch the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    /**
     * Creates and displays the main window.
     */
    private static void createAndShowGUI() {
        try {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error creating GUI: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                null,
                "Failed to initialize the application.\n" + e.getMessage(),
                "Initialization Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
