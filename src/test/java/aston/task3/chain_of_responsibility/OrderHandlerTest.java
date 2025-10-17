package aston.task3.chain_of_responsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderHandlerTest {
    private OrderHandler stock;
    private OrderHandler payment;

    @BeforeEach
    void setUp() {
        stock = new StockHandler();
        payment = new PaymentHandler();
    }

    @Test
    void handle() {
        stock.setNext(payment);
        stock.handle(new Order("TV", 1, 500));
    }
}
