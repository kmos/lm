package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Money;
import io.mosfet.lm.exercise.products.Product;
import io.mosfet.lm.exercise.products.TaxedProduct;

import java.util.Optional;

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

    public Optional<Money> getTaxes() {
        return Optional.of(product)
                .filter(TaxedProduct.class::isInstance)
                .map(TaxedProduct.class::cast)
                .map(TaxedProduct::getTaxes);
    }
}
