package aston.task3.chain_of_responsibility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Order {
    private String productName;
    private int amount;
    private int quantity;
}
