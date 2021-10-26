package client;

import exception.ClientAlreadyExistsException;
import exception.ClientAlreadyInactiveException;
import exception.ClientNotFoundException;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client disableClientAccount(String id) {
        Client client = clientRepository.findClient(id);

        if (client == null) {
            throw new ClientNotFoundException();
        }

        if (!client.isActive()) {
            throw new ClientAlreadyInactiveException();
        }

        client.setActive(false);

        clientRepository.saveClient(client);

        return client;
    }

    public Client updateClientAccountId(String clientId, String newClientId) {

        Client client = clientRepository.findClient(clientId);

        if (client == null) {
            throw new ClientNotFoundException();
        }

        client.setId(newClientId);

        clientRepository.saveClient(client);

        clientRepository.deleteClient(clientId);

        return client;
    }

    public Client createNewClient(String clientId) {
        Client client = clientRepository.findClient(clientId);

        if (client != null) {
            throw new ClientAlreadyExistsException();
        } else {
            client = new Client();
            client.setActive(true);
            client.setId(clientId);

            clientRepository.saveClient(client);

            return client;
        }
    }
}
