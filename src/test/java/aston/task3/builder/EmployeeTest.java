package aston.task3.builder;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void builder() {
        Employee employee = new Employee.EmployeeBuilder()
                .surname("Petrov")
                .gender(Gender.MALE)
                .salary(BigDecimal.valueOf(100000)).build();

        assertEquals("Employee(surname=Petrov, gender=MALE, salary=100000)", employee.toString());
    }
}
