package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.exception.CheckoutException;

import java.util.Objects;

public class SimpleCheckout implements Checkout {

    private final Bag bag;

    public SimpleCheckout(Bag bag) {
        Objects.requireNonNull(bag);

        this.bag = bag;
    }

    @Override
    public String getSummary() {
        validate();

        return  bag.getProductDescriptions() + "\n" +
                "Sales Taxes: " + bag.getTotalTaxes().toString() + "\n" +
                "Total: " + bag.getTotal().toString();

    }

    private void validate() {
        if (bag.isEmpty()) {
            throw new CheckoutException("your bag is empty! Please fill it before checkout");
        }
    }
}
