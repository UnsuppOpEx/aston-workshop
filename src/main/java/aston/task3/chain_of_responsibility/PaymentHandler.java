package aston.task3.chain_of_responsibility;

public class PaymentHandler extends OrderHandler {
    public void handle(Order order) {
        if (order.getAmount() > 0)
            System.out.println("Проверка оплаты прошла успешно");
        super.handle(order);
    }
}
