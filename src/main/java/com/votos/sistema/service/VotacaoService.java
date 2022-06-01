package com.votos.sistema.service;

import com.votos.sistema.enums.Situacao;
import com.votos.sistema.mapper.VotacaoMapper;
import com.votos.sistema.model.Pauta;
import com.votos.sistema.model.Usuario;
import com.votos.sistema.model.Votacao;
import com.votos.sistema.model.payload.dto.VotacaoDTO;
import com.votos.sistema.model.payload.response.UsuarioResponse;
import com.votos.sistema.model.payload.response.VotacaoResponse;
import com.votos.sistema.repository.PautaRepository;
import com.votos.sistema.repository.UsuarioRepository;
import com.votos.sistema.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class VotacaoService {

    @Autowired
    private VotacaoRepository votacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PautaRepository pautaRepository;
    private VotacaoMapper mapper;

    public ResponseEntity<?> findById(Long id) throws Exception {
        Optional<Votacao> optional = votacaoRepository.findById(id);
        if (!optional.isEmpty()) {
            Votacao votacao = optional.get();
            VotacaoResponse response = mapper.convert(votacao);
            return ResponseEntity.ok(response);
        } else {
            throw new Exception("Error : Pesquisa sem valor encontrado!");
        }
    }

    public ResponseEntity<?> salvar(VotacaoDTO request) throws Exception {
        LocalDateTime agora = LocalDateTime.now();
        try {
            Optional<Usuario> byUsuario = usuarioRepository.findByCpf(request.getUsuarioCPF());
            if (!byUsuario.isEmpty()) {
                throw new Exception("Erro usuario não encontrado!");
            }
            Optional<Pauta> byPauta = pautaRepository.findByDescriacao(request.getPauta());
            if (!byPauta.isEmpty()) {
                throw new Exception("Erro pauta não encontrado!");
            }
            Usuario usuario = byUsuario.get();
            Pauta pauta = byPauta.get();
            if (pauta.getSituacao().equals(Situacao.FECHADO)) {
                throw new Exception("Votação encontra-se fechado!");
            }

            Optional<Votacao> byVotacao = votacaoRepository.findByVotacaoExistente(usuario, pauta);
            if (!byVotacao.isEmpty()) {
                Votacao votacao = byVotacao.get();
                VotacaoResponse response = mapper.convert(votacao);
                return ResponseEntity.ok(response);
            }
            LocalDateTime time = pauta.getCriacao().plus(2, ChronoUnit.MINUTES);
            if (time.isBefore(agora)) {
                throw new Exception("Tempo de votação encerrado!!");
            } else {
                Votacao votacao = mapper.convertRequest(request, usuario, pauta);
                VotacaoResponse response = mapper.convert(votacao);
                return ResponseEntity.ok(response);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
