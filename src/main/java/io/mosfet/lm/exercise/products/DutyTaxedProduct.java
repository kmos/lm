package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DutyTaxedProduct implements Product {

    private final Product product;
    private static final BigDecimal IMPORT_TAX = BigDecimal.valueOf(0.05).setScale(2, RoundingMode.UP);

    public DutyTaxedProduct(Product product) {
        this.product = product;
    }

    @Override
    public Money getCost() {
        return product.getFreeTaxCost()
                .add(product.getFreeTaxCost()
                        .multiply(IMPORT_TAX)
                        .add(product.getTaxes())
                        .getRoundingTo5Cents());
    }

    @Override
    public Money getFreeTaxCost() {
        return product.getFreeTaxCost();
    }

    @Override
    public Money getTaxes() {
        return product.getTaxes()
                .add(product.getFreeTaxCost()
                        .multiply(IMPORT_TAX));
    }

    @Override
    public String getDescription() {
        return "imported " + product.getDescription();
    }

    @Override
    public String toString() {
        return "imported " + product.getDescription() + ": " + getCost();
    }
}
