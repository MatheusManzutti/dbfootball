package com.devManzutti.DBFootball.entites;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estadio")
public class Estadio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadio;
	
	private String estadio;
	
	public Estadio() {
	}

	public Estadio(Long idEstadio, String estadio) {
		this.idEstadio = idEstadio;
		this.estadio = estadio;
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

	@Override
	public int hashCode() {
		return Objects.hash(idEstadio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadio other = (Estadio) obj;
		return Objects.equals(idEstadio, other.idEstadio);
	}
}
