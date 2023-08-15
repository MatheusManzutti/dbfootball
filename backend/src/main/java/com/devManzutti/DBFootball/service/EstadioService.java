package com.devManzutti.DBFootball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devManzutti.DBFootball.dto.EstadioDTO;
import com.devManzutti.DBFootball.entites.Estadio;
import com.devManzutti.DBFootball.repository.EstadioRepository;
import com.devManzutti.DBFootball.service.exceptions.DatabaseException;
import com.devManzutti.DBFootball.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstadioService {

	@Autowired
	private EstadioRepository repository;
	
	@Transactional(readOnly = true)
	public Page<EstadioDTO> findAllPaged(Pageable pageable) {
		Page<Estadio> list = repository.findAll(pageable);
		return list.map(x -> new EstadioDTO(x));
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
		try {
			Estadio entity = repository.getReferenceById(idEstadio);
			entity.setEstadio(dto.getEstadio());
			entity = repository.save(entity);
			return new EstadioDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado: " + idEstadio);
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long idEstadio) {
		if (!repository.existsById(idEstadio)) {
			throw new ResourceNotFoundException("Id não encontrado: " + idEstadio);
		}
		try {
	       	repository.deleteById(idEstadio);    		
		}
	    catch (DataIntegrityViolationException e) {
	       	throw new DatabaseException("Violação de integridade");
	   	}
	}
	
	private void copyDTOToEntity(EstadioDTO dto, Estadio entity) {		
		entity.setIdEstadio(dto.getIdEstadio());
		entity = repository.save(entity);
	}	
}
