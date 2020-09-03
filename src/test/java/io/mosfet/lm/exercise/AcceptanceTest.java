package io.mosfet.lm.exercise;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.products.BasicTaxedProduct;
import io.mosfet.lm.exercise.products.DutyTaxedProduct;
import io.mosfet.lm.exercise.products.TaxFreeProduct;
import io.mosfet.lm.exercise.shop.Checkout;
import io.mosfet.lm.exercise.shop.ShoppingBag;
import io.mosfet.lm.exercise.shop.SimpleCheckout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceTest {

    @Test
    @DisplayName("given a set of products with one taxed, when getting the summary during checkout process, then return descriptions taxes and total")
    void givenASetProductsWithOneTaxed_whenGettingTheSummaryCheckout_thenReturnDescriptionsTaxesAndTotal() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", Dollar.valueOf(12.49)))
                .add(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(14.99))))
                .add(new TaxFreeProduct("chocolate bar", Dollar.valueOf(0.85)))
                .build());

        String actualSummary = checkout.getSummary();

        String expectedSummary =
                "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";
        assertEquals(expectedSummary, actualSummary);
    }

    @Test
    @DisplayName("given a set of imported products, when getting the summary during checkout process, then return descriptions taxes and total")
    void givenASetOfImportedProducts_whenGettingTheSummaryCheckout_thenReturnDescriptionsTaxesAndTotal() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new DutyTaxedProduct(new TaxFreeProduct("box of chocolates", Dollar.valueOf(10.00))))
                .add(new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of perfume", Dollar.valueOf(47.50)))))
                .build());

        String actualSummary = checkout.getSummary();

        String expectedSummary =
                "1 imported box of chocolates: 10.50\n" +
                        "1 imported bottle of perfume: 54.65\n" +
                        "Sales Taxes: 7.65\n" +
                        "Total: 65.15";
        assertEquals(expectedSummary, actualSummary);
    }

    @Test
    @DisplayName("given a set of mixed products, when getting the summary during checkout process, then return descriptions taxes and total")
    void givenASetOfMixedProducts_whenGettingTheSummaryCheckout_thenReturnDescriptionsTaxesAndTotal() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new DutyTaxedProduct(new BasicTaxedProduct(new TaxFreeProduct("bottle of perfume", Dollar.valueOf(27.99)))))
                .add(new BasicTaxedProduct(new TaxFreeProduct("bottle of perfume", Dollar.valueOf(18.99))))
                .add(new TaxFreeProduct("packet of headache pills", Dollar.valueOf(9.75)))
                .add(new DutyTaxedProduct(new TaxFreeProduct("box of chocolates", Dollar.valueOf(11.25))))
                .build());

        String actualSummary = checkout.getSummary();

        String expectedSummary =
                "1 imported bottle of perfume: 32.19\n" +
                        "1 bottle of perfume: 20.89\n" +
                        "1 packet of headache pills: 9.75\n" +
                        "1 imported box of chocolates: 11.85\n" +
                        "Sales Taxes: 6.70\n" +
                        "Total: 74.68";
        assertEquals(expectedSummary, actualSummary);
    }

}