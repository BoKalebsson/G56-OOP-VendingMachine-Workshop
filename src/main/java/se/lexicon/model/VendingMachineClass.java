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
                    System.out.println("Purchase successful: " + product.getProductName());
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
        int change = depositPool;
        depositPool = 0;
        return change;
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
        String[] currentProducts = new String[products.length];
        System.out.println("-- Current Products in Vending Machine --");
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            currentProducts[i] = String.format(
                    "Id: %d, Name: %s, Price: %.2f kr",
                    product.getId(),
                    product.getProductName(),
                    product.getPrice()
            );
        }
        return currentProducts;
    }
}
