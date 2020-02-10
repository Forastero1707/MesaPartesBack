package com.jhs.mesapartes.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhs.mesapartes.app.models.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, String>{

}
