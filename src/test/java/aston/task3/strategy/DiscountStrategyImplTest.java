package aston.task3.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountStrategyImplTest {
    private final DiscountStrategyImpl strategy = new DiscountStrategyImpl();

    @Test
    void whenExecuteDiscountStrategy_thenResultContainsAmountWithDiscount() {
        strategy.registerDiscountStrategy("percentage20%", new PercentageDiscountStrategy(20));
        strategy.registerDiscountStrategy("fix40%", new FixedDiscountStrategy(40));
        strategy.registerDiscountStrategy("noDiscount", new NoDiscountStrategy());

        Assertions.assertEquals(320, strategy.execute("percentage20%", 400));
        Assertions.assertEquals(360, strategy.execute("fix40%", 400));
        Assertions.assertEquals(0.0, strategy.execute("noDiscount", 400));
    }
}
