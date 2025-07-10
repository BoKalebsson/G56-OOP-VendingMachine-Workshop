package se.lexicon.model;

public enum ValidAmount {

    // Enums:
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    // Attributes:
    private final int value;

    // Constructor:
    ValidAmount(int value) {
        this.value = value;
    }

    // Getters:
    public int getValue() {
        return value;
    }

    // Operations:
    public static boolean isValid(int amount) {
        for (ValidAmount valid : ValidAmount.values()) {
            if (valid.getValue() == amount) {
                return true;
            }
        }
        return false;
    }


}
