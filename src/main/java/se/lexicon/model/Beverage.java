package se.lexicon.model;

public class Beverage extends Product {

    // Attributes:
    private boolean isAlcoholFree;

    // Getter:
    public boolean isAlcoholFree() {
        return isAlcoholFree;
    }

    // Setter:
    public void setAlcoholFree(boolean isAlcoholFree) {
        this.isAlcoholFree = isAlcoholFree;
    }

    // Constructor:
    public Beverage(double price, String productName, boolean isAlcoholFree) {
        super(price, productName);
        this.isAlcoholFree = isAlcoholFree;
    }

    // Operations:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Product Information --").append("\n");
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Price: ").append(getPrice()).append("\n");
        sb.append("Product Name: ").append(getProductName()).append("\n");
        sb.append("Alcohol free: ").append(isAlcoholFree()).append("\n");
        sb.append("---------------------------").append("\n");
        return sb.toString();
    }

    @Override
    public String examine() {
        return String.format("%s - %.2f kr (%s)%n",
                getProductName(),
                getPrice(),
                isAlcoholFree ? "Alcohol-free" : "Contains alcohol");
    }

    public String use(){

        return "";
    }
}
