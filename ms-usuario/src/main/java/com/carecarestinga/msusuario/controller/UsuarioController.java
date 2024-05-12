package com.carecarestinga.msusuario.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carecarestinga.msusuario.entities.Usuario;
import com.carecarestinga.msusuario.repositories.UserRepository;

@RestController
@RequestMapping(value = "/msusuario")
public class UsuarioController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}	
	
	@GetMapping(value = "/email")
	public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {
		Usuario obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
