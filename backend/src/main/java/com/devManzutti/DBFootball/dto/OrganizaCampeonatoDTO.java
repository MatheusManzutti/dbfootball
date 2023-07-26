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
	private Campeonato Campeonato;
	private Estadio Estadio;
	private Clube Clube1;
	private Clube Clube2;
	private Instant dataHora;
	
	public OrganizaCampeonatoDTO() {
	}
	
	public OrganizaCampeonatoDTO(Long idOrganizaCampeonato, Campeonato campeonato, Estadio estadio,
			Clube clube1, Clube clube2, Instant dataHora) {
		this.idOrganizaCampeonato = idOrganizaCampeonato;
		this.Campeonato = campeonato;
		this.Estadio = estadio;
		this.Clube1 = clube1;
		this.Clube2 = clube2;
		this.dataHora = dataHora;
	}

	public OrganizaCampeonatoDTO(OrganizaCampeonato entity) {
		this.idOrganizaCampeonato = entity.getIdOrganizaCampeonato();
		this.Campeonato = entity.getCampeonato();
		this.Estadio = entity.getEstadio();
		this.Clube1 = entity.getClube2();
		this.Clube2 = entity.getClube1();
		this.dataHora = entity.getDataHora();
	}

	public Long getIdOrganizaCampeonato() {
		return idOrganizaCampeonato;
	}

	public void setIdOrganizaCampeonato(Long idOrganizaCampeonato) {
		this.idOrganizaCampeonato = idOrganizaCampeonato;
	}

	public Campeonato getCampeonato() {
		return Campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		Campeonato = campeonato;
	}

	public Estadio getEstadio() {
		return Estadio;
	}

	public void setEstadio(Estadio estadio) {
		Estadio = estadio;
	}

	public Clube getClube1() {
		return Clube1;
	}

	public void setClube1(Clube clube1) {
		Clube1 = clube1;
	}

	public Clube getClube2() {
		return Clube2;
	}

	public void setClube2(Clube clube2) {
		Clube2 = clube2;
	}

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}
}
