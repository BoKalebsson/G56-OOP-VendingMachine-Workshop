package se.lexicon.model;

public class PurchaseResult {

    // Attributes:
    private final Product product;
    private final String message;
    private final boolean success;

    // Constructor:
    public PurchaseResult(String message, Product product, boolean success) {
        this.message = message;
        this.product = product;
        this.success = success;
    }

    // Getters:
    public String getMessage() {
        return message;
    }

    public Product getProduct() {
            return product;
        }

    public boolean isSuccess() {
        return success;
    }
}
