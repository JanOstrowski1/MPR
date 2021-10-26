package payment;

import exception.PaymentException;

public class PaymentService {
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void savePayment(Payment payment) {
        if (payment.getAmount() == 0) {
            throw new PaymentException();
        }

        paymentRepository.savePayment(payment);

    }
}
