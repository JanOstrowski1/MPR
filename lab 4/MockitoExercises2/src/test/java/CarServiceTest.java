import car.Car;
import car.CarCreator;
import car.CarService;
import client.Client;
import client.ClientRepository;
import exception.PaymentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import payment.Payment;
import payment.PaymentRepository;

import static enums.PaymentType.CAR_PAYMENT;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    CarCreator carCreator;

    @Mock
    ClientRepository clientRepository;

    @Mock
    PaymentRepository paymentRepository;

    @Test
    public void registerClientCarShouldReturnClient(){
        CarService carService=new CarService(carCreator,clientRepository,paymentRepository);

        Car car = new Car();
        car.setColor("red");
        car.setMake("bmw");
        car.setPlate("GD123");

        Client client=new Client("1",true,null);
        Mockito.when(carCreator.createCar("bmw","red","GD123")).thenReturn(car);
        Mockito.when(clientRepository.findClient("1")).thenReturn(client);
        Client testClient= carService.registerClientCar("1","bmw","red","GD123");

        Mockito.verify(clientRepository).saveClient(testClient);

        Assert.assertEquals("1",testClient.getId());
        Assert.assertEquals("bmw",testClient.getCar().getMake());
        Assert.assertEquals("GD123",testClient.getCar().getPlate());
        Assert.assertEquals("red",testClient.getCar().getColor());

    }
    @Test(expected = PaymentException.class)
    public void savePaymentShouldThrowExceptionWhenAmountEquals0(){
        CarService carService=new CarService(carCreator,clientRepository,paymentRepository);
        Payment payment=new Payment();
        payment.setAmount(0);
        payment.setType(CAR_PAYMENT);
        carService.savePayment(payment);
    }
    @Test
    public void savePaymentShouldSavePaymentToRepository(){
        CarService carService=new CarService(carCreator,clientRepository,paymentRepository);
        Payment payment=new Payment();
        payment.setAmount(120);
        payment.setType(CAR_PAYMENT);

        carService.savePayment(payment);

        Mockito.verify(paymentRepository).savePayment(payment);
    }

}
