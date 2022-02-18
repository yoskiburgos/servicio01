package com.gloria.mock.dto.resoponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidarClienteResponse {
    private ResponseStatus responseStatus;
    private ResponseData responseData;
}
