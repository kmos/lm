package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;

import java.util.Objects;

public class TaxFreeProduct implements Product {
    private final String description;
    private final double cost;

    public TaxFreeProduct(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public Money getCost() {
        return Dollar.from(1.01);
    }

    @Override
    public String toString() {
        return description + ": " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxFreeProduct that = (TaxFreeProduct) o;
        return Double.compare(that.cost, cost) == 0 &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, cost);
    }
}
