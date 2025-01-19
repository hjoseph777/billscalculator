package com.example.fewestbills;

import java.util.Scanner;

public class FewestBillsApp {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = ""; //add a new line to the output
            System.out.println("\n\n\n" + "--------Welcome to the Fewest Bills Calculator!----------");
            
            while (true) {
                System.out.print("Enter the dollar amount (e.g., 37.70): ");
                input = scanner.nextLine().trim();

                String validationResult = FewestbillsErrorhandlingClass.validateInput(input);
                if (validationResult == null) {
                    break;
                } else {
                    System.out.println("\n\n" + validationResult);
                }
            }

            double money = Double.parseDouble(input);
            String output = BillsCalculatorClass.calculateFewestBills(money);
            System.out.println(output);
        } catch (Exception error) { // Changed 'e' to 'error'
            FewestbillsErrorhandlingClass.handleException(error); // Pass 'error' to the handler
        }
    }
}