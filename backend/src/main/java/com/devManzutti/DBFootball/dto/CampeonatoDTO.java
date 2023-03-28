package com.devManzutti.DBFootball.dto;

import java.io.Serializable;

import com.devManzutti.DBFootball.entites.Campeonato;

public class CampeonatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id_campeonato;
	
	public CampeonatoDTO() {
	}

	public CampeonatoDTO(String id_campeonato) {
		this.id_campeonato = id_campeonato;
	}
	
	public CampeonatoDTO(Campeonato entity) {
		this.id_campeonato = entity.getId_campeonato();
	}

	public String getid_campeonato() {
		return id_campeonato;
	}

	public void setid_campeonato(String id_campeonato) {
		this.id_campeonato = id_campeonato;
	}

}
