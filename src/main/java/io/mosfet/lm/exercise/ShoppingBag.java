package io.mosfet.lm.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingBag implements Bag {
    private final Map<Product, Integer> products;

    public ShoppingBag(Map<Product, Integer> product) {
        this.products = product;
    }

    private ShoppingBag(Builder builder) {
        products = builder.products;
    }

    @Override
    public String getProductDescriptions() {
        return products.entrySet().stream()
                .map(productEntry -> productEntry.getValue() + " " + productEntry.getKey().toString())
                .collect(Collectors.joining("\n"));
    }

    public static final class Builder {
        private final Map<Product, Integer> products;

        public Builder() {
            this.products = new LinkedHashMap<>();
        }

        public Builder add(Product product) {
            this.products.put(product, 1);
            return this;
        }

        public ShoppingBag build() {
            return new ShoppingBag(this);
        }
    }
}
