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

import com.devManzutti.DBFootball.dto.ClubeDTO;
import com.devManzutti.DBFootball.service.ClubeService;

@RestController
@RequestMapping(value = "/clubes")
public class ClubeResource {

	@Autowired
	private ClubeService service;
	
	@GetMapping
	public ResponseEntity<List<ClubeDTO>> findAll() {
		List<ClubeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ClubeDTO> insert(@RequestBody ClubeDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId_clube()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClubeDTO> update(@PathVariable String id, @RequestBody ClubeDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<ClubeDTO> delete(@PathVariable String id) { 
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
}
