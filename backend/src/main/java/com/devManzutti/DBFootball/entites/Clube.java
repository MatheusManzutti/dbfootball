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
@Table(name = "tb_clube")
public class Clube implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id_clube;
	
	@OneToMany(mappedBy = "clube1")
	List<OrganizaCampeonato> organizaCampeonato1 = new ArrayList<>();
	
	@OneToMany(mappedBy = "clube2")
	List<OrganizaCampeonato> organizaCampeonato2 = new ArrayList<>();
	
	public Clube() {
	}

	public Clube(String id_clube) {
		this.id_clube = id_clube;
	}

	public String getId_clube() {
		return id_clube;
	}

	public void setId_clube(String id_clube) {
		this.id_clube = id_clube;
	}

	public List<OrganizaCampeonato> getClube1() {
		return organizaCampeonato1;
	}
	
	public List<OrganizaCampeonato> getClube2() {
		return organizaCampeonato2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_clube);
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
		return Objects.equals(id_clube, other.id_clube);
	}
}
