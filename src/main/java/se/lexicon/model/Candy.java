package se.lexicon.model;

public class Candy extends Product {

    // Attributes:
    private boolean isSugarFree;

    // Getter:
    public boolean isSugarFree() {
        return isSugarFree;
    }

    // Setter:
    public void setSugarFree(boolean sugarFree) {
        isSugarFree = sugarFree;
    }

    // Constructor:
    public Candy(double price, String productName, boolean isSugarFree) {
        super(price, productName);
        this.isSugarFree = isSugarFree;
    }

    // Operations:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Product Information --").append("\n");
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Price: ").append(getPrice()).append("\n");
        sb.append("Product Name: ").append(getProductName()).append("\n");
        sb.append("Sugarfree: ").append(isSugarFree()).append("\n");
        sb.append("---------------------------").append("\n");
        return sb.toString();
    }

    @Override
    public String examine() {
        return String.format("%s - %.2f kr (%s)%n",
                getProductName(),
                getPrice(),
                isSugarFree ? "Sugar-free" : "Contains sugar");
    }

    public String use(){

        return "";
    }
}
