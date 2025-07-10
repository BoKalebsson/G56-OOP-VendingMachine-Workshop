package se.lexicon.model;

public abstract class Product {

    // Attributes:
    private int id;
    private double price;
    private String productName;

    // Constructor:
    public Product(int id, double price, String productName) {
        this.id = id;
        this.price = price;
        this.productName = productName;
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
    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductName(String productName) {
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


}
