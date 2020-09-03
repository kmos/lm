package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import io.mosfet.lm.exercise.products.Product;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingBag implements Bag {
    private final List<Item> products;

    private ShoppingBag(List<Item> products) {
        this.products = products;
    }

    @Override
    public String getProductDescriptions() {
        return products.stream()
                .map(Item::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public Item getItem(int index) {
        return products.get(index);
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public Money getTotal() {
        return products.stream()
                .map(Item::getTotal)
                .reduce(new Dollar(BigDecimal.ZERO), Money::add);
    }

    @Override
    public Money getTotalTaxes() {
        return products.stream()
                .map(Item::getTaxes)
                .reduce(new Dollar(BigDecimal.ZERO), Money::add).getRoundingTo5Cents();
    }

    public static final class Builder {
        private final Map<Product, Integer> products;

        public Builder() {
            this.products = new LinkedHashMap<>();
        }

        public Builder add(Product product) {
            this.products.put(product, products.getOrDefault(product, 0)+ 1);
            return this;
        }

        public ShoppingBag build() {
            return new ShoppingBag(products.entrySet()
                    .stream()
                    .filter(productEntry -> productEntry.getKey() != null)
                    .map(productEntry -> new Item(productEntry.getKey(), productEntry.getValue()))
                    .collect(Collectors.toList()));
        }
    }
}
