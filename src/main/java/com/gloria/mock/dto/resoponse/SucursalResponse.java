package com.gloria.mock.dto.resoponse;

import lombok.Data;

@Data
public class SucursalResponse {
    private Integer idSucursal;
    private String codigoCliente;
    private String nombre;
    private String direccion;
    private String distrito;
}
