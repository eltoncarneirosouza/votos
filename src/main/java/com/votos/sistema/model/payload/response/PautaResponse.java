package com.votos.sistema.model.payload.response;

import com.votos.sistema.enums.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PautaResponse {
    private Situacao situacao;
    private String descriacao;
    private LocalDateTime criacao;
}
