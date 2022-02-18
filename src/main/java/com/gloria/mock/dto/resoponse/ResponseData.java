package com.gloria.mock.dto.resoponse;

import java.util.List;
import lombok.Data;

@Data
public class ResponseData {
    private Integer idCliente;
    private String nombre;
    private SegmentacionResponse segmentacion;
    private List<SucursalResponse> sucursales;
}
