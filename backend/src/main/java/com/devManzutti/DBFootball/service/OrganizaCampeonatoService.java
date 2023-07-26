package com.devManzutti.DBFootball.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devManzutti.DBFootball.dto.OrganizaCampeonatoDTO;
import com.devManzutti.DBFootball.entites.OrganizaCampeonato;
import com.devManzutti.DBFootball.repository.OrganizaCampeonatoRepository;

import jakarta.transaction.Transactional;

@Service
public class OrganizaCampeonatoService {
	
	@Autowired
	private OrganizaCampeonatoRepository repository;
	
	@Transactional
	public List<OrganizaCampeonatoDTO> findAll() {
		List<OrganizaCampeonato> list = repository.findAll();
		return list.stream().map(x -> new OrganizaCampeonatoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrganizaCampeonatoDTO insert(OrganizaCampeonatoDTO dto) {
		OrganizaCampeonato entity = new OrganizaCampeonato();
		copyDTOToEntity(dto, entity);
		entity.setCampeonato(dto.getCampeonato());
		entity = repository.save(entity);
		return new OrganizaCampeonatoDTO(entity);
	}
	
	@Transactional
	public OrganizaCampeonatoDTO update(Long idOrganizaCampeonato, OrganizaCampeonatoDTO dto) {
		OrganizaCampeonato entity = repository.getReferenceById(idOrganizaCampeonato);
		entity.setCampeonato(dto.getCampeonato());
		entity = repository.save(entity);
		return new OrganizaCampeonatoDTO(entity);
	}
	
	public void delete(Long idOrganizaCampeonato) {
		repository.deleteById(idOrganizaCampeonato);
	}
	
	private void copyDTOToEntity(OrganizaCampeonatoDTO dto, OrganizaCampeonato entity) {		
		entity.setIdOrganizaCampeonato(dto.getIdOrganizaCampeonato());
		entity = repository.save(entity);
	}

}
