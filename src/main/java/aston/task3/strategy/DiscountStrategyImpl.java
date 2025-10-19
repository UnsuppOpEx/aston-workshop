package aston.task3.strategy;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyImpl {
    private final Map<String, DiscountStrategy> discountStrategyMap = new HashMap();

    public void registerDiscountStrategy(String name, DiscountStrategy discountStrategy) {
        discountStrategyMap.put(name, discountStrategy);
    }

    public double execute(String name, double amount) {
        DiscountStrategy strategy = discountStrategyMap.getOrDefault(name, new NoDiscountStrategy());
        return strategy.applyDiscount(amount);
    }
}
