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
		entity.setEstadio(dto.getEstadio());
		entity = repository.save(entity);
		return new EstadioDTO(entity);
	}
	
	@Transactional
	public EstadioDTO update(Long idEstadio, EstadioDTO dto) {
		Estadio entity = repository.getReferenceById(idEstadio);
		entity.setEstadio(dto.getEstadio());
		entity = repository.save(entity);
		return new EstadioDTO(entity);
	}
	
	public void delete(Long idEstadio) {
		repository.deleteById(idEstadio);
	}
	
	private void copyDTOToEntity(EstadioDTO dto, Estadio entity) {		
		entity.setIdEstadio(dto.getIdEstadio());
		entity = repository.save(entity);
	}
}
