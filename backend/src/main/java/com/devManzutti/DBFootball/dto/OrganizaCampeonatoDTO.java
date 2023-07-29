package com.devManzutti.DBFootball.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devManzutti.DBFootball.entites.Campeonato;
import com.devManzutti.DBFootball.entites.Clube;
import com.devManzutti.DBFootball.entites.Estadio;
import com.devManzutti.DBFootball.entites.OrganizaCampeonato;

public class OrganizaCampeonatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idOrganizaCampeonato;
	private Campeonato campeonato;
	private Estadio estadio;
	private Clube clube1;
	private Clube clube2;
	private Instant dataHora;
	
	public OrganizaCampeonatoDTO() {
	}
	
	public OrganizaCampeonatoDTO(Long idOrganizaCampeonato, Campeonato campeonato, Estadio estadio,
			Clube clube1, Clube clube2, Instant dataHora) {
		this.idOrganizaCampeonato = idOrganizaCampeonato;
		this.campeonato = campeonato;
		this.estadio = estadio;
		this.clube1 = clube1;
		this.clube2 = clube2;
		this.dataHora = dataHora;
	}

	public OrganizaCampeonatoDTO(OrganizaCampeonato entity) {
		this.idOrganizaCampeonato = entity.getIdOrganizaCampeonato();
		this.campeonato = entity.getCampeonato();
		this.estadio = entity.getEstadio();
		this.clube1 = entity.getClube2();
		this.clube2 = entity.getClube1();
		this.dataHora = entity.getDataHora();
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
}
