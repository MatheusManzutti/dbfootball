package com.devManzutti.DBFootball.entites;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_clube")
public class Clube implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClube;
	
	private String clube;
	
	public Clube() {
	}

	public Clube(Long idClube, String clube) {
		this.idClube = idClube;
		this.clube = clube;
	}
	
	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idClube);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clube other = (Clube) obj;
		return Objects.equals(idClube, other.idClube);
	}
}

