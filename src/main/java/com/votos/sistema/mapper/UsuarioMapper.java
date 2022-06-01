package com.votos.sistema.mapper;

import com.votos.sistema.model.Usuario;
import com.votos.sistema.model.payload.dto.UsuarioDTO;
import com.votos.sistema.model.payload.response.UsuarioResponse;

public class UsuarioMapper {

    public static Usuario convert(UsuarioDTO request) {
        Usuario usuario = Usuario.builder()
                .cpf(request.getCpf())
                .nome(request.getNome().toUpperCase())
                .build();
        return usuario;
    }

    public static UsuarioResponse convertToResponse(Usuario save) {
        UsuarioResponse response = UsuarioResponse.builder()
                .cpf(save.getCpf())
                .nome(save.getNome())
                .build();
        return response;
    }
}
