package aston.task3.strategy;

public class FixedDiscountStrategy implements DiscountStrategy {
    private final double discount;

    public FixedDiscountStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        return Math.max(0, price - discount);
    }
}
