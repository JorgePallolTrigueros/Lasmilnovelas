package com.Lasmilnovelas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Lasmilnovelas.entity.Personaje;



public interface PersonajeSreviceAPI {
	Page<Personaje> gettAll (Pageable pageable);
}




