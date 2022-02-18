package com.gloria.mock.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class EnrolarRequest {
    private String telefono;
    private List<SucursalRequest> sucursales;
}
