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
        Product product = new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("box of chocolates", Dollar.valueOf(10.00))));

        Money actualCost = product.getCost();

        assertEquals(Dollar.valueOf(10.50), actualCost);
    }
}