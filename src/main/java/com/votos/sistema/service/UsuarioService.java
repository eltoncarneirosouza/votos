package com.votos.sistema.service;

import com.votos.sistema.mapper.UsuarioMapper;
import com.votos.sistema.model.Usuario;
import com.votos.sistema.model.payload.dto.UsuarioDTO;
import com.votos.sistema.model.payload.response.UsuarioResponse;
import com.votos.sistema.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioMapper mapper;

    public ResponseEntity<?> findById(Long id) throws Exception {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (!optional.isEmpty()) {
            return ResponseEntity.ok(optional.get());
        } else {
            throw new Exception("Error : Pesquisa sem valor encontrado!");
        }
    }

    public ResponseEntity<?> salvar(UsuarioDTO request) throws Exception {
        try {
            Optional<Usuario> optional = usuarioRepository.findByCpf(request.getCpf());
            if (!optional.isEmpty()) {
                UsuarioResponse response = mapper.convertToResponse(optional.get());
                return ResponseEntity.ok(response);
            }
            Usuario usuario = mapper.convert(request);
            Usuario save = usuarioRepository.save(usuario);
            UsuarioResponse response = mapper.convertToResponse(save);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
