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


    }
}