package aston.task3.chain_of_responsibility;


import lombok.Setter;

abstract class OrderHandler {
    @Setter
    protected OrderHandler next;

    public void handle(Order order) {
        if (next != null) next.handle(order);
    }
}
