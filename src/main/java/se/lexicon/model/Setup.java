package se.lexicon.model;

public class Setup {

    // Create the products:
    public static Product[] createProducts() {
        return new Product[] {
                new Candy(29, "Snickers Chocolate Bar", false),
                new Candy(19, "Werther's Original", true),
                new Beverage(24.99, "Monster Energy Drink", true),
                new Beverage(39, "Staropramen", false),
                new Tobacco(79, "Marlboro Red", TobaccoType.Cigarettes),
                new Tobacco(65, "General Portion", TobaccoType.Snuff)
        };
    }

    // Create a Vending Machine with the products:
    public static VendingMachineClass createVendingMachine() {
        return new VendingMachineClass(0, createProducts());
    }
}