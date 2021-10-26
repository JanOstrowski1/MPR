import client.Client;
import client.ClientRepository;
import client.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    ClientRepository clientRepository;

    @Mock
    ClientService clientService;

    @Test
    public void disableClientAccountShouldReturnClientWithDisabledAccount(){
        Client client=new Client("1",true,null);
        when(clientRepository.findClient("1")).thenReturn(client);


        clientService.disableClientAccount("1");
        verify(clientService).disableClientAccount("1");


        assertFalse(client.isActive());

    }
}
