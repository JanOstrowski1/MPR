import client.Client;
import client.ClientRepository;
import client.ClientService;
import exception.ClientAlreadyExistsException;
import exception.ClientAlreadyInactiveException;
import exception.ClientNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    ClientRepository clientRepository;


    @Test
    public void disableClientAccountShouldReturnClientWithDisabledAccount() {
        ClientService clientService = new ClientService(clientRepository);
        Client client = new Client("1", true, null);
        when(clientRepository.findClient("1")).thenReturn(client);

        clientService.disableClientAccount("1");

        verify(clientRepository).saveClient(client);

        assertFalse(client.isActive());
    }

    @Test(expected = ClientNotFoundException.class)
    public void disableClientAccountShouldThrowExceptionWhenClientNotFound() {
        ClientService clientService = new ClientService(clientRepository);
        when(clientRepository.findClient("999")).thenReturn(null);

        clientService.disableClientAccount("999");
    }

    @Test(expected = ClientAlreadyInactiveException.class)
    public void disableClientAccountShouldThrowExceptionClientAlreadyInactiveException() {
        ClientService clientService = new ClientService(clientRepository);
        Client client = new Client("007", false, null);
        when(clientRepository.findClient("007")).thenReturn(client);

        clientService.disableClientAccount("007");
    }

    @Test
    public void updateClientAccountIdShouldUpdateClientId(){
        ClientService clientService = new ClientService(clientRepository);
        Client client=new Client("4",true,null);
        when(clientRepository.findClient("4")).thenReturn(client);
        Client updatedClient = clientService.updateClientAccountId("4","56");
        verify(clientRepository).saveClient(client);
        verify(clientRepository).deleteClient("4");
        assertEquals("56",updatedClient.getId());
    }

    @Test(expected = ClientNotFoundException.class)
    public void updateClientAccountIdShouldThrowClientNotFoundException(){
        ClientService clientService = new ClientService(clientRepository);
        when(clientRepository.findClient("1")).thenReturn(null);
        clientService.updateClientAccountId("1","2");
        verify(clientRepository).deleteClient("1");
    }

    @Test
    public void createNewClientShouldAddClientToClientRepository(){
        ClientService clientService = new ClientService(clientRepository);

        when(clientRepository.findClient("1")).thenReturn(null);

        Client client= clientService.createNewClient("1");
        verify(clientRepository).saveClient(client);
        assertTrue(client.isActive());
    }

    @Test(expected = ClientAlreadyExistsException.class)
    public void createNewClientShouldThrowClientAlreadyExistsException(){
        ClientService clientService = new ClientService(clientRepository);
        Client client=new Client("1",true,null);
        when(clientRepository.findClient("1")).thenReturn(client);
        clientService.createNewClient("1");
    }

}
