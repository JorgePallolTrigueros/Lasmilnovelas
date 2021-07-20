package com.Lasmilnovelas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="personaje")
public class Personaje implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(length =50, name="nombre")
	private String nombre;
	


	@OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
	private List<Roll> rolles = new ArrayList<Roll>();

	
	
	@Column(length =450, name="personaje_url")
	private String personaje_url;
	
	@Column(length =550, name="personaje_url_daz")
	private String personaje_url_daz;
	
	@Column(length =450, name="descripcion")
	private String descripcion;

	
	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private Grupo grupo;
	
	
	
	
	
	
	
	
	
	




	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPersonaje_url() {
		return personaje_url;
	}

	public void setPersonaje_url(String personaje_url) {
		this.personaje_url = personaje_url;
	}

	public String getPersonaje_url_daz() {
		return personaje_url_daz;
	}

	public void setPersonaje_url_daz(String personaje_url_daz) {
		this.personaje_url_daz = personaje_url_daz;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	




	public List<Roll> getRolles() {
		return rolles;
	}

	public void setRolles(List<Roll> rolles) {
		this.rolles = rolles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personaje(String nombre, String personaje_url, String personaje_url_daz, List<Roll> rolles,
			String descripcion) {
		super();
		this.nombre = nombre;
		this.personaje_url = personaje_url;
		this.personaje_url_daz = personaje_url_daz;
		this.descripcion = descripcion;
		this.rolles = rolles;	
	}


	public Personaje() {

	}
}