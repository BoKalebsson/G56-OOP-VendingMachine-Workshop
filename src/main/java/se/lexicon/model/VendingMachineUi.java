package se.lexicon.model;

import se.lexicon.model.VendingMachineClass;
import se.lexicon.model.Product;
import se.lexicon.model.ValidAmount;

import java.util.Scanner;
import java.util.StringJoiner;

public class VendingMachineUi {
    private final Scanner scanner;
    private final VendingMachineClass vendingMachine;
    private boolean running = true;

    public VendingMachineUi(VendingMachineClass vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Vending Machine!");

        while (running) {
            showMenu();
            int option = getUserInput();

            switch (option) {
                case 1 -> showProducts();
                case 2 -> handleAddCurrency();
                case 3 -> handleBuyProduct();
                case 4 -> showBalance();
                case 5 -> handleEndSession();
                case 0 -> exit();
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. View Products");
        System.out.println("2. Add Currency");
        System.out.println("3. Buy Product");
        System.out.println("4. Check Balance");
        System.out.println("5. End Session");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void showProducts() {
        System.out.println("\nAvailable Products:");
        for (String productInfo : vendingMachine.getProducts()) {
            System.out.println(productInfo);
        }
    }

    private void handleAddCurrency() {
        while (true) {
            System.out.print("\nEnter amount to add (or 0 to cancel): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a numeric value.");
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

                StringJoiner small = new StringJoiner(", ");
                StringJoiner medium = new StringJoiner(", ");
                StringJoiner large = new StringJoiner(", ");

                for (ValidAmount denomination : ValidAmount.values()) {
                    int value = denomination.getValue();
                    if (value <= 5) small.add(String.valueOf(value));
                    else if (value <= 50) medium.add(String.valueOf(value));
                    else large.add(String.valueOf(value));
                }

                System.out.println("• Small Denomination: " + small);
                System.out.println("• Medium Denomination: " + medium);
                System.out.println("• Large Denomination: " + large);
            }
        }
    }

    private void handleBuyProduct() {
        System.out.print("\nEnter Product ID to buy: ");
        int productId = getUserInput();
        Product product = vendingMachine.request(productId);

        if (product != null) {
            System.out.println("\nDescription: " + vendingMachine.getDescription(productId));
            System.out.println(product.use());
        }
    }

    private void showBalance() {
        System.out.println("\nCurrent Balance: " + vendingMachine.getBalance() + " kr.");
    }

    private void handleEndSession() {
        int change = vendingMachine.endSession();
        System.out.println("\nSession ended. Returned change: " + change + " kr.");
    }

    private void exit() {
        running = false;
        System.out.println("\nThank you for using the Vending Machine!");
    }
}