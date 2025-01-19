package com.example.fewestbills;

import java.util.logging.Logger;

public class FewestbillsErrorhandlingClass {
    private static final Logger logger = Logger.getLogger(FewestbillsErrorhandlingClass.class.getName());
   
    public static void handleException(Exception e) {
        logger.severe("An error occurred: " + e.getMessage());
        System.out.println("An error occurred. Please check the logs for details.");
    }

    
    public static void handleInvalidInput(String message) {
        if (message == null || message.trim().isEmpty()) {
            message = "Please enter a valid number"; // Default message
        }
        logger.warning("Invalid input provided by the user: " + message);
        System.out.println("Error: " + message);
    }

    
    public static String validateInput(String input) {
        if (input.isEmpty()) {
            return "You need to enter a dollar value to continue.";
        } else if (!input.matches("-?\\d+(\\.\\d+)?")) {
            return "Please enter a valid number.";
        } else if (Double.parseDouble(input) < 0) {
            return "Error: Amount cannot be negative.";
        }
        return null;
    }
}
