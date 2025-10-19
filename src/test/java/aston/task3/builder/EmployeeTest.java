package aston.task3.builder;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void whenBuilderWasBuildWithValues_theResultContainsTextAsObjectToString() {
        Employee employee = new Employee.EmployeeBuilder()
                .surname("Petrov")
                .gender(Gender.MALE)
                .salary(BigDecimal.valueOf(100000)).build();

        String employeeString = "Employee(surname=Petrov, gender=MALE, salary=100000)";
        assertEquals(employeeString, employee.toString());
    }
}
