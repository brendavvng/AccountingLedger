package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class AccountingLedgerApp {

    // importing static scanner to read user input
    // static = it belongs to class itself, not a specific object
    static Scanner theScanner = new Scanner(System.in);
    // file name for the transactions
    static String ledgerFile = "transactions.csv";
    // creating date and time formatters
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {

        // creating home page
        System.out.println("\nWelcome to the Account Ledger!");
        System.out.println("Please choose one of the following options: (D, P, L, or X)");
        System.out.println("-------------------------------------------");
        System.out.println("(D) - Add a Deposit");
        System.out.println("(P) - Make a Payment (Debit)");
        System.out.println("(L) - View Ledger");
        System.out.println("(X) - Exit");

        // declaring variable to store user input
        String userInput;
        // declaring variable to store the letter choice
        String choice = "";
        // declaring variable to indicate if user wants to exit program, starts as false
        boolean willExit = false;

        // creating while loop that will continue to run until user submits in a valid choice or chooses to exit
        while(!willExit) {
            // prompts user for input
            System.out.print("Enter choice: ");
            // reads the entire line entered by user and stores it in "userInput"
            userInput = theScanner.nextLine();
            System.out.println("-------------------------------------------");

            // checking if user entered in letter "D"
            switch (userInput.trim().toUpperCase()) {
                // stores the valid choice
                case "D":
                    choice = "D";
                // this line will run when user chooses this option
                    System.out.println("You selected option D: Add a Deposit. Now loading option D...");
                    addTransaction(choice);
                    break;
                case "P":
                    choice = "P";
                    System.out.println("You selected option P: Make Payment (Debit). Now loading option P...");
                    addTransaction(choice);
                    break;
                case "L":
                    choice = "L";
                    System.out.println("You selected option L: View Ledger. Now loading option P...");
                    displayLedger();
                    break;
                case "X":
                    willExit = true;
                    System.out.println("You selected option X. Now exiting the system. Goodbye! ");
                    break;

            }

        }

    }
    private static void addTransaction(String transactionType) {
        System.out.println("Enter information below:");

        System.out.print("Description: ");
        String description = theScanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = theScanner.nextLine();

        System.out.print("Amount: ");
        double amount;
        // reading amount as string first
        double amountStr = theScanner.nextDouble();
        try {
            amount = Double.parseDouble(String.valueOf(amountStr));
        } catch (Exception e) {
            System.out.println("Invalid amount format. Transaction not added.");
            return;
        }

        // get current date and time
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        Transactions transaction = new Transactions(date, time, description, vendor, amount);

        try (PrintWriter pw = new PrintWriter(new FileWriter(ledgerFile, true))) {
            // format the transaction data and write it to the file
            pw.printf("%s | %s | %s | %s | %.2f | %s%n",
                    transaction.getDate().format(dateFormatter),
                    transaction.getTime().format(timeFormatter),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount(),
                    transactionType);
            System.out.print("Added to ledger. What would you like to do next? ");
        } catch (Exception e) {
            System.out.print("Error writing to file. Error message: " + e.getMessage());
        }

    } private static void displayLedger() {
        System.out.println("\nLedger: ");
        // code to read from the file and display
        try (BufferedReader buffReader = new BufferedReader(new FileReader(ledgerFile))) {
            String line;
            while ((line = buffReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.print("Error reading the ledger file: " + e.getMessage());
        }
    }

}
