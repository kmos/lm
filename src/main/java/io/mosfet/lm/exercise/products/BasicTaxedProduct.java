package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Money;

import java.math.BigDecimal;

public class BasicTaxedProduct implements TaxedProduct {

    public static final BigDecimal BASIC_TAX = BigDecimal.valueOf(0.1);
    private final TaxFreeProduct product;

    public BasicTaxedProduct(TaxFreeProduct taxFreeProduct) {
        this.product = taxFreeProduct;
    }

    @Override
    public Money getCost() {
        return product.getCost().add(product.getCost().multiply(BASIC_TAX));
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }

    @Override
    public Money getTaxes() {
        return product.getCost().multiply(BasicTaxedProduct.BASIC_TAX);
    }

    @Override
    public String toString() {
        return product.getDescription() + ": " + getCost().toString();
    }
}
