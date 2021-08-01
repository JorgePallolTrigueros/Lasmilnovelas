package com.Lasmilnovelas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="galeria_personaje")
public class Galeria_personaje {

	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length =550, name="url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_personaje")
	private Personaje personaje;

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

	public Galeria_personaje(String url, Incidente incidente, Personaje personaje) {
		super();
		this.url = url;
		this.personaje = personaje;
	}

	public Galeria_personaje() {
		super();
	}
	
	
}
