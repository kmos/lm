package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DutyTaxedProductTest {

    @Test
    @DisplayName("given an Imported prodcut, when getting the cost, then apply taxes for duty product")
    void givenAnImportedProduct_whenGettingTheCost_thenApplyTaxesForDutyProduct() {
        Product product = new DutyTaxedProduct(new TaxFreeProduct("box of chocolates", Dollar.valueOf(10.00)));

        Money actualCost = product.getCost();

        assertEquals(Dollar.valueOf(10.50), actualCost);
    }

    @Test
    @DisplayName("given an Imported prodcut, when getting the cost, then apply taxes for duty product")
    void givenAnImportedProductPerfum_whenGettingTheCost_thenApplyTaxesForDutyProduct() {
        Product product = new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of perfume", Dollar.valueOf(47.50))));

        Money actualCost = product.getCost();

        assertEquals(Dollar.valueOf(54.65), actualCost);
    }

    @Test
    @DisplayName("given an Imported prodcut, when getting the cost, then apply taxes for duty product")
    void givenAnImportedProductPerfm_whenGettingTheCost_thenApplyTaxesForDutyProduct() {
        Product product = new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of perfume", Dollar.valueOf(27.99))));

        Money actualCost = product.getCost();

        assertEquals(Dollar.valueOf(32.19), actualCost);
    }
}