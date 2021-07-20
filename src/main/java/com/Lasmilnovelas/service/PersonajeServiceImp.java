package com.Lasmilnovelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Lasmilnovelas.Repository.PersonajeRepository;
import com.Lasmilnovelas.entity.Personaje;





@Service
public class PersonajeServiceImp implements PersonajeSreviceAPI {

	@Autowired
	private PersonajeRepository personajeRepository;
	
	
	@Override
	public Page<Personaje> gettAll(Pageable pageable) {
		return personajeRepository.findAll(pageable);
	}

}
