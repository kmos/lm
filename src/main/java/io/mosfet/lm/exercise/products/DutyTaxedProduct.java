package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DutyTaxedProduct implements Product {

    private final Product product;
    private final BigDecimal IMPORT_TAX = BigDecimal.valueOf(0.05).setScale(2, RoundingMode.UP);

    public DutyTaxedProduct(Product product) {
        this.product = product;
    }

    @Override
    public Money getCost() {
        Money multiply = product.getFreeTaxCost().multiply(IMPORT_TAX);
        return product.getFreeTaxCost().add(multiply.add(product.getTaxes()).getRoundingTo5Cents());
    }

    @Override
    public Money getFreeTaxCost() {
        return product.getCost();
    }

    @Override
    public Money getTaxes() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

}
