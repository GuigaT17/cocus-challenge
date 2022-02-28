package kwan.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotNull
    private int fiscalId;
}
