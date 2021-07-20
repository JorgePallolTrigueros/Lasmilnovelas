package com.Lasmilnovelas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lasmilnovelas.entity.Genero;
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{


	

}
