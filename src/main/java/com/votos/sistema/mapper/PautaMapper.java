package com.votos.sistema.mapper;

import com.votos.sistema.enums.Situacao;
import com.votos.sistema.model.Pauta;
import com.votos.sistema.model.payload.dto.PautaDTO;
import com.votos.sistema.model.payload.response.PautaResponse;

import java.time.LocalDateTime;

public class PautaMapper {

    public static Pauta convert(PautaDTO request) {
        Pauta pauta = Pauta.builder()
                .situacao(Situacao.valueOf(request.getSituacao().toUpperCase()))
                .descriacao(request.getDescriacao().toUpperCase())
                .criacao(LocalDateTime.now())
                .build();
        return pauta;
    }

    public static PautaResponse convertToResponse(Pauta save) {
        PautaResponse response = PautaResponse.builder()
                .descriacao(save.getDescriacao())
                .situacao(save.getSituacao())
                .criacao(save.getCriacao())
                .build();
        return response;
    }
}
