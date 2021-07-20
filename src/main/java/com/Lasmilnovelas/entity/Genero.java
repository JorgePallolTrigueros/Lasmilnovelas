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
@Table(name="genero")
public class Genero implements Serializable{

	
	private static final long serialVersionUID = 1L;


	@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
	private List<Historia> historias = new ArrayList<Historia>();
    
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long Idgenero;
	
	
	@Column(length =50, name="nombre")
	private String nombre;
	


	public List<Historia> getHistorias() {
		return historias;
	}

	public void setHistorias(List<Historia> historias) {
		this.historias = historias;
	}

	public Long getIdgenero() {
		return Idgenero;
	}

	public void setIdgenero(Long idgenero) {
		Idgenero = idgenero;
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

	public Genero(List<Historia> historias, String nombre) {
		super();
		this.historias = historias;
		this.nombre = nombre;

	}	
	
	
	public Genero() {

	}		
	
	
	
}
