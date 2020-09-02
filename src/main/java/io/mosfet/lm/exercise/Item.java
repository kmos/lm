package io.mosfet.lm.exercise;

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
}
