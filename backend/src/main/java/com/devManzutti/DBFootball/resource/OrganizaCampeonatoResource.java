package com.devManzutti.DBFootball.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devManzutti.DBFootball.dto.OrganizaCampeonatoDTO;
import com.devManzutti.DBFootball.service.OrganizaCampeonatoService;

@RestController
@RequestMapping(value = "/organizaCampeonatos")
public class OrganizaCampeonatoResource {
	
	@Autowired
	private OrganizaCampeonatoService service;
	
	@GetMapping
	public ResponseEntity<Page<OrganizaCampeonatoDTO>> findAllPaged(Pageable pageable) {
		Page<OrganizaCampeonatoDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{idOrganizaCampeonato}")
	public ResponseEntity<OrganizaCampeonatoDTO> findById(@PathVariable Long idOrganizaCampeonato) {
		OrganizaCampeonatoDTO dto = service.findById(idOrganizaCampeonato);
		return ResponseEntity.ok().body(dto);		
	}
	
	@PostMapping
	public ResponseEntity<OrganizaCampeonatoDTO> insert(@RequestBody OrganizaCampeonatoDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getCampeonato()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<OrganizaCampeonatoDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
