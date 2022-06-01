package com.votos.sistema.controller;

import com.votos.sistema.model.payload.dto.UsuarioDTO;
import com.votos.sistema.model.payload.dto.VotacaoDTO;
import com.votos.sistema.service.UsuarioService;
import com.votos.sistema.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/votacao")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @GetMapping("{id}")
    public ResponseEntity<?> getUsuario(@PathVariable("id") Long id) throws Exception {
        return votacaoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> postUsuario(@RequestBody VotacaoDTO request) throws Exception {
        return votacaoService.salvar(request);
    }
}
