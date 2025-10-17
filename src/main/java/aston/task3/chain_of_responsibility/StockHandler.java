package aston.task3.chain_of_responsibility;

public class StockHandler extends OrderHandler {
    public void handle(Order order) {
        if (order.getQuantity() > 0)
            System.out.println("Проверка наличия на складе прошла успешно");
        super.handle(order);
    }
}
