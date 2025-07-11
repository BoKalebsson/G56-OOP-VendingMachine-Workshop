package se.lexicon;

import se.lexicon.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Setting up the Products[]:
        Product[] products = {
            new Candy(29, "Snickers Chocolate Bar", false),
            new Candy(19, "Werther's Original", true),
            new Beverage(24.99, "Monster Energy Drink", true),
            new Beverage(39, "Staropramen", false),
            new Tobacco(79, "Marlboro Red", TobaccoType.Cigarettes),
            new Tobacco(65, "General Portion", TobaccoType.Snuff)
        };

        // Setting up the Vending Machine:
        VendingMachineClass vendingMachine = new VendingMachineClass(0, products);

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

                case 0:
                    running = false;
                    System.out.println("Thank you for using the Vending Machine!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }


    }
}

}