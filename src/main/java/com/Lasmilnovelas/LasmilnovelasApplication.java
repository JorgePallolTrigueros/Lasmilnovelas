package com.Lasmilnovelas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Lasmilnovelas.Repository.*;
import com.Lasmilnovelas.entity.Etiqueta;



@SpringBootApplication
public class LasmilnovelasApplication {

	@Autowired
	private PersonajeRepository personajeRepository;
	@Autowired
	private HistoriaRepository historiaRepository;
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired
	private GeneroRepository generoRepository;

Etiqueta eti1 = new Etiqueta();
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(LasmilnovelasApplication.class, args);
	}

}
