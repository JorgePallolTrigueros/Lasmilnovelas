package com.Lasmilnovelas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lasmilnovelas.entity.Galeria;
@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Long>{


	

}
