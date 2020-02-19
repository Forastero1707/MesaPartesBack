package com.jhs.mesapartes.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhs.mesapartes.app.models.dao.IPersonaDao;
import com.jhs.mesapartes.app.models.entity.Persona;
@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao personaDao;
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return personaDao.findAll(pageable);
	}
	@Override
	@Transactional(readOnly = true)
	public Persona findByDni(String dni) {
		// TODO Auto-generated method stub
		return personaDao.findById(dni).orElse(null);
	}
	@Override
	@Transactional
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return personaDao.save(persona);
	}
	@Override
	@Transactional
	public void delete(String dni) {
		// TODO Auto-generated method stub
		personaDao.deleteById(dni);
		
	}
}