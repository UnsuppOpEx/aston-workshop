package aston.task3.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountStrategyImplTest {
    private final DiscountStrategyImpl strategy = new DiscountStrategyImpl();

    @Test
    void registerDiscountStrategy() {
        strategy.registerDiscountStrategy("percentage20%", new PercentageDiscountStrategy(20));
        strategy.registerDiscountStrategy("fix40%", new FixedDiscountStrategy(40));
        strategy.registerDiscountStrategy("noDiscount", new NoDiscountStrategy());

        Assertions.assertEquals(320, strategy.execute("percentage20%", 400));
        Assertions.assertEquals(360, strategy.execute("fix40%", 400));
        Assertions.assertEquals(0.0, strategy.execute("noDiscount", 400));
    }

    @Test
    void execute() {
        strategy.registerDiscountStrategy("percentage30%", new PercentageDiscountStrategy(30));
        strategy.registerDiscountStrategy("fix80%", new FixedDiscountStrategy(80));
        strategy.registerDiscountStrategy("noDiscount", new NoDiscountStrategy());

        Assertions.assertEquals(420, strategy.execute("percentage30%", 600));
        Assertions.assertEquals(520, strategy.execute("fix80%", 600));
        Assertions.assertEquals(0.0, strategy.execute("noDiscount", 600));
    }
}
