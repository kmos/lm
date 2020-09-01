package io.mosfet.lm.exercise;

public class SimpleCheckout implements Checkout {

    @Override
    public String getSummary() {
        return "your bag is empty! Please fill it before checkout";
    }
}
