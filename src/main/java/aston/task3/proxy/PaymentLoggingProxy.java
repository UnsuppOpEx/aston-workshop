package aston.task3.proxy;

import java.util.logging.Logger;

public class PaymentLoggingProxy implements PaymentService {
    private static final Logger logger = Logger.getLogger(PaymentLoggingProxy.class.getName());
    private final PaymentService paymentService;

    public PaymentLoggingProxy(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void process(Payment payment) {
        logger.info("Log: payment processing has started");
        paymentService.process(payment);
        logger.info("Log: processing completed");
    }
}
