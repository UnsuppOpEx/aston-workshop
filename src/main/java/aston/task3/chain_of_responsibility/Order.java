package aston.task3.chain_of_responsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private String productName;
    private int amount;
    private int quantity;
}
