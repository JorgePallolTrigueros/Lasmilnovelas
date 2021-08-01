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
@Table(name="galeria")
public class Galeria implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(length =550, name="url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_historia")
	private Historia historia;

	
	
	
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Historia getHistoria() {
		return historia;
	}

	public void setHistoria(Historia historia) {
		this.historia = historia;
	}

	
	
	
	
	
	
	public Galeria(String url, Historia historia) {
		super();
		this.url = url;
		this.historia = historia;
	}

	public Galeria() {
		super();
	}
	
	
	
	
}
