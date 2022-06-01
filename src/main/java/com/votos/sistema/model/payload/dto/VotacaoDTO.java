package com.votos.sistema.model.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotacaoDTO {
    private String pauta;
    private String usuarioCPF;
    private String voto;

}
