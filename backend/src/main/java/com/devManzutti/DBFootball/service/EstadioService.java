package com.devManzutti.DBFootball.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devManzutti.DBFootball.dto.EstadioDTO;
import com.devManzutti.DBFootball.entites.Estadio;
import com.devManzutti.DBFootball.repository.EstadioRepository;

@Service
public class EstadioService {

	@Autowired
	private EstadioRepository repository;
	
	@Transactional(readOnly = true)
	public List<EstadioDTO> findAll() {
		List<Estadio> list = repository.findAll();
		return list.stream().map(x -> new EstadioDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public EstadioDTO insert(EstadioDTO dto) {
		Estadio entity = new Estadio();
		copyDTOToEntity(dto, entity);
		return new EstadioDTO(entity);
	}
	
	@Transactional
	public EstadioDTO update(String id, EstadioDTO dto) {
		Estadio entity = repository.getReferenceById(id);
		copyDTOToEntity(dto, entity);
		return new EstadioDTO(entity);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	private void copyDTOToEntity(EstadioDTO dto, Estadio entity) {		
		entity.setId_estadio(dto.getid_estadio());
		entity = repository.save(entity);
	}
}
