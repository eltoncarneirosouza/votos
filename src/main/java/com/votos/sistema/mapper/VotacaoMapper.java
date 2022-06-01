package com.votos.sistema.mapper;

import com.votos.sistema.model.Pauta;
import com.votos.sistema.model.Usuario;
import com.votos.sistema.model.Votacao;
import com.votos.sistema.model.payload.dto.VotacaoDTO;
import com.votos.sistema.model.payload.response.VotacaoResponse;

import java.time.LocalDateTime;

public class VotacaoMapper {


    public VotacaoResponse convert(Votacao votacao) {
        VotacaoResponse response = VotacaoResponse.builder()
                .pauta(votacao.getPauta().getDescriacao())
                .usuarioCPF(votacao.getUsuario().getCpf())
                .voto(votacao.getVoto())
                .build();
        return response;
    }

    public Votacao convertRequest(VotacaoDTO request, Usuario usuario, Pauta pauta) {
        Votacao votacao = Votacao.builder()
                .data(LocalDateTime.now())
                .pauta(pauta)
                .usuario(usuario)
                .voto(request.getVoto().toUpperCase())
                .build();
        return votacao;
    }
}
