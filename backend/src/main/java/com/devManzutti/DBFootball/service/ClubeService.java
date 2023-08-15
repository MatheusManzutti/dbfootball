package com.devManzutti.DBFootball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import com.devManzutti.DBFootball.dto.ClubeDTO;
import com.devManzutti.DBFootball.entites.Clube;
import com.devManzutti.DBFootball.repository.ClubeRepository;
import com.devManzutti.DBFootball.service.exceptions.DatabaseException;
import com.devManzutti.DBFootball.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClubeService {
	
	@Autowired
	private ClubeRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClubeDTO> findAllPaged(Pageable pageable) {
		Page<Clube> list = repository.findAll(pageable);
		return list.map(x -> new ClubeDTO(x));
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
		try {
			Clube entity = repository.getReferenceById(idClube);
			entity.setClube(dto.getClube());
			entity = repository.save(entity);
			return new ClubeDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceAccessException("Id não encontrado: " + idClube);
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long idClube) {
		if (!repository.existsById(idClube)) {
			throw new ResourceNotFoundException("Id não encontrado: " + idClube);
		}
		try {
	       	repository.deleteById(idClube);    		
		}
	    catch (DataIntegrityViolationException e) {
	       	throw new DatabaseException("Violação de integridade");
	   	}
	}
	
	private void copyDTOToEntity(ClubeDTO dto, Clube entity) {		
		entity.setIdClube(dto.getIdClube());
		entity = repository.save(entity);
	}
}
