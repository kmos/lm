package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;

import java.math.BigDecimal;

public class BasicTaxedProduct implements TaxedProduct {

    public static final BigDecimal BASIC_TAX = BigDecimal.valueOf(0.1);
    private final TaxFreeProduct taxFreeProduct;

    public BasicTaxedProduct(TaxFreeProduct taxFreeProduct) {

        this.taxFreeProduct = taxFreeProduct;
    }

    @Override
    public Money getCost() {
        return taxFreeProduct.getCost().add(taxFreeProduct.getCost().multiply(BASIC_TAX));
    }

    @Override
    public Money getTaxes() {
        return taxFreeProduct.getCost().multiply(BasicTaxedProduct.BASIC_TAX);
    }
}
