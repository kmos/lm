package io.mosfet.lm.exercise.cash;

import java.math.BigDecimal;
import java.util.Objects;

public class Dollar implements Money {
    private final BigDecimal value;

    public Dollar(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("negative values are not allowed: " + value);
        }
        this.value = BigDecimal.valueOf(value);
    }

    @Override
    public double asDouble() {
        return value.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollar dollar = (Dollar) o;
        return Objects.equals(value, dollar.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
