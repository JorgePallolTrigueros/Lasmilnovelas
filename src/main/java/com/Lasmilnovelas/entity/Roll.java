package com.Lasmilnovelas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roll")
public class Roll implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(length =50, name="nombre")
	private String nombre;
	
	@Column(length =4550, name="descripcion")
	private String descripcion;
	
	@Column(length =550, name="url")
	private String url;
	
	

	
	@ManyToOne
	@JoinColumn(name = "id_personaje")
	private Personaje personaje;
	
	
	@Column(length =50, name="incidente")
	private Integer incidente;
	
	



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}






	public Personaje getPersonaje() {
		return personaje;
	}



	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}







	public Integer getIncidente() {
		return incidente;
	}



	public void setIncidente(Integer incidente) {
		this.incidente = incidente;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Roll(Long id, String nombre, String descripcion, String url, Personaje personaje, Integer incidente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.incidente = incidente;
		this.personaje = personaje;
	}
	
	
	
	public Roll() {
		super();
	}
	
	
	
}
