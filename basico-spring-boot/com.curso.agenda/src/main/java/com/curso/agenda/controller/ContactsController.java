package com.curso.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.agenda.modelo.Contact;
import com.curso.agenda.repository.ContactsRepository;

@RestController
public class ContactsController {

	@Autowired
	ContactsRepository repository;

	@GetMapping("/contacts")
	public Page<Contact> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@PostMapping("/contacts")
	public ResponseEntity<?> create(@RequestBody Contact contact) {
		try {
			Contact c = repository.save(contact);
			return new ResponseEntity<Contact>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 

	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("Registro eliminado", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/contacts")
	public ResponseEntity<?> update(@RequestBody Contact contact) {
		try {
			Contact c = repository.save(contact);
			return new ResponseEntity<Contact>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
}
