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
@Table(name = "tb_campeonato")
public class Campeonato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id_campeonato;
	
	@OneToMany(mappedBy = "campeonato")
	List<OrganizaCampeonato> organizaCampeonato = new ArrayList<>();
	
	public Campeonato() {
	}

	public Campeonato(String id_campeonato) {
		this.id_campeonato = id_campeonato;
	}

	public String getId_campeonato() {
		return id_campeonato;
	}

	public void setId_campeonato(String id_campeonato) {
		this.id_campeonato = id_campeonato;
	}
	
	public List<OrganizaCampeonato> getOrganizaCampeonato() {
		return organizaCampeonato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_campeonato);
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
		return Objects.equals(id_campeonato, other.id_campeonato);
	}
}
