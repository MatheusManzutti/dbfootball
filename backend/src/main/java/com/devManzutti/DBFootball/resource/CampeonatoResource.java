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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devManzutti.DBFootball.dto.CampeonatoDTO;
import com.devManzutti.DBFootball.service.CampeonatoService;

@RestController
@RequestMapping(value = "/campeonatos")
public class CampeonatoResource {

	@Autowired
	private CampeonatoService service;
	
	@GetMapping
	public ResponseEntity<Page<CampeonatoDTO>> findAllPaged(Pageable pageable) {
		Page<CampeonatoDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<CampeonatoDTO> insert(@RequestBody CampeonatoDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getIdCampeonato()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CampeonatoDTO> update(@PathVariable(value = "id") Long idCampeonato, @RequestBody CampeonatoDTO dto) {
		dto = service.update(idCampeonato, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<CampeonatoDTO> delete(@PathVariable(value = "id") Long idCampeonato) { 
		service.delete(idCampeonato);
		return ResponseEntity.noContent().build(); 
	}
}
