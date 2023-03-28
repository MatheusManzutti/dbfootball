package com.devManzutti.DBFootball.dto;

import java.io.Serializable;

import com.devManzutti.DBFootball.entites.Clube;

public class ClubeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id_clube;
	
	public ClubeDTO() {
	}

	public ClubeDTO(String id_clube) {
		this.id_clube = id_clube;
	}
	
	public ClubeDTO(Clube entity) {
		this.id_clube = entity.getId_clube();
	}

	public String getId_clube() {
		return id_clube;
	}

	public void setId_clube(String id_clube) {
		this.id_clube = id_clube;
	}
}
