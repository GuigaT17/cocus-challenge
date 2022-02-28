package kwan.controller.interfaces;

import kwan.request.CreateClientRequestDto;
import kwan.response.CreateClientResponseDto;
import kwan.response.GetClientsResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IClientController {

    @PostMapping
    ResponseEntity<CreateClientResponseDto> createClient(@PathVariable("id") String id,
                                                         @RequestBody CreateClientRequestDto requestBody);

    @GetMapping
    ResponseEntity<GetClientsResponseDto> getClients(@PathVariable("id") String id);
}
