package com.votos.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votos.sistema.model.Pauta;

import java.util.Optional;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
    Optional<Pauta> findByDescriacao(String descriacao);

}
