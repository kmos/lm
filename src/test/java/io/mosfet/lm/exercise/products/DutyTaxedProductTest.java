package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("given an imported product")
class DutyTaxedProductTest {

    private DutyTaxedProduct CHOCOLATE = new DutyTaxedProduct(new TaxFreeProduct("box of chocolates", Dollar.valueOf(10.00)));
    private DutyTaxedProduct PERFUME = new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of perfume", Dollar.valueOf(47.50))));
    private DutyTaxedProduct ALCOHOL = new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of alcohol", Dollar.valueOf(27.99))));

    @Nested
    @DisplayName("when getting the cost")
    class WhenGettingTheCost {

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

    @Nested
    @DisplayName("when getting the description")
    class WhenGettingTheDescription {

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

    }

    @Nested
    @DisplayName("when getting the taxes")
    class WhenGettingTheTaxes {

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

    @Nested
    @DisplayName("when getting the tax free of cost")
    class WhenGettingTheTaxFreeCost {

        @Test
        @DisplayName("given an Imported product, when getting the tax free of cost, then return it without taxes")
        void givenAnImportedProduct_whenGettingTheTaxFreeCost_thenReturnItWithoutTaxes() {
            Money actualCost = CHOCOLATE.getFreeTaxCost();

            assertEquals(Dollar.valueOf(10.00), actualCost);
        }

        @Test
        @DisplayName("given an Imported product like perfume, when getting the tax free of cost, then return it without taxes")
        void givenAnImportedProductLikePerfume_whenGettingTheTaxFreeCost_thenReturnItWithoutTaxes() {
            Money actualCost = PERFUME.getFreeTaxCost();

            assertEquals(Dollar.valueOf(47.50), actualCost);
        }

        @Test
        @DisplayName("given an Imported product like alcohol, when getting the tax free of cost, then return it without taxes")
        void givenAnImportedProductAlcohol_whenGettingTheTaxFreeCost_thenReturnItWithoutTaxes() {
            Money actualCost = ALCOHOL.getFreeTaxCost();

            assertEquals(Dollar.valueOf(27.99), actualCost);
        }

    }

}