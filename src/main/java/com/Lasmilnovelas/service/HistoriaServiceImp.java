package com.Lasmilnovelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Lasmilnovelas.Repository.HistoriaRepository;
import com.Lasmilnovelas.entity.Historia;



@Service
public class HistoriaServiceImp implements HistoriaSreviceAPI {

	@Autowired
	private HistoriaRepository historiaRepository;
	
	
	@Override
	public Page<Historia> gettAll(Pageable pageable) {
		return historiaRepository.findAll(pageable);
	}

}
