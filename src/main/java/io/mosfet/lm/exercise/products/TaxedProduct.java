package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Money;

public interface TaxedProduct extends Product {
    Money getTaxes();
}
