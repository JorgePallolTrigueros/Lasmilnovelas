package com.Lasmilnovelas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lasmilnovelas.entity.Personaje;
@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>{
	
	


}
