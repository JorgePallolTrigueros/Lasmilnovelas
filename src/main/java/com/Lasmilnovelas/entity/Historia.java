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
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length =50, name="nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;
	
	@Column(length =50, name="autor")
	private String autor;	

	@Column(length =5450, name="descripcion")
	private String descripcion;
	
	@Column(length =5550, name="descripcion_g")
	private String descripcion_g;
	
	@Column(length =50, name="Edad_Recomendada")
	private Integer edad_recomendada;	
	
	@Column(length =50, name="numero_de_Capitulos")
	private Integer numero_de_Capitulos;
	
	@Column(length =450, name="url")
	private String url;

    
    
    

	
	
	@ManyToMany
	@JoinTable(name = "historia_etiquetas",
	joinColumns = @JoinColumn(name = "id_historia", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_etiquetas", referencedColumnName = "id"))
	private List<Etiqueta> etiquetas = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "historia", cascade = CascadeType.ALL)
	private List<Personaje> personajes = new ArrayList<Personaje>();
 	

	@OneToMany(mappedBy = "historia", cascade = CascadeType.ALL)
	private List<Incidente> incidentes = new ArrayList<Incidente>();
    
	@OneToMany(mappedBy = "historia", cascade = CascadeType.ALL)
	private List<Galeria> galerias = new ArrayList<Galeria>();
    

	@Column(length =450, name="incidencia")
	private String incidencia;




	
	
	
	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

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



	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}



	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public Integer getEdad_recomendada() {
		return edad_recomendada;
	}

	public void setEdad_recomendada(Integer edad_recomendada) {
		this.edad_recomendada = edad_recomendada;
	}

	public Integer getNumero_de_Capitulos() {
		return numero_de_Capitulos;
	}

	public void setNumero_de_Capitulos(Integer numero_de_Capitulos) {
		this.numero_de_Capitulos = numero_de_Capitulos;
	}

	public void setGalerias(List<Galeria> galerias) {
		this.galerias = galerias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Historia(
			Long id, 
			String nombre, 
			Genero genero, 
			String descripcion, 
			String descripcion_g,
			String url, 
			String incidencia,
			Integer edad_recomendada,
			Integer numero_de_Capitulos, 
			String autor
			) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.incidencia = incidencia;
		this.genero = genero;
		this.descripcion = descripcion;
		this.descripcion_g = descripcion_g;
		this.url = url;
		this.numero_de_Capitulos = numero_de_Capitulos;
		this.edad_recomendada=edad_recomendada;
		this.autor = autor;
	}

	public Historia() {
	
	}
	
	
	




	
	
	
}