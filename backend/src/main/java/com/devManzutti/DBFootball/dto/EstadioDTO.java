package com.devManzutti.DBFootball.dto;

import java.io.Serializable;

import com.devManzutti.DBFootball.entites.Estadio;

public class EstadioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id_estadio;
	
	public EstadioDTO() {
	}

	public EstadioDTO(String id_estadio) {
		this.id_estadio = id_estadio;
	}
	
	public EstadioDTO(Estadio entity) {
		this.id_estadio = entity.getId_estadio();
	}

	public String getid_estadio() {
		return id_estadio;
	}

	public void setid_estadio(String id_estadio) {
		this.id_estadio = id_estadio;
	}

}
