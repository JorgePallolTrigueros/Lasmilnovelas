package com.Lasmilnovelas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="galeria")
public class Galeria implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	

	
	@ManyToOne
	@JoinColumn(name = "id_historia")
	private Historia historia;

	
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String imagen;
	
	


	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	
	
	
	
	
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Galeria(String url, Historia historia,String imagen) {
		super();
		this.imagen = imagen;
		this.historia = historia;
	}

	public Galeria() {
		super();
	}
	
	
	
	
}
