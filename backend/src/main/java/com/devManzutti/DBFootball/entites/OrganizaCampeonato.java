package com.devManzutti.DBFootball.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_OrganizaCampeonato")
public class OrganizaCampeonato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrganizaCampeonato;
	
	@ManyToOne
	@JoinColumn(name = "id_Campeonato")
	private Campeonato campeonato;
	
	@ManyToOne
	@JoinColumn(name = "id_Estadio")
	private Estadio estadio;
	
	@ManyToOne
	@JoinColumn(name = "id_Time_Casa")
	private Clube timeCasa;
	
	@ManyToOne
	@JoinColumn(name = "id_Time_Visitante")
	private Clube timeVisitante;
		
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataHora;
	
	public OrganizaCampeonato() {
	}

	public OrganizaCampeonato(Long idOrganizaCampeonato, Campeonato campeonato, Estadio estadio, Clube timeCasa,
			Clube timeVisitante, Instant dataHora) {
		super();
		this.idOrganizaCampeonato = idOrganizaCampeonato;
		this.campeonato = campeonato;
		this.estadio = estadio;
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
		this.dataHora = dataHora;
	}

	public Long getIdOrganizaCampeonato() {
		return idOrganizaCampeonato;
	}

	public void setIdOrganizaCampeonato(Long idOrganizaCampeonato) {
		this.idOrganizaCampeonato = idOrganizaCampeonato;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Clube getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Clube timeCasa) {
		this.timeCasa = timeCasa;
	}

	public Clube getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Clube timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public Instant getDataHora() {
		return dataHora;
	}

	public void setDataHora(Instant dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOrganizaCampeonato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizaCampeonato other = (OrganizaCampeonato) obj;
		return Objects.equals(idOrganizaCampeonato, other.idOrganizaCampeonato);
	}
}
