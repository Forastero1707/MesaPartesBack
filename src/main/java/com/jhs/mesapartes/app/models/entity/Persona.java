package com.jhs.mesapartes.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="tabla_persona")
public class Persona implements Serializable{
	@Id
	private String dni;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min=1, max =100, message = "el tamaño tiene que estar entre 1 y 100")
	@Column(nullable = false)
	private String appaterno;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min=1, max =100, message = "el tamaño tiene que estar entre 1 y 100")
	@Column(nullable = false)
	private String apmaterno;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min=1, max =100, message = "el tamaño tiene que estar entre 1 y 100")
	@Column(nullable = false)
	private String nombres;
		
	@Column(nullable = true)
	@Email(message = "No es Formato de Correo Electronico")
	private String email;
		
	@Column(nullable = true)
	private String direccion;
		
	@Column(nullable = true)
	private String telefono;

	public String getDni() {
		return dni;
	}

	public String getAppaterno() {
		return appaterno;
	}

	public String getApmaterno() {
		return apmaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public String getEmail() {
		return email;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	
	private static final long serialVersionUID = 1L;

	
}
