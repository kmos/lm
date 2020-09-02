package io.mosfet.lm.exercise;

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
