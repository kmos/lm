package io.mosfet.lm.exercise;

public class TaxFreeProduct implements Product {
    private final String description;
    private final double price;

    public TaxFreeProduct(String description, double price) {
        this.description = description;
        this.price = price;
    }
}
