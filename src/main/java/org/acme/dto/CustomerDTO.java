package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String nome;
    private String phone;
    private String email;
    private Long age;

}
