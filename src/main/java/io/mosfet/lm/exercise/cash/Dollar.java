package io.mosfet.lm.exercise.cash;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Dollar implements Money {
    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private final BigDecimal value;

    public Dollar(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("negative values are not allowed: " + value);
        }
        this.value = BigDecimal.valueOf(value).setScale(SCALE, ROUNDING_MODE);
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
