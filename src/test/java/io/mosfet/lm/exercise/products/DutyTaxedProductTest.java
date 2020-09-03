package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DutyTaxedProductTest {

    private DutyTaxedProduct CHOCOLATE = new DutyTaxedProduct(new TaxFreeProduct("box of chocolates", Dollar.valueOf(10.00)));
    private DutyTaxedProduct PERFUME = new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of perfume", Dollar.valueOf(47.50))));
    private DutyTaxedProduct ALCOHOL = new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of alcohol", Dollar.valueOf(27.99))));

    @Test
    @DisplayName("given an Imported product, when getting the cost, then apply taxes for duty product")
    void givenAnImportedProduct_whenGettingTheCost_thenApplyTaxesForDutyProduct() {
        Money actualCost = CHOCOLATE.getCost();

        assertEquals(Dollar.valueOf(10.50), actualCost);
    }

    @Test
    @DisplayName("given an Imported product like perfume, when getting the cost, then apply taxes for duty product")
    void givenAnImportedProductLikePerfume_whenGettingTheCost_thenApplyTaxesForDutyProduct() {
        Money actualCost = PERFUME.getCost();

        assertEquals(Dollar.valueOf(54.65), actualCost);
    }

    @Test
    @DisplayName("given an Imported product like alcohol, when getting the cost, then apply taxes for duty product")
    void givenAnImportedProductAlcohol_whenGettingTheCost_thenApplyTaxesForDutyProduct() {
        Money actualCost = ALCOHOL.getCost();

        assertEquals(Dollar.valueOf(32.19), actualCost);
    }

}