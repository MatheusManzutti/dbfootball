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
	private Long idOrganizaCampeonato;
	
	@ManyToOne
	@JoinColumn(name = "campeonato_id")
	private Campeonato campeonato;
	
	@ManyToOne
	@JoinColumn(name = "estadio_id")
	private Estadio estadio;
	
	@ManyToOne
	@JoinColumn(name = "clube1_id")
	private Clube clube1;
	
	@ManyToOne
	@JoinColumn(name = "clube2_id")
	private Clube clube2;
		
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataHora;
	
	public OrganizaCampeonato() {
	}

	public OrganizaCampeonato(Long idOrganizaCampeonato, Campeonato campeonato, Estadio estadio, Clube clube1,
			Clube clube2, Instant dataHora) {
		this.idOrganizaCampeonato = idOrganizaCampeonato;
		this.campeonato = campeonato;
		this.estadio = estadio;
		this.clube1 = clube1;
		this.clube2 = clube2;
		this.dataHora = dataHora;
	}

	public Long getIdOrganizaCampeonato() {
		return idOrganizaCampeonato;
	}

	public void setIdOrganizaCampeonato(Long idOrganizaCampeonato) {
		this.idOrganizaCampeonato = idOrganizaCampeonato;
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

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOrganizaCampeonato);
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
		return Objects.equals(idOrganizaCampeonato, other.idOrganizaCampeonato);
	}
}
