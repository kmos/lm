package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;

public class BasicTaxedProduct implements TaxedProduct {

    private final TaxFreeProduct taxFreeProduct;

    public BasicTaxedProduct(TaxFreeProduct taxFreeProduct) {

        this.taxFreeProduct = taxFreeProduct;
    }

    @Override
    public Money getCost() {
        return Dollar.valueOf(16.49);
    }
}
