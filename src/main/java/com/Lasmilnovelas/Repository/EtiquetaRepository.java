package com.Lasmilnovelas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lasmilnovelas.entity.Etiqueta;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long>{


	

}
