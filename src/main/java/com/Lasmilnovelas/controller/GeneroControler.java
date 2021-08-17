package com.Lasmilnovelas.controller;


import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.Lasmilnovelas.Repository.EtiquetaRepository;
import com.Lasmilnovelas.Repository.GeneroRepository;
import com.Lasmilnovelas.Repository.HistoriaRepository;
import com.Lasmilnovelas.Repository.PersonajeRepository;
import com.Lasmilnovelas.entity.Genero;
import com.Lasmilnovelas.entity.Historia;
import com.Lasmilnovelas.entity.Incidente;

@Controller
public class GeneroControler {

	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	@Autowired
	private PersonajeRepository personajesRepository;
	@Autowired
	private HistoriaRepository historiaRepository;




	@GetMapping({"/generos"})
	public String findGeneros(Model model, HttpSession session) {
		model.addAttribute("generos", generoRepository.findAll());
		return "genero-list";
	}
	



	@GetMapping({"/generos/{id_genero}/inserthistoriaengenero"})
	public String inserthistoriaengenero(@PathVariable Long id_genero, Model model) {
		//establecer el id de la historia al modelo
		model.addAttribute("idGenero",id_genero);

		//crear el personaje
		Historia historia = new Historia();
		//asignarle historia
		historia.setGenero(generoRepository.findById(id_genero).get());
		//se llena personaje en el modelo
		model.addAttribute("historia", historia);
		return "historiaengenero";
	}
	






	@GetMapping("/generos/{id}/view")
	public String viewGenero(@PathVariable Long id, Model model) {
		Optional<Genero> generoOpt = generoRepository.findById(id);
		if (!generoOpt.isPresent()) {
			model.addAttribute("error", "ID genero not found.");
			model.addAttribute("generos", generoRepository.findAll());
			return "genero-list";
		}
		model.addAttribute("genero", generoOpt.get());
		return "genero-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/generos/new")
	public String newGenero(Model model) {
		model.addAttribute("genero", new Genero());
		model.addAttribute("genero", generoRepository.findAll());

		
		return "genero-edit";
		
	}
	
	
	
	

	
	
	
	
	@GetMapping("/generos/{id}/edit")
	public String editGenero(@PathVariable Long id, Model model) {
		model.addAttribute("genero", generoRepository.findById(id).get());
		model.addAttribute("genero", generoRepository.findAll());
		return "genero-edit";
		
	}
	




	@PostMapping("/generos")
	public String saveGenero(@ModelAttribute("genero") Genero genero) {
		System.out.println(genero);
		generoRepository.save(genero);
		// Si queremos operar con el FilmProducer asociado a esta genero lo podemos obtener con getter:
		// genero.getFilmProducer().getYear()
		return "redirect:/generos";
	}
	



	@GetMapping("/generos/{id}/delete")
	public String deleteGenero(@PathVariable Long id){

		generoRepository.deleteById(id);
		return "redirect:/generos";

	}
	
	
	
	
	@GetMapping("/generos/delete")
	public String deleteGeneros() {
		generoRepository.deleteAll();
		return "redirect:/generos";
	}
	




	@GetMapping("/generos/{code}/search")
	public String searchGeneroByCode(@PathVariable Integer code, Model model) {
		
		return "generopaginada";
		
	}
	
	

	

}
