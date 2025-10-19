package aston.task3.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@ToString
@Getter
public class Employee {
    private String surname;
    private Gender gender;
    private BigDecimal salary;
}
