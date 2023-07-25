package com.devManzutti.DBFootball.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devManzutti.DBFootball.dto.ClubeDTO;
import com.devManzutti.DBFootball.entites.Clube;
import com.devManzutti.DBFootball.repository.ClubeRepository;

@Service
public class ClubeService {
	
	@Autowired
	private ClubeRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClubeDTO> findAll() {
		List<Clube> list = repository.findAll();
		return list.stream().map(x -> new ClubeDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public ClubeDTO insert(ClubeDTO dto) {
		Clube entity = new Clube();
		copyDTOToEntity(dto, entity);
		entity.setClube(dto.getClube());
		entity = repository.save(entity);
		return new ClubeDTO(entity);
	}
	
	@Transactional
	public ClubeDTO update(Long idClube, ClubeDTO dto) {
		Clube entity = repository.getReferenceById(idClube);
		entity.setClube(dto.getClube());
		entity = repository.save(entity);
		return new ClubeDTO(entity);
	}
	
	public void delete(Long idClube) {
		repository.deleteById(idClube);
	}
	
	private void copyDTOToEntity(ClubeDTO dto, Clube entity) {		
		entity.setIdClube(dto.getIdClube());
		entity = repository.save(entity);
	}
}
