package com.devManzutti.DBFootball.dto;

import java.io.Serializable;

import com.devManzutti.DBFootball.entites.Campeonato;

public class CampeonatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idCampeonato;
	private String campeonato;
	
	public CampeonatoDTO() {
	}

	public CampeonatoDTO(Long idCampeonato, String campeonato) {
		this.idCampeonato = idCampeonato;
		this.campeonato = campeonato;
	}
	
	public CampeonatoDTO(Campeonato entity) {
		this.idCampeonato = entity.getIdCampeonato();
		this.campeonato = entity.getCampeonato();
	}

	public Long getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(Long idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public String getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}
}
