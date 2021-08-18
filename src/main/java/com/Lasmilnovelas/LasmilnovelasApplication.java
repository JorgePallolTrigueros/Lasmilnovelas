package com.Lasmilnovelas;

import com.Lasmilnovelas.service.ImageStoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class LasmilnovelasApplication implements CommandLineRunner {

	@Resource
	ImageStoreService storageService;

	public static void main(String[] args) {
		SpringApplication.run(LasmilnovelasApplication.class, args);
	}


	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}

}
