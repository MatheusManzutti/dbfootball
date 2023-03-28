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
		return new CampeonatoDTO(entity);
	}
	
	@Transactional
	public CampeonatoDTO update(String id, CampeonatoDTO dto) {
		Campeonato entity = repository.getReferenceById(id);
		copyDTOToEntity(dto, entity);
		return new CampeonatoDTO(entity);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	private void copyDTOToEntity(CampeonatoDTO dto, Campeonato entity) {		
		entity.setId_campeonato(dto.getid_campeonato());
		entity = repository.save(entity);
	}
}
