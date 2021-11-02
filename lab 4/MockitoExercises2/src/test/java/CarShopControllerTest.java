import car.CarService;
import client.Client;
import client.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import payment.PaymentService;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarShopControllerTest {

    @Mock
    ClientService clientService;
    @Mock
    CarService carService;
    @Mock
    PaymentService paymentService;


    @Test
    public void createNewClientShouldCreateNewClient() {
        CarShopController carShopController =new CarShopController(clientService,carService,paymentService);
        Client client=new Client("1",true,null);
        when(clientService.createNewClient("1")).thenReturn(client);

    }
}
