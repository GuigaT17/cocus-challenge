package kwan.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetClientsResponseDto {
    private List<GetClientResponseDto> clients = new ArrayList<>();

    public void addClient(GetClientResponseDto c) {
        clients.add(c);
    }
}
