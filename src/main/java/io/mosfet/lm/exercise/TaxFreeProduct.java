package io.mosfet.lm.exercise;

import java.util.Objects;

public class TaxFreeProduct implements Product {
    private final String description;
    private final double price;

    public TaxFreeProduct(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return description + ": " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxFreeProduct that = (TaxFreeProduct) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
