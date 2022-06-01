package com.votos.sistema.model.payload.response;

import com.votos.sistema.enums.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VotacaoResponse {
    private String pauta;
    private String usuarioCPF;
    private String voto;
}
