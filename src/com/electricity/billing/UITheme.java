package com.electricity.billing;

import java.awt.Color;
import java.awt.Font;

/**
 * Centralized theme configuration for the Electricity Billing System GUI.
 * Provides consistent colors, fonts, and styling across the application.
 * 
 * @author Electricity Billing System
 * @version 1.0
 */
public class UITheme {
    
    // Color Palette
    public static final Color PRIMARY_COLOR = new Color(33, 150, 243);      // Blue
    public static final Color PRIMARY_DARK = new Color(25, 118, 210);       // Dark Blue
    public static final Color PRIMARY_LIGHT = new Color(100, 181, 246);     // Light Blue
    public static final Color SECONDARY_COLOR = new Color(76, 175, 80);     // Green
    public static final Color ACCENT_COLOR = new Color(255, 152, 0);        // Orange
    public static final Color ERROR_COLOR = new Color(244, 67, 54);         // Red
    public static final Color SUCCESS_COLOR = new Color(76, 175, 80);       // Green
    
    // Background Colors
    public static final Color BACKGROUND_LIGHT = new Color(245, 245, 245);  // Light Gray
    public static final Color BACKGROUND_WHITE = Color.WHITE;
    public static final Color CARD_BACKGROUND = Color.WHITE;
    
    // Text Colors
    public static final Color TEXT_PRIMARY = new Color(33, 33, 33);        // Dark Gray
    public static final Color TEXT_SECONDARY = new Color(117, 117, 117);   // Medium Gray
    public static final Color TEXT_ON_PRIMARY = Color.WHITE;
    
    // Border Colors
    public static final Color BORDER_COLOR = new Color(224, 224, 224);     // Light Gray
    
    // Fonts
    public static final String FONT_FAMILY = "Segoe UI";
    public static final Font FONT_TITLE = new Font(FONT_FAMILY, Font.BOLD, 24);
    public static final Font FONT_HEADING = new Font(FONT_FAMILY, Font.BOLD, 18);
    public static final Font FONT_SUBHEADING = new Font(FONT_FAMILY, Font.BOLD, 14);
    public static final Font FONT_BODY = new Font(FONT_FAMILY, Font.PLAIN, 12);
    public static final Font FONT_BUTTON = new Font(FONT_FAMILY, Font.BOLD, 13);
    
    // Dimensions
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 650;
    public static final int COMPONENT_PADDING = 10;
    public static final int CARD_PADDING = 15;
    
    // Button Styles
    public static final Color BUTTON_PRIMARY_BG = PRIMARY_COLOR;
    public static final Color BUTTON_PRIMARY_FG = TEXT_ON_PRIMARY;
    public static final Color BUTTON_SECONDARY_BG = BACKGROUND_WHITE;
    public static final Color BUTTON_SECONDARY_FG = TEXT_PRIMARY;
    
    /**
     * Private constructor to prevent instantiation.
     */
    private UITheme() {
        // Utility class - no instantiation needed
    }
}
