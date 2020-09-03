package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Money;
import io.mosfet.lm.exercise.products.Product;

import java.math.BigDecimal;

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

    public Money getTaxes() {
        return product.getTaxes().multiply(BigDecimal.valueOf(quantity));
    }

    public Money getTotal() {
        return product.getCost().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return quantity + " " + product.getDescription() + ": " + getTotal();
    }
}
