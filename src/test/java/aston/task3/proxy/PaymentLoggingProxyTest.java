package aston.task3.proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.logging.Logger;

class PaymentLoggingProxyTest {
    private PaymentService service;
    private PaymentService proxy;
    private Logger logger;


    @BeforeEach
    void setUp() {
        logger = Logger.getLogger(PaymentLoggingProxy.class.getName());
        service = payment -> logger.info("Payment processed: " + payment);
        proxy = new PaymentLoggingProxy(service);
    }

    @Test
    void whenObjectWasCalledUsingProxy_ThenConsoleLogContainsLogOutputText() {
        Payment payment = Payment.builder()
                .paymentId(UUID.randomUUID())
                .amount(BigDecimal.valueOf(5000))
                .currency("RUB")
                .build();

        Assertions.assertDoesNotThrow(() -> proxy.process(payment));
    }
}

