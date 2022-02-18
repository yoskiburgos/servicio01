package com.gloria.mock.dto.resoponse;
import java.util.List;

import lombok.Data;

@Data
public class SegmentacionResponse {
    private String nombre;
    private List<BeneficioResponse> beneficios;
}
