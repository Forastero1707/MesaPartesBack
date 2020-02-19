package com.jhs.mesapartes.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jhs.mesapartes.app.models.entity.Persona;
import com.jhs.mesapartes.app.models.services.IPersonaService;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PersonaRestController {
	
	@Autowired
	private IPersonaService personaService;
	
	
	@GetMapping("/personas")
	public List<Persona> index(){
		return personaService.findAll();
	}
	
	
	@GetMapping("/personas/page/{page}")
	public Page<Persona> index(@PathVariable Integer page){
		
		Pageable pageable  =PageRequest.of(page, 4);
		
		return personaService.findAll(pageable);
	}
	
	@GetMapping("/personas/{dni}")
	@ResponseStatus(HttpStatus.OK)
	public Persona show(@PathVariable  String dni) {
		return personaService.findByDni(dni);
	}
	
	@PostMapping("/personas")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona create(@RequestBody Persona persona)
	{
		return personaService.save(persona);
	}
	
	@PutMapping("/personas/{dni}")
	public Persona update(@RequestBody Persona persona, @PathVariable String dni)
	{
		Persona personaActual = personaService.findByDni(dni);
		
		personaActual.setApmaterno(persona.getApmaterno());
		personaActual.setAppaterno(persona.getAppaterno());
		personaActual.setNombres(persona.getNombres());
		personaActual.setTelefono(persona.getTelefono());
		personaActual.setDireccion(persona.getDireccion());
		personaActual.setEmail(persona.getEmail());
		
		return personaService.save(personaActual);	
		
	}
	
	@DeleteMapping("/personas/{dni}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String dni)
	{
		personaService.delete(dni);
	}
}
