package kwan.service;

import kwan.factory.SendRequest;
import kwan.jpa.ClientJpaRepository;
import kwan.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientJpaRepository clientRepository;

    private String endpoint = "http://localhost:5000/register";

    public Client save(Client client) {
        Client c = clientRepository.save(client);

        if(c.getId() != null) {
            //send email
            SendRequest sendRequest = new SendRequest(endpoint);
            try {
                sendRequest.sendRequest(c.getInvoice(), c.getFiscalId()+"", c.getName(), c.getEmail());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return c;
    }

    public List<Client> get(String id){
        return clientRepository.findClientByInvoice(id);
    }
}
