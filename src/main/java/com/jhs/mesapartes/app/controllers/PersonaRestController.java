package com.jhs.mesapartes.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
