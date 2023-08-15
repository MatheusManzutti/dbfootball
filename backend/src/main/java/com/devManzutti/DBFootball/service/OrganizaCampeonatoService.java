package com.devManzutti.DBFootball.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devManzutti.DBFootball.dto.OrganizaCampeonatoDTO;
import com.devManzutti.DBFootball.entites.OrganizaCampeonato;
import com.devManzutti.DBFootball.repository.OrganizaCampeonatoRepository;
import com.devManzutti.DBFootball.service.exceptions.DatabaseException;
import com.devManzutti.DBFootball.service.exceptions.ResourceNotFoundException;

@Service
public class OrganizaCampeonatoService {
	
	@Autowired
	private OrganizaCampeonatoRepository repository;
	
	@Transactional(readOnly = true)
	public Page<OrganizaCampeonatoDTO> findAllPaged(Pageable pageable) {
		Page<OrganizaCampeonato> list = repository.findAll(pageable);
		return list.map(x -> new OrganizaCampeonatoDTO(x));
	}
	
	@Transactional(readOnly = true)
	public OrganizaCampeonatoDTO findById(Long idOrganizaCampeonato) {
		Optional<OrganizaCampeonato> obj = repository.findById(idOrganizaCampeonato);
		OrganizaCampeonato entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrado"));
		return new OrganizaCampeonatoDTO(entity);
	}
	
	@Transactional
	public OrganizaCampeonatoDTO insert(OrganizaCampeonatoDTO dto) {
		OrganizaCampeonato entity = new OrganizaCampeonato();
		entity.setIdOrganizaCampeonato(dto.getIdOrganizaCampeonato());
		entity.setCampeonato(dto.getCampeonato());
		entity.setEstadio(dto.getEstadio());
		entity.setTimeCasa(dto.getTimeCasa());
		entity.setTimeVisitante(dto.getTimeVisitante());
		entity.setDataHora(dto.getDataHora());
		entity = repository.save(entity);
		return new OrganizaCampeonatoDTO(entity);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long idOrganizaCampeonato) {
		if (!repository.existsById(idOrganizaCampeonato)) {
			throw new ResourceNotFoundException("Id não encontrado: " + idOrganizaCampeonato);
		}
		try {
	        repository.deleteById(idOrganizaCampeonato);    		
		}
	    catch (DataIntegrityViolationException e) {
	        	throw new DatabaseException("Violação de integridade");
	   	}
	}
}
