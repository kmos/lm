package io.mosfet.lm.exercise.cash;

import java.math.BigDecimal;

public interface Money {

    Money add(Money money);

    Money multiply(BigDecimal value);

    Money getRoundingTo5Cents();

    BigDecimal asBigDecimal();

}
