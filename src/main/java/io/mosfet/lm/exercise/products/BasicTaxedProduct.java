package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;

import java.math.BigDecimal;

public class BasicTaxedProduct implements TaxedProduct {

    public static final double BASIC_TAX = 0.1;
    private final TaxFreeProduct taxFreeProduct;

    public BasicTaxedProduct(TaxFreeProduct taxFreeProduct) {

        this.taxFreeProduct = taxFreeProduct;
    }

    @Override
    public Money getCost() {
        return taxFreeProduct.getCost().add(taxFreeProduct.getCost().multiply(BigDecimal.valueOf(BASIC_TAX)));
    }

    @Override
    public Money getTaxes() {
        return Dollar.valueOf(1.59);
    }
}
