package com.Lasmilnovelas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Lasmilnovelas.entity.Historia;



public interface HistoriaSreviceAPI {
	Page<Historia> gettAll (Pageable pageable);
}




