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

import com.Lasmilnovelas.Repository.GaleriaRepository;
import com.Lasmilnovelas.entity.Galeria;
@Controller
public class GaleriaController {

	@Autowired
	private GaleriaRepository galeriaRepository;





	@GetMapping({"/Galeria"})
	public String findHistorias(Model model, HttpSession session) {
		model.addAttribute("Galeria", galeriaRepository.findAll());
		return "galeria-list";
	}
	




	







	@GetMapping("/Galeria/{id}/view")
	public String viewHistoria(@PathVariable Long id, Model model) {
		Optional<Galeria> galeriaOpt = galeriaRepository.findById(id);
		if (!galeriaOpt.isPresent()) {
			model.addAttribute("error", "ID capitulo not found.");
			model.addAttribute("Galeria", galeriaRepository.findAll());
			return "galeria-list";
		}
		model.addAttribute("galeria", galeriaOpt.get());
		return "galeria_Incidente-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/Galeria/new")
	public String newHistoria(Model model) {

		return "Galeria-edit";
		
	}
	
	
	
	
	
	@GetMapping("/galeria/new")
	public String newCapitulo(Model model) {
		model.addAttribute("galeria_Incidente", new Galeria());
		return "newgaleria";
		
	}


	
	
	
	
	@GetMapping("/Galeria/{id}/edit")
	public String editHistoria(@PathVariable Long id, Model model) {
	
		return "galeria-edit";
		
	}
	




	@PostMapping("/Galeria")
	public String saveGaleria(@ModelAttribute("galeria") Galeria galeria) {
		System.out.println(galeria);
		galeriaRepository.save(galeria);
		return "redirect:/Galeria";
	}
	



	@GetMapping("/Galeria/{id}/delete")
	public String deleteHistoria(@PathVariable Long id){

		galeriaRepository.deleteById(id);
		return "redirect:/Galeria";

	}
	
	
	
	
	@GetMapping("/Galeria/delete")
	public String deleteHistorias() {
		galeriaRepository.deleteAll();
		return "redirect:/Galeria";
	}
	




	@GetMapping("/Galeria/{code}/search")
	public String searchHistoriaByCode(@PathVariable Integer code, Model model) {
		
		return "galeriapaginada";
		
	}
	
	
}

	