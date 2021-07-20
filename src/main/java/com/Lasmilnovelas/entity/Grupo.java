



package com.Lasmilnovelas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="grupo")
public class Grupo implements Serializable{
	



	

    
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long Id;
	
	
	@Column(length =50, name="nombre")
	private String nombre;




	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
	private List<Personaje> personajes = new ArrayList<Personaje>();
	
	
		public List<Personaje> getPersonajes() {
		return personajes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}


	public Long getId() {
		return Id;
	}


	public void setIdgrupo(Long id) {
		Id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Grupo(List<Personaje> personajes, String nombre) {
		super();
		this.personajes = personajes;
		this.nombre = nombre;
	}
	
	public Grupo() {

	}
}