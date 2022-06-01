package com.votos.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votos.sistema.model.payload.dto.PautaDTO;
import com.votos.sistema.service.PautaService;

@RestController
@RequestMapping("v1/pauta")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPauta(@PathVariable("id") Long id) throws Exception {
        return pautaService.findId(id);

    }

    @PostMapping
    public ResponseEntity<?> postPauta(@RequestBody PautaDTO request) throws Exception {
        return pautaService.salvar(request);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPauta() throws Exception {
        return pautaService.findAll();

    }
}
