package com.gloria.mock.dto.request;

import lombok.Data;

@Data
public class ValidarClienteRequest {
    private Integer tipo;
    private String documento;
    private String telefono;
}
