package com.devManzutti.DBFootball.entites;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_campeonato")
public class Campeonato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCampeonato;
	
	private String campeonato;

	public Campeonato() {
	}

	public Campeonato(Long idCampeonato, String campeonato) {
		this.idCampeonato = idCampeonato;
		this.campeonato = campeonato;
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

	@Override
	public int hashCode() {
		return Objects.hash(idCampeonato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(idCampeonato, other.idCampeonato);
	}
}
