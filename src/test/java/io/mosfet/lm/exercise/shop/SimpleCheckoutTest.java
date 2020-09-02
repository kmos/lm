package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.products.BasicTaxedProduct;
import io.mosfet.lm.exercise.products.TaxFreeProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleCheckoutTest {

    @Test
    @DisplayName("given an empty bag, when getting the summary, then return a courtesy message")
    void givenAnEmptyBag_whenGettingTheSummary_thenReturnACourtesyMessage() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder().build());

        String actualSummary = checkout.getSummary();

        assertEquals("your bag is empty! Please fill it before checkout", actualSummary);
    }

    @Test
    @DisplayName("given a bag with a tax free product, when getting the summary, then return is description and Quantity")
    void givenABagWithATaxFreeProduct_whenGettingTheSummary_thenReturnIsDescriptionAndQuantity() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", Dollar.valueOf(12.49)))
                .build());

        String actualSummary = checkout.getSummary();

        String expectedProduct = "1 book: 12.49\n";
        assertTrue(actualSummary.contains(expectedProduct));
    }

    @Test
    @DisplayName("given a bag with two tax free product, when getting the summary, then return description and Quantity")
    void givenABagWithTwoTaxFreeProduct_whenGettingTheSummary_thenReturnDescriptionQuantity() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", Dollar.valueOf(12.49)))
                .add(new TaxFreeProduct("chocolate bar", Dollar.valueOf(0.85)))
                .build());

        String actualSummary = checkout.getSummary();

        String expectedProducts = "1 book: 12.49\n" +
                        "1 chocolate bar: 0.85\n";
        assertTrue(actualSummary.contains(expectedProducts));
    }

    @Test
    @DisplayName("given a bag with two tax free product, when getting the summary, then return description, Quantity and Total")
    void givenABagWithTwoTaxFreeProduct_whenGettingTheSummary_thenReturnDescriptionQuantityAndTotal() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", Dollar.valueOf(12.49)))
                .add(new TaxFreeProduct("chocolate bar", Dollar.valueOf(0.85)))
                .build());

        String actualSummary = checkout.getSummary();

        String expectedProducts =
                "1 book: 12.49\n" +
                "1 chocolate bar: 0.85\n";
        String expectedTotal = "Total: 13.34";
        assertTrue(actualSummary.contains(expectedProducts));
        assertTrue(actualSummary.contains(expectedTotal));
    }

    @Test
    @DisplayName("given a bag with two taxed product, when getting the summary, then return taxes in the summary")
    void givenABagWithTwoTaxedProduct_whenGettingTheSummary_thenReturnTaxes() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", Dollar.valueOf(12.49)))
                .add(new TaxFreeProduct("chocolate bar", Dollar.valueOf(0.85)))
                .add(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(20.85))))
                .add(new BasicTaxedProduct(new TaxFreeProduct("pills", Dollar.valueOf(10.45))))
                .build());

        String actualSummary = checkout.getSummary();

        String expectedTaxes = "Sales Taxes: 3.15";
        assertTrue(actualSummary.contains(expectedTaxes));
    }
}