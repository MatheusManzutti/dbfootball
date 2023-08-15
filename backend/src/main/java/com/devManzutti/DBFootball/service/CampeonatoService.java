package com.devManzutti.DBFootball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devManzutti.DBFootball.dto.CampeonatoDTO;
import com.devManzutti.DBFootball.entites.Campeonato;
import com.devManzutti.DBFootball.repository.CampeonatoRepository;
import com.devManzutti.DBFootball.service.exceptions.DatabaseException;
import com.devManzutti.DBFootball.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CampeonatoService {
	
	@Autowired
	private CampeonatoRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CampeonatoDTO> findAllPaged(Pageable pageable) {
		Page<Campeonato> list = repository.findAll(pageable);
		return list.map(x -> new CampeonatoDTO(x));
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
		try {
			Campeonato entity = repository.getReferenceById(idCampeonato);
			entity.setCampeonato(dto.getCampeonato());
			entity = repository.save(entity);
			return new CampeonatoDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado: " + idCampeonato);
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long idCampeonato) {
		if (!repository.existsById(idCampeonato)) {
			throw new ResourceNotFoundException("Id não encontrado: " + idCampeonato);
		}
		try {
	        	repository.deleteById(idCampeonato);    		
		}
	    	catch (DataIntegrityViolationException e) {
	        	throw new DatabaseException("Violação de integridade");
	   	}
	}
	
	private void copyDTOToEntity(CampeonatoDTO dto, Campeonato entity) {		
		entity.setIdCampeonato(dto.getIdCampeonato());
		entity = repository.save(entity);
	}
}
