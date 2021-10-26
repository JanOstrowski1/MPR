import client.Client;

public class Response {
    private int status;
    private Client client;

    public Response(int status, Client client) {
        this.status = status;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
