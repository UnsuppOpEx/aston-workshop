package aston.task3.strategy;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return 0;
    }
}
