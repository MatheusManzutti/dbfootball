package com.devManzutti.DBFootball.dto;

import java.io.Serializable;

import com.devManzutti.DBFootball.entites.Estadio;

public class EstadioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idEstadio;
	private String estadio;
	
	public EstadioDTO() {
	}

	public EstadioDTO(Long idEstadio, String estadio) {
		this.idEstadio = idEstadio;
		this.estadio = estadio;
	}
	
	public EstadioDTO(Estadio entity) {
		this.idEstadio = entity.getIdEstadio();
		this.estadio = entity.getEstadio();
	}

	public Long getIdEstadio() {
		return idEstadio;
	}

	public void setIdEstadio(Long idEstadio) {
		this.idEstadio = idEstadio;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
}
