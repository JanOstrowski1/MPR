import car.Car;
import car.CarService;
import client.Client;
import client.ClientService;
import enums.PaymentType;
import exception.ClientAlreadyExistsException;
import exception.ClientAlreadyInactiveException;
import exception.ClientNotFoundException;
import payment.Payment;
import payment.PaymentService;

public class CarShopController {
    private ClientService clientService;
    private CarService carService;
    private PaymentService paymentService;

    public CarShopController(ClientService clientService, CarService carService, PaymentService paymentService) {
        this.clientService = clientService;
        this.carService = carService;
        this.paymentService = paymentService;
    }

    public Response createNewClient(String clientId, Car car) {
        Client client;

        try {
            client = clientService.createNewClient(clientId);

            if (car != null) {
                client.setCar(car);
            }

        } catch (ClientAlreadyExistsException e) {
            return new Response(400, null);
        }

        return new Response(200, client);
    }

    public Response disableClientAccount(String clientId) {
        Client client;
        try {
            client = clientService.disableClientAccount(clientId);
        } catch (ClientNotFoundException e) {
            return new Response(404, null);
        } catch (ClientAlreadyInactiveException e) {
            return new Response(400, null);
        }

        return new Response(200, client);
    }

    public Response updateClientAccountId(String clientId, String newId) {
        Client client;
        try {
            client = clientService.updateClientAccountId(clientId, newId);
        } catch (ClientNotFoundException e) {
            return new Response(404, null);
        }

        return new Response(200, client);
    }

    public Response registerClientCar(String clientId, String carMake, String carColor, String carPlate) {
        Client client;

        try {
            client = carService.registerClientCar(clientId, carMake, carColor, carPlate);

        } catch (ClientNotFoundException e) {
            return new Response(404, null);
        }

        return new Response(200, client);
    }

    public Response processPayment(Payment payment) {
        if (payment.getType() == PaymentType.CAR_PAYMENT) {
            carService.savePayment(payment);
        } else {
            paymentService.savePayment(payment);
        }

        return new Response(201, null);
    }
}
