package kwan.controller;

import kwan.controller.interfaces.IClientController;
import kwan.model.Client;
import kwan.request.CreateClientRequestDto;
import kwan.response.CreateClientResponseDto;
import kwan.response.GetClientResponseDto;
import kwan.response.GetClientsResponseDto;
import kwan.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
public class ClientController implements IClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ModelMapper mapper;

    @Override
    @PostMapping("/store-bahamas-client/{id}")
    public ResponseEntity<CreateClientResponseDto> createClient(@PathVariable("id") String id,
                                                                @RequestBody @Valid CreateClientRequestDto requestBody) {
        Client client = mapper.map(requestBody, Client.class);
        client.setInvoice(id);
        client = clientService.save(client);
        CreateClientResponseDto responseDto = mapper.map(client, CreateClientResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/retrieve-bahamas-client/{id}")
    public ResponseEntity<GetClientsResponseDto> getClients(@PathVariable("id") String id) {
        List<Client> c = clientService.get(id);
        GetClientsResponseDto response = new GetClientsResponseDto();
        for(Client client : c) {
            response.addClient(mapper.map(client, GetClientResponseDto.class));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
