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

import com.devManzutti.DBFootball.dto.EstadioDTO;
import com.devManzutti.DBFootball.service.EstadioService;

@RestController
@RequestMapping(value = "/estadios")
public class EstadioResource {

	@Autowired
	private EstadioService service;
	
	@GetMapping
	public ResponseEntity<Page<EstadioDTO>> findAllPaged(Pageable pageable) {
		Page<EstadioDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<EstadioDTO> insert(@RequestBody EstadioDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getIdEstadio()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EstadioDTO> update(@PathVariable Long id, @RequestBody EstadioDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<EstadioDTO> delete(@PathVariable Long id) { 
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
}
