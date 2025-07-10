package se.lexicon;

import se.lexicon.model.*;

public class Main {
    public static void main(String[] args) {

        // Implementing and printing out a new Candy-item:
        Candy polkagris = new Candy(19.99, "Polkagris", false);
        System.out.println(polkagris);
        System.out.println(polkagris.examine());

        // Implementing and printing out a new Beverage-item:
        Beverage cocacolazero = new Beverage(29.00, "Coca Cola Zero", true);
        System.out.println(cocacolazero);
        System.out.println(cocacolazero.examine());

        // Implementing and printing out a new Tobacco-item:
        Tobacco ettanlös = new Tobacco(79.99, "Ettan Lös", TobaccoType.Snuff);
        System.out.println(ettanlös);
        System.out.println(ettanlös.examine());

        // Simulating different scenarios for testing enum isValid:
        System.out.println("Is 20 valid? " + ValidAmount.isValid(20));
        System.out.println("Is 7 valid? " + ValidAmount.isValid(7));

        // Setting up a new Product[]:
        Product[] products = {
                new Beverage(25, "Cola", true),
                new Tobacco(50, "Cigarettes", TobaccoType.Cigarettes),
                cocacolazero, ettanlös,polkagris
        };

        // Setting up a new VendingMachineClass:
        VendingMachineClass vendingMachine = new VendingMachineClass(0, products);

        // Simulating getBalance():
        System.out.println("Balance: " + vendingMachine.getBalance() + " kr.\n");

        // Simulating valid addCurrency():
        int differentAmount = 10;

        if (ValidAmount.isValid(differentAmount)) {
            vendingMachine.addCurrency(differentAmount);
            System.out.println("Deposit successful!\n");
        } else {
            System.out.println("The amount is invalid. Try with 10, 20 or 50.\n");
        }
        System.out.println("Balance: " + vendingMachine.getBalance() + " kr.\n");

        // Simulating invalid addCurrency():
        int amount = 3;

        if (ValidAmount.isValid(amount)) {
            vendingMachine.addCurrency(amount);
            System.out.println("Deposit successful!\n");
        } else {
            System.out.println("The amount is invalid. Try with 10, 20 or 50.\n");
        }
        System.out.println("Balance: " + vendingMachine.getBalance() + " kr.\n");

        // Simulating getProducts():
        for (String desc : vendingMachine.getProducts()) {
            System.out.println(desc);
        }



    }
}