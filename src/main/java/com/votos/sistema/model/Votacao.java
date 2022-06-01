package com.votos.sistema.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "votacao")
public class Votacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Pauta pauta;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Usuario usuario;
	private LocalDateTime data;
	@Enumerated(EnumType.STRING)
	private String voto;
}
