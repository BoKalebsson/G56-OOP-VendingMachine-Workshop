package se.lexicon.model;

public class Tobacco extends Product {

    // Attributes:
    private TobaccoType tobaccoType;

    // Getter:
    public TobaccoType getTobaccoType() {
        return tobaccoType;
    }

    // Setter:
    public void setTobaccoType(TobaccoType tobaccoType) {
        if (tobaccoType == null) {
            throw new IllegalArgumentException("Tobacco type cannot be null.");
        }
        this.tobaccoType = tobaccoType;
    }

    // Constructor:
    public Tobacco(double price, String productName, TobaccoType tobaccoType) {
        super(price, productName);
        setTobaccoType(tobaccoType);
    }

    // Operations:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Product Information --").append("\n");
        sb.append("Id: ").append(getId()).append("\n");
        sb.append("Price: ").append(getPrice()).append("\n");
        sb.append("Product Name: ").append(getProductName()).append("\n");
        sb.append("Tobacco Type: ").append(getTobaccoType()).append("\n");
        sb.append("---------------------------").append("\n");
        return sb.toString();
    }

    @Override
    public String examine() {
        return String.format("%s (%s) - %.2f kr%n", getProductName(), tobaccoType, getPrice());
    }

    public String use(){

        return "";
    }
}
