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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;






@Entity
@Table(name="historia")
public class Historia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	
	@Column(length =50, name="nombre")
	private String nombre;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;
	


	@Column(length =450, name="descripcion")
	private String descripcion;
	
	@Column(length =550, name="descripcion_g")
	private String descripcion_g;
	
	@Column(length =450, name="url")
	private String url;

    
    
    
	@ManyToMany
	@JoinTable(name = "historia_personaje",
	joinColumns = @JoinColumn(name = "id_historia", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_etiquetas", referencedColumnName = "id"))
	private List<Personaje> personaje  = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "historia_etiquetas",
	joinColumns = @JoinColumn(name = "id_historia", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_etiquetas", referencedColumnName = "id"))
	private List<Etiqueta> etiquetas = new ArrayList<>();
	
	

	@OneToMany(mappedBy = "historia", cascade = CascadeType.ALL)
	private List<Incidente> incidentes = new ArrayList<Incidente>();
    
	@OneToMany(mappedBy = "historia", cascade = CascadeType.ALL)
	private List<Galeria> galerias = new ArrayList<Galeria>();
    






	
	
	
	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public List<Galeria> getGalerias() {
		return galerias;
	}

	public void setGaleria(List<Galeria> galerias) {
		this.galerias = galerias;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
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

	public List<Personaje> getPersonaje() {
		return personaje;
	}

	public void setPersonaje(List<Personaje> personaje) {
		this.personaje = personaje;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Historia(Long id, String nombre, Genero genero, String descripcion, String descripcion_g, String url,
			List<Personaje> personaje, List<Etiqueta> etiquetas, String eti_1, String eti_2,
			String eti_3) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.descripcion_g = descripcion_g;
		this.url = url;
		this.personaje = personaje;
		this.etiquetas = etiquetas;
	}

	public Historia() {
		super();
	}
	
	
	




	
	
	
}