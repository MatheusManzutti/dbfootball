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
	private Clube timeCasa;
	private Clube timeVisitante;
	private Instant dataHora;
	
	public OrganizaCampeonatoDTO() {
	}
	public OrganizaCampeonatoDTO(Long idOrganizaCampeonato, Campeonato campeonato, Estadio estadio, Clube timeCasa,
			Clube timeVisitante, Instant dataHora) {
		this.idOrganizaCampeonato = idOrganizaCampeonato;
		this.campeonato = campeonato;
		this.estadio = estadio;
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
		this.dataHora = dataHora;
	}
	
	public OrganizaCampeonatoDTO(OrganizaCampeonato entity) {
		this.idOrganizaCampeonato = entity.getIdOrganizaCampeonato();
		this.campeonato = entity.getCampeonato();
		this.estadio = entity.getEstadio();
		this.timeCasa = entity.getTimeCasa();
		this.timeVisitante = entity.getTimeVisitante();
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
	
	public Clube getTimeCasa() {
		return timeCasa;
	}
	
	public void setTimeCasa(Clube timeCasa) {
		this.timeCasa = timeCasa;
	}
	
	public Clube getTimeVisitante() {
		return timeVisitante;
	}
	
	public void setTimeVisitante(Clube timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	
	public Instant getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}
}
