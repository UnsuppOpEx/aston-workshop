package aston.task3.proxy;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Payment {
    private UUID paymentId;
    private BigDecimal amount;
    private String currency;
}
