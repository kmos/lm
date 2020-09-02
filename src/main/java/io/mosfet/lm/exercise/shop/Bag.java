package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Money;

public interface Bag {
    String getProductDescriptions();

    Item getItem(int index);

    boolean isEmpty();

    Money getTotal();

    Money getTotalTaxes();
}
