package com.Lasmilnovelas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="incidente")
public class Incidente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	


	
	@Column(length =50, name="nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_historia")
	private Historia historia;
	
	@Column(length =50, name="orden")
	private Integer orden;
	


	@Column(length =450, name="descripcion")
	private String descripcion;
	
	@Column(length =550, name="descripcion_g")
	private String descripcion_g;
	
	@Column(length =450, name="url")
	private String url;
	
	@Column(length =450, name="incidencia")
	private String incidencia;
	
	

	
	
	
	public Integer getOrden() {
		return orden;
	}


	public void setOrden(Integer orden) {
		this.orden = orden;
	}


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




	public String getIncidencia() {
		return incidencia;
	}


	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}


	public Historia getHistoria() {
		return historia;
	}


	public void setHistoria(Historia historia) {
		this.historia = historia;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDescripcion_g() {
		return descripcion_g;
	}


	public void setDescripcion_g(String descripcion_g) {
		this.descripcion_g = descripcion_g;
	}




	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Incidente(String nombre, Historia historia,
			 Integer orden, String incidencia,
			String descripcion, String descripcion_g, String url)
	{
		super();
		this.incidencia = incidencia;
		this.nombre = nombre;
		this.historia = historia;
		this.descripcion = descripcion;
		this.descripcion_g = descripcion_g;
		this.orden  = orden;
		this.url = url;
	}
	
	public Incidente() {
	}
}
