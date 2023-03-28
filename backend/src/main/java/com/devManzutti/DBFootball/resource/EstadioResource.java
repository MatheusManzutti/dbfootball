package com.devManzutti.DBFootball.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<EstadioDTO>> findAll() {
		List<EstadioDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<EstadioDTO> insert(@RequestBody EstadioDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getid_estadio()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EstadioDTO> update(@PathVariable String id, @RequestBody EstadioDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<EstadioDTO> delete(@PathVariable String id) { 
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
}
