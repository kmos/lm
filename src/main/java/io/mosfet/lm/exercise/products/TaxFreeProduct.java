package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;

import java.util.Objects;

public class TaxFreeProduct implements Product {
    private final String description;
    private final Money cost;

    public TaxFreeProduct(String description, Money cost) {

        Objects.requireNonNull(description);
        Objects.requireNonNull(cost);

        this.description = description;
        this.cost = cost;
    }

    @Override
    public Money getCost() {
        return this.cost;
    }

    @Override
    public Money getFreeTaxCost() {
        return cost;
    }

    @Override
    public Money getTaxes() {
        return Dollar.valueOf(0);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description + ": " + cost.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxFreeProduct that = (TaxFreeProduct) o;
        return Objects.equals(description, that.description) &&
                Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, cost);
    }
}
