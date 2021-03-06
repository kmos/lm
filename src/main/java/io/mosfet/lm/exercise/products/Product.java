package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Money;

public interface Product {
    Money getCost();

    Money getFreeTaxCost();

    Money getTaxes();

    String getDescription();
}
