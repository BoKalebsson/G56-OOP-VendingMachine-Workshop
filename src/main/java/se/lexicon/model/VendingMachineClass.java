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
        for(Product product : products) {
            if (product.getId() == id) {
                int roundedPrice = (int) Math.round(product.getPrice());

                if (depositPool >= roundedPrice) {
                    depositPool -= roundedPrice;
                    return product;
                } else {
                    System.out.println("Not enough balance to buy: " + product.getProductName());
                    return null;
                }
            }
        }
        System.out.println("Product with ID " + id + " not found.");
        return null;
    }

    @Override
    public int endSession() {
        return 0;
    }

    @Override
    public String getDescription(int id) {
        for (Product product : products){
            if (product.getId() == id) {
                return product.examine();
            }
        }
        return "Product with ID " + id + " not found.";
    }

    @Override
    public String[] getProducts() {
        return new String[0];
    }
}
