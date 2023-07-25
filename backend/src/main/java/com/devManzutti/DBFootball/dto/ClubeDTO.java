package com.devManzutti.DBFootball.dto;

import java.io.Serializable;

import com.devManzutti.DBFootball.entites.Clube;

public class ClubeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idClube;
	private String clube;
	
	public ClubeDTO() {
	}

	public ClubeDTO(Long idClube, String clube) {
		this.idClube = idClube;
		this.clube = clube;
	}
	
	public ClubeDTO(Clube entity) {
		this.idClube = entity.getIdClube();
		this.clube = entity.getClube();
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setId(Long idClube) {
		this.idClube = idClube;
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}
}
