package com.Lasmilnovelas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="etiqueta")
public class Etiqueta  implements  Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long Id;
	
	
	@Column(length =50, name="nombre")
	private String nombre;


	public Long getId() {
		return Id;
	}


	public void setIdetiqueta(Long id) {
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


	public Etiqueta(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	
	public Etiqueta() {

	}
	
}
