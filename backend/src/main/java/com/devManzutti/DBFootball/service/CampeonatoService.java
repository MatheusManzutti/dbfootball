package com.devManzutti.DBFootball.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devManzutti.DBFootball.dto.CampeonatoDTO;
import com.devManzutti.DBFootball.entites.Campeonato;
import com.devManzutti.DBFootball.repository.CampeonatoRepository;

@Service
public class CampeonatoService {

	@Autowired
	private CampeonatoRepository repository;
	
	@Transactional(readOnly = true)
	public List<CampeonatoDTO> findAll() {
		List<Campeonato> list = repository.findAll();
		return list.stream().map(x -> new CampeonatoDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public CampeonatoDTO insert(CampeonatoDTO dto) {
		Campeonato entity = new Campeonato();
		copyDTOToEntity(dto, entity);
		entity.setCampeonato(dto.getCampeonato());
		entity = repository.save(entity);
		return new CampeonatoDTO(entity);
	}
	
	@Transactional
	public CampeonatoDTO update(Long idCampeonato, CampeonatoDTO dto) {
		Campeonato entity = repository.getReferenceById(idCampeonato);
		entity.setCampeonato(dto.getCampeonato());
		entity = repository.save(entity);
		return new CampeonatoDTO(entity);
	}
	
	public void delete(Long idCampeonato) {
		repository.deleteById(idCampeonato);
	}
	
	private void copyDTOToEntity(CampeonatoDTO dto, Campeonato entity) {		
		entity.setIdCampeonato(dto.getIdCampeonato());
		entity = repository.save(entity);
	}
}
