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
        this.tobaccoType = tobaccoType;
    }

    // Constructor:
    public Tobacco(double price, String productName) {
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

    public String examine(){

        return "";
    }

    public String use(){

        return "";
    }
}
