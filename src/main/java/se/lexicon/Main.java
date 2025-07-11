package se.lexicon;

import se.lexicon.model.*;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Setting up a Vending Machine with a set Product[] of products fron class Setup:
        VendingMachineClass vendingMachine = Setup.createVendingMachine();

        System.out.println("Welcome to the Vending Machine!");

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add Currency");
            System.out.println("3. Buy Product");
            System.out.println("4. Check Balance");
            System.out.println("5. End Session");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    for (String productInfo : vendingMachine.getProducts()) {
                    System.out.println(productInfo);
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.print("\nEnter amount to add (or 0 to cancel): ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("\nInvalid input. Please enter a numeric value.");
                            scanner.next();
                            continue;
                        }

                        int amount = scanner.nextInt();

                        if (amount == 0) {
                            System.out.println("Deposit cancelled.");
                            break;
                        }

                        try {
                            vendingMachine.addCurrency(amount);
                            break;

                        } catch (IllegalArgumentException e) {
                            System.out.println("\nInvalid amount. Please enter a valid denomination:");

                            StringJoiner smallDenomination = new StringJoiner(", ");
                            StringJoiner mediumDenomination = new StringJoiner(", ");
                            StringJoiner largeDenomination = new StringJoiner(", ");

                            for (ValidAmount denomination : ValidAmount.values()) {
                                int value = denomination.getValue();
                                if (value <= 5) {
                                    smallDenomination.add(String.valueOf(value));
                                } else if (value <= 50) {
                                    mediumDenomination.add(String.valueOf(value));
                                } else {
                                    largeDenomination.add(String.valueOf(value));
                                }
                            }

                            System.out.println("\n• Small Denomination: " + smallDenomination);
                            System.out.println("• Medium Denomination: " + mediumDenomination);
                            System.out.println("• Large Denomination: " + largeDenomination);
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nEnter Product ID to buy: ");
                    int productId = scanner.nextInt();
                    Product product = vendingMachine.request(productId);
                    if (product != null) {
                        System.out.println("\nDescription: " + vendingMachine.getDescription(productId));
                        System.out.println(product.use());
                    }
                    break;

                case 4:
                    System.out.println("\nCurrent Balance: " + vendingMachine.getBalance() + " kr.");
                    break;

                case 5:
                    int change = vendingMachine.endSession();
                    System.out.println("\nSession ended. Returned change: " + change + " kr.");
                    break;

                case 0:
                    running = false;
                    System.out.println("\nThank you for using the Vending Machine!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}