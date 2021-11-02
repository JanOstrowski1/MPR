import exception.PaymentException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import payment.Payment;
import payment.PaymentRepository;
import payment.PaymentService;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    PaymentRepository paymentRepository;

    @Test
    public void savePaymentTestShouldSavePayment() {
        PaymentService paymentService = new PaymentService(paymentRepository);
        Payment payment = new Payment();
        payment.setAmount(1000);

        paymentService.savePayment(payment);
        verify(paymentRepository).savePayment(payment);
    }

    @Test(expected = PaymentException.class)
    public void savePaymentTestShouldThrowPaymentException() {
        PaymentService paymentService = new PaymentService(paymentRepository);
        Payment payment = new Payment();
        payment.setAmount(0);
        paymentService.savePayment(payment);

    }


}
