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
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length =50, name="nombre")
	private String nombre;
	

	
	
	
	
	@Column(length =450, name="personaje_url")
	private String personaje_url;
	
	@Column(length =550, name="personaje_url_daz")
	private String personaje_url_daz;
	
	@Column(length =450, name="descripcion")
	private String descripcion;

	@Column(length =450, name="incidencia")
	private String incidencia;
	


	@Column(length =50, name="edad")
	private Integer edad;	
	
	@Column(length =50, name="sexo")
	private String sexo;	
	
	@Column(length =50, name="cabello")
	private String cabello;
	
	@Column(length =50, name="nacionalidad")
	private String nacionalidad;
	
	@Column(length =50, name="profesion")
	private String profesion;
	
	@Column(length =50, name="corpulencia")
	private String corpulencia;	
	
	@OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
	private List<Galeria_personaje> Galeria_personaje = new ArrayList<Galeria_personaje>();
	
	


	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private Grupo grupo;

	@ManyToOne
	@JoinColumn(name = "id_historia")
	private Historia historia;





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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCabello() {
		return cabello;
	}

	public void setCabello(String cabello) {
		this.cabello = cabello;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getCorpulencia() {
		return corpulencia;
	}

	public void setCorpulencia(String corpulencia) {
		this.corpulencia = corpulencia;
	}

	public List<Galeria_personaje> getGaleria_personaje() {
		return Galeria_personaje;
	}

	public void setGaleria_personaje(List<Galeria_personaje> galeria_personaje) {
		Galeria_personaje = galeria_personaje;
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


	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personaje(
			String nombre, 
			String personaje_url,
			String personaje_url_daz,  
			String incidencia,  
			Historia historia,
			Grupo grupo,
			String descripcion,
			Integer edad,
			String sexo,
			String cabello,
			String nacionalidad,
			String profesion, 
			String corpulencia,

			 List<Galeria_personaje> Galeria_personaje) {
		super();
		this.nombre = nombre;
		this.historia = historia;
		this.personaje_url = personaje_url;
		this.personaje_url_daz = personaje_url_daz;
		this.descripcion = descripcion;
		this.edad= edad;
		this.sexo=sexo; 
		this.grupo =grupo;
		this.cabello=cabello;
		this.nacionalidad=nacionalidad; 
		this.profesion=profesion;
		this.corpulencia=corpulencia;
		this.Galeria_personaje = Galeria_personaje;
		this.incidencia = incidencia;
	}


	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	public Personaje() {

	}
}