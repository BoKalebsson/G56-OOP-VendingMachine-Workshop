package se.lexicon.model;

public class VendingMachineClass implements VendingMachine {

    // Attributes:
    Product[] products;
    int depositPool;

    // Constructor:
    public VendingMachineClass(int depositPool, Product[] products) {
        this.depositPool = depositPool;
        this.products = products;
    }

    // Getters:


    // Setters:


    // Operations:
    @Override
    public void addCurrency(int amount) {
        if (!ValidAmount.isValid(amount)) {
            throw new IllegalArgumentException("Invalid currency amount: " + amount);
        }
        depositPool += amount;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        return null;
    }

    @Override
    public int endSession() {
        return 0;
    }

    @Override
    public String getDescription(int id) {
        return "";
    }

    @Override
    public String[] getProducts() {
        return new String[0];
    }
}
