package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import io.mosfet.lm.exercise.products.BasicTaxedProduct;
import io.mosfet.lm.exercise.products.TaxFreeProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("given a bag with some products")
class ShoppingBagTest {

    @Nested
    @DisplayName("when getting an item")
    class WhenGettingAnItem {

        @Test
        @DisplayName("given a bag with two equal product, when getting an item, return the right quantity and product")
        void givenABagWithSameProduct_whenGettingAnItem_returnTheRightQuantity() {
            TaxFreeProduct book = new TaxFreeProduct("book", Dollar.valueOf(12.49));
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(book)
                    .add(book)
                    .build();

            Item actualItem = shoppingBag.getItem(0);

            assertEquals(book, actualItem.getProduct());
            assertEquals(2, actualItem.getQuantity().intValue());
        }

        @Test
        @DisplayName("given a bag with some products, when getting related items, return the right quantity and product")
        void givenABagWithSomeProduct_whenGettingThem_returnTheRightQuantity() {
            TaxFreeProduct book = new TaxFreeProduct("book", Dollar.valueOf(12.49));
            TaxFreeProduct chocolateBar = new TaxFreeProduct("chocolate bar", Dollar.valueOf(0.85));
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(book)
                    .add(book)
                    .add(chocolateBar)
                    .build();

            Item actualBookItem = shoppingBag.getItem(0);
            Item actualChocolateBarItem = shoppingBag.getItem(1);

            assertEquals(book, actualBookItem.getProduct());
            assertEquals(2, actualBookItem.getQuantity().intValue());
            assertEquals(chocolateBar, actualChocolateBarItem.getProduct());
            assertEquals(1, actualChocolateBarItem.getQuantity().intValue());
        }

    }

    @Nested
    @DisplayName("when checking if it's filled")
    class WhenCheckingIfFilled {

        @Test
        @DisplayName("given a bag without products, when checking if it's filled, return empty")
        void givenABagWithoutProduct_whenCheckingIfFilled_returnEmpty() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .build();

            assertTrue(shoppingBag.isEmpty());
        }

        @Test
        @DisplayName("given a bag with null values, when checking if it's filled, return empty")
        void givenABagWithNullValues_whenCheckingIfFilled_returnEmpty() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(null)
                    .add(null)
                    .build();

            assertTrue(shoppingBag.isEmpty());
        }

    }

    @Nested
    @DisplayName("when getting the total")
    class WhenGettingTheTotal {

        @Test
        @DisplayName("given a bag with two different products, when getting the total, return the right sum of them")
        void givenABagWithTwoProducts_whenGettingTheTotal_returnTheRightValue() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.1)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.3)))
                    .build();

            Money actualTotal = shoppingBag.getTotal();

            assertEquals(Dollar.valueOf(2.4), actualTotal);
        }

        @Test
        @DisplayName("given a bag with three different products, when getting the total, return the right sum of them")
        void givenABagWithThreeProducts_whenGettingTheTotal_returnTheRightValue() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.1)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("milk", Dollar.valueOf(1.5)))
                    .build();

            Money actualTotal = shoppingBag.getTotal();

            assertEquals(Dollar.valueOf(3.9), actualTotal);
        }

        @Test
        @DisplayName("given a bag with four different products, when getting the total, return the right sum of them")
        void givenABagWithFourProducts_whenGettingTheTotal_returnTheRightValue() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.1)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("milk", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .build();

            Money actualTotal = shoppingBag.getTotal();

            assertEquals(Dollar.valueOf(5.1), actualTotal);
        }

        @Test
        @DisplayName("given a bag with two equal products, when getting the total, return the right sum of them")
        void givenABagWithTwoEqualProducts_whenGettingTheTotal_returnTheRightValue() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.1)))
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.1)))
                    .build();

            Money actualTotal = shoppingBag.getTotal();

            assertEquals(Dollar.valueOf(2.2), actualTotal);
        }

        @Test
        @DisplayName("given a bag with some products, when getting the total, return the right sum of them")
        void givenABagWithSomeProducts_whenGettingTheTotal_returnTheRightValue() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .build();

            Money actualTotal = shoppingBag.getTotal();

            assertEquals(Dollar.valueOf(11.9), actualTotal);
        }

    }

    @Nested
    @DisplayName("when getting the taxes")
    class WhenGettingTheTaxes {

        @Test
        @DisplayName("given a bag with some products, when getting the taxes, then return the sum of all taxes")
        void givenABagWithSomeProducts_WhenGettingTheTaxes_returnTheSumOfAllTaxes() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new BasicTaxedProduct(new TaxFreeProduct("perfume", Dollar.valueOf(1.2))))
                    .add(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(2.2))))
                    .add(new BasicTaxedProduct(new TaxFreeProduct("pills", Dollar.valueOf(3.2))))
                    .build();

            Money actualTotalTaxes = shoppingBag.getTotalTaxes();

            assertEquals(Dollar.valueOf(0.66), actualTotalTaxes);
        }

        @Test
        @DisplayName("given a bag with some repeated taxed products, when getting the taxes, then return the sum of all taxes")
        void givenABagWithSomeRepeatedTaxedProducts_WhenGettingTheTaxes_returnTheRightValue() {
            Bag shoppingBag = new ShoppingBag.Builder()
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("book", Dollar.valueOf(1.3)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.5)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new TaxFreeProduct("potato", Dollar.valueOf(1.2)))
                    .add(new BasicTaxedProduct(new TaxFreeProduct("perfume", Dollar.valueOf(1.2))))
                    .add(new BasicTaxedProduct(new TaxFreeProduct("perfume", Dollar.valueOf(1.2))))
                    .add(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(2.2))))
                    .add(new BasicTaxedProduct(new TaxFreeProduct("pills", Dollar.valueOf(3.2))))
                    .build();

            Money actualTotalTaxes = shoppingBag.getTotalTaxes();

            assertEquals(Dollar.valueOf(0.78), actualTotalTaxes);
        }

    }
}