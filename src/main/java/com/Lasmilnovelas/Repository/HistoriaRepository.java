
package com.Lasmilnovelas.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lasmilnovelas.entity.Historia;




@Repository
public interface HistoriaRepository extends JpaRepository<Historia, Long>{
	
	

}


