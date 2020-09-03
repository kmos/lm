package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Money;
import io.mosfet.lm.exercise.products.Product;

public class Item {
    private final Product product;
    private final Integer quantity;

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + product.toString();
    }

    public Money getTotal() {
        return product.getCost().multiply(quantity);
    }

    public Money getTaxes() {
        return product.getTaxes().multiply(quantity);
    }
}
