package com.devManzutti.DBFootball.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estadio")
public class Estadio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id_estadio;
	
	@OneToMany(mappedBy = "estadio")
	List<OrganizaCampeonato> organizaCampeonato = new ArrayList<>();
	
	public Estadio() {
	}

	public Estadio(String id_estadio) {
		this.id_estadio = id_estadio;
	}

	public String getId_estadio() {
		return id_estadio;
	}

	public void setId_estadio(String id_estadio) {
		this.id_estadio = id_estadio;
	}

	public List<OrganizaCampeonato> getOrganizaCampeonato() {
		return organizaCampeonato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_estadio);
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
		return Objects.equals(id_estadio, other.id_estadio);
	}
}
