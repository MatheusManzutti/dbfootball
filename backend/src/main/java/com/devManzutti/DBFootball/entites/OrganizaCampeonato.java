package com.devManzutti.DBFootball.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_partida")
public class OrganizaCampeonato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_organizaCampeonato;
	
	@ManyToOne
	@JoinColumn(name = "id_campeonato")
	private Campeonato campeonato;
	
	@ManyToOne
	@JoinColumn(name = "id_estadio")
	private Estadio estadio;
	
	@ManyToOne
	@JoinColumn(name = "id_clube1")
	private Clube clube1;
	
	@ManyToOne
	@JoinColumn(name = "id_clube2")
	private Clube clube2;
		
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataHora;
	
	public OrganizaCampeonato() {
	}

	public OrganizaCampeonato(Long id_organizaCampeonato, Campeonato campeonato, Estadio estadio, Clube clube1,
			Clube clube2, Instant dataHora) {
		super();
		this.id_organizaCampeonato = id_organizaCampeonato;
		this.campeonato = campeonato;
		this.estadio = estadio;
		this.clube1 = clube1;
		this.clube2 = clube2;
		this.dataHora = dataHora;
	}

	public Long getId_organizaCampeonato() {
		return id_organizaCampeonato;
	}

	public void setId_organizaCampeonato(Long id_organizaCampeonato) {
		this.id_organizaCampeonato = id_organizaCampeonato;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Clube getClube1() {
		return clube1;
	}

	public void setClube1(Clube clube1) {
		this.clube1 = clube1;
	}

	public Clube getClube2() {
		return clube2;
	}

	public void setClube2(Clube clube2) {
		this.clube2 = clube2;
	}	
	
	public Instant getdataHora() {
		return dataHora;
	}

	public void setdataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_organizaCampeonato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizaCampeonato other = (OrganizaCampeonato) obj;
		return Objects.equals(id_organizaCampeonato, other.id_organizaCampeonato);
	}
}
