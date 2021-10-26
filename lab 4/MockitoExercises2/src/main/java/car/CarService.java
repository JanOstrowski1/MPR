package car;

import client.Client;
import client.ClientRepository;
import exception.PaymentException;
import payment.Payment;
import payment.PaymentRepository;

public class CarService {
    private CarCreator carCreator;
    private ClientRepository clientRepository;
    private PaymentRepository paymentRepository;

    public CarService(CarCreator carCreator, ClientRepository clientRepository, PaymentRepository paymentRepository) {
        this.carCreator = carCreator;
        this.clientRepository = clientRepository;
        this.paymentRepository = paymentRepository;
    }

    public Client registerClientCar(String clientId, String carMake, String carColor, String carPlate) {
        Car car = carCreator.createCar(carMake, carColor, carPlate);

        Client client = clientRepository.findClient(clientId);

        client.setCar(car);

        clientRepository.saveClient(client);

        return client;
    }

    public void savePayment(Payment payment) {
        if (payment.getAmount() == 0) {
            throw new PaymentException();
        }

        paymentRepository.savePayment(payment);

    }
}
