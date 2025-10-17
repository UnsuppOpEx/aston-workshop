package aston.task3.chain_of_responsibility;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Order {
    private String productName;
    private int amount;
    private int quantity;
}
