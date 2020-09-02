package io.mosfet.lm.exercise.shop;

import java.util.Objects;

public class SimpleCheckout implements Checkout {

    private final Bag bag;

    public SimpleCheckout(Bag bag) {
        Objects.requireNonNull(bag);

        this.bag = bag;
    }

    @Override
    public String getSummary() {

        if (!bag.isEmpty()) {
            return  bag.getProductDescriptions() + "\n" +
                    "Sales Taxes: 0\n" +
                    "Total: " + bag.getTotal().toString();
        }

        return "your bag is empty! Please fill it before checkout";
    }
}
