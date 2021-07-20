package com.Lasmilnovelas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="galeria_Incidente")
public class Galeria_Incidente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Long Id;
	
	
	@Column(length =550, name="url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_incidente")
	private Incidente incidente;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Incidente getHistoria() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}

	public Galeria_Incidente(String url, Incidente incidente) {
		super();
		this.url = url;
		this.incidente = incidente;
	}

	public Galeria_Incidente() {
		super();
	}
	
	
	
	
}
