package se.lexicon.model;

public abstract class Product {

    private static int idCounter = 0;

    // Attributes:
    private final int id;
    private double price;
    private String productName;

    // Constructor:
    public Product(double price, String productName) {
        this.id = ++idCounter;
        setPrice(price);
        setProductName(productName);
    }

    // Getters:
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    // Setters:
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty()){
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        this.productName = productName;
    }

    // Operations:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Product Information --").append("\n");
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Price: ").append(getPrice()).append("\n");
        sb.append("Product Name: ").append(getProductName()).append("\n");
        sb.append("---------------------------").append("\n");
        return sb.toString();
    }

    public abstract String examine();

    public abstract String use();

}
