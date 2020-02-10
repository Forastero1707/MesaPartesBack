package com.jhs.mesapartes.app.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jhs.mesapartes.app.models.entity.Persona;

public interface IPersonaService {
	public List<Persona> findAll();
	public Page<Persona> findAll(Pageable pageable);

}
