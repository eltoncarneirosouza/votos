package com.votos.sistema.controller;

import com.votos.sistema.model.payload.dto.UsuarioDTO;
import com.votos.sistema.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<?> getUsuario(@PathVariable("id") Long id) throws Exception {
        return usuarioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> postUsuario(@RequestBody UsuarioDTO request) throws Exception {
        return usuarioService.salvar(request);
    }
}
