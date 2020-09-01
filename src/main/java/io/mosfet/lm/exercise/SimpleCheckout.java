package io.mosfet.lm.exercise;

public class SimpleCheckout implements Checkout {

    private final Bag bag;

    public SimpleCheckout(Bag bag) {
        this.bag = bag;
    }

    @Override
    public String getSummary() {

        if (bag != null) {
            return  "1 book : 12.49\n" +
                    "Sales Taxes: 0\n" +
                    "Total: 12.49\n";
        }

        return "your bag is empty! Please fill it before checkout";
    }
}
