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
		return new ClubeDTO(entity);
	}
	
	@Transactional
	public ClubeDTO update(String id, ClubeDTO dto) {
		Clube entity = repository.getReferenceById(id);
		copyDTOToEntity(dto, entity);
		return new ClubeDTO(entity);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	private void copyDTOToEntity(ClubeDTO dto, Clube entity) {		
		entity.setId_clube(dto.getId_clube());
		entity = repository.save(entity);
	}
}
