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

    @Test
    @DisplayName("given an Imported product like alcohol, when getting the description, then apply import label")
    void givenAnImportedProductAlcohol_whenGettingTheDescription_thenApplyTheImportLabel() {
        String actualDescription = ALCOHOL.getDescription();

        assertEquals("imported bottle of alcohol", actualDescription);
    }

    @Test
    @DisplayName("given an Imported product like chocolate, when getting the description, then apply import label")
    void givenAnImportedProduct_whenGettingTheDescription_thenApplyTheImportLabel() {
        String actualDescription = CHOCOLATE.getDescription();

        assertEquals("imported box of chocolates", actualDescription);
    }

    @Test
    @DisplayName("given an Imported product like chocolate, when getting the description, then apply import label")
    void givenAnImportedProductPerfume_whenGettingTheDescription_thenApplyTheImportLabel() {
        String actualDescription = PERFUME.getDescription();

        assertEquals("imported bottle of perfume", actualDescription);
    }

    @Test
    @DisplayName("given an Imported product like alcohol, when getting the taxes, then return it correctly")
    void givenAnImportedProductAlcohol_whenGettingTheTaxes_thenReturnItCorrectly() {
        Money actualTaxes = ALCOHOL.getTaxes();

        assertEquals(Dollar.valueOf(4.20), actualTaxes);
    }

    @Test
    @DisplayName("given an Imported product like chocolate, when getting the taxes, then return it correctly")
    void givenAnImportedProduct_whenGettingTheTaxes_thenReturnItCorrectly() {
        Money actualTaxes = CHOCOLATE.getTaxes();

        assertEquals(Dollar.valueOf(0.50), actualTaxes);
    }

    @Test
    @DisplayName("given an Imported product like chocolate, when getting the taxes, then return it correctly")
    void givenAnImportedProductPerfume_whenGettingTheTaxes_thenReturnItCorrectly() {
        Money actualTaxes = PERFUME.getTaxes();

        assertEquals(Dollar.valueOf(7.13), actualTaxes);
    }

}