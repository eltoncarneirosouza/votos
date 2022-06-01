package com.votos.sistema.model.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PautaDTO {
    private String situacao;
    private String descriacao;

}
