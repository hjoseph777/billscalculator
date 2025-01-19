package com.example.fewestbills;

public class BillsCalculatorClass {

    // Constants for different bill denominations in cents
    private static final int TWENTY_DOLLARS = 2000;  // in cents
    private static final int TEN_DOLLARS = 1000;
    private static final int FIVE_DOLLARS = 500;
    private static final int TOONIE = 200;
    private static final int LOONIE = 100;
    private static final int QUARTER = 25;
    private static final int DIME = 10;
    private static final int NICKEL = 5;

    // ANSI escape codes for blue text
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static String calculateFewestBills(double money) {
        // Input validation
        if (money < 0) {
            return "Error: Amount cannot be negative.";
        } else if (money == 0) {
            return "No change needed.";
        }

        // Convert to cents to avoid floating-point issues
        int cents = (int) Math.round(money * 100);

        int twenties = cents / TWENTY_DOLLARS;
        int remainder = cents % TWENTY_DOLLARS;

        int tens = remainder / TEN_DOLLARS;
        remainder %= TEN_DOLLARS;

        int fives = remainder / FIVE_DOLLARS;
        remainder %= FIVE_DOLLARS;

        int toonies = remainder / TOONIE;
        remainder %= TOONIE;

        int loonies = remainder / LOONIE;
        remainder %= LOONIE;

        int quarters = remainder / QUARTER;
        remainder %= QUARTER;

        int dimes = remainder / DIME;
        remainder %= DIME;

        int nickels = remainder / NICKEL;
        remainder %= NICKEL;

        int pennies = remainder;

        
        // Format and return the result with blue values
       
            return String.format(
                "Change for $%.2f:\n\n" +
                "  - Twenties: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Tens: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Fives: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Toonies: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Loonies: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Quarters: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Dimes: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Nickels: " + ANSI_BLUE + "%d" + ANSI_RESET + "\n" +
                "  - Pennies: " + ANSI_BLUE + "%d" + ANSI_RESET,
                money, twenties, tens, fives, toonies, loonies, quarters, dimes, nickels, pennies
            );
    }


}
