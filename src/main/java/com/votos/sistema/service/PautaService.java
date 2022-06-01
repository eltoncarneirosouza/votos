package com.votos.sistema.service;

import com.votos.sistema.mapper.PautaMapper;
import com.votos.sistema.model.Pauta;
import com.votos.sistema.model.payload.dto.PautaDTO;
import com.votos.sistema.model.payload.response.PautaResponse;
import com.votos.sistema.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;

    private PautaMapper mapper;

    public ResponseEntity<Pauta> findId(Long id) throws Exception {
        Optional<Pauta> optional = pautaRepository.findById(id);
        if (!optional.isEmpty()) {
            return ResponseEntity.ok(optional.get());
        } else {
            throw new Exception("Error : Pesquisa sem valor encontrado!");
        }
    }

    public ResponseEntity<?> salvar(PautaDTO request) throws Exception {
        try {
            Optional<Pauta> optional = pautaRepository.findByDescriacao(request.getDescriacao().toUpperCase());
            if (!optional.isEmpty()) {
                PautaResponse response = mapper.convertToResponse(optional.get());
                return ResponseEntity.ok(response);
            }
            Pauta pauta = mapper.convert(request);
            Pauta save = pautaRepository.save(pauta);
            PautaResponse response = mapper.convertToResponse(save);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public ResponseEntity<?> findAll() throws Exception {
        List<Pauta> list = pautaRepository.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            throw new Exception("Error : Pesquisa nula ou vazia!");
        }
    }
}
