package se.lexicon;

import se.lexicon.model.*;

public class Main {
    public static void main(String[] args) {
        VendingMachineClass vendingMachine = Setup.createVendingMachine();
        VendingMachineUi ui = new VendingMachineUi(vendingMachine);
        ui.start();
    }
}