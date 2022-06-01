package com.votos.sistema.repository;

import com.votos.sistema.model.Pauta;
import com.votos.sistema.model.Usuario;
import com.votos.sistema.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
    Optional<Votacao> findByVotacaoExistente(Usuario usuario, Pauta pauta);
}
