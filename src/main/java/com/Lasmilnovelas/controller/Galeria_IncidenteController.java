package com.Lasmilnovelas.controller;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Lasmilnovelas.entity.Galeria_Incidente;
import com.Lasmilnovelas.entity.Historia;
import com.Lasmilnovelas.Repository.HistoriaRepository;
import com.Lasmilnovelas.Repository.EtiquetaRepository;
import com.Lasmilnovelas.Repository.PersonajeRepository;
import com.Lasmilnovelas.Repository.GeneroRepository;
import com.Lasmilnovelas.service.HistoriaSreviceAPI;

import com.Lasmilnovelas.Repository.Galeria_IncidenteRepository;



@Controller
public class Galeria_IncidenteController {

	@Autowired
	private Galeria_IncidenteRepository galeria_IncidenteRepository;

	@Autowired
	private PersonajeRepository personajesRepository;




	@GetMapping({"/Galeria_Incidente"})
	public String findHistorias(Model model, HttpSession session) {
		model.addAttribute("Galeria_Incidente", galeria_IncidenteRepository.findAll());
		return "galeria_incidente-list";
	}
	




	







	@GetMapping("/Galeria_Incidente/{id}/view")
	public String viewHistoria(@PathVariable Long id, Model model) {
		Optional<Galeria_Incidente> galeria_IncidenteOpt = galeria_IncidenteRepository.findById(id);
		if (!galeria_IncidenteOpt.isPresent()) {
			model.addAttribute("error", "ID capitulo not found.");
			model.addAttribute("Galeria_Incidente", galeria_IncidenteRepository.findAll());
			return "galeria_incidente-list";
		}
		model.addAttribute("galeria_Incidente", galeria_IncidenteOpt.get());
		return "galeria_Incidente-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/Galeria_Incidente/new")
	public String newHistoria(Model model) {
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		
		return "Galeria_Incidente-edit";
		
	}
	
	
	
	
	
	@GetMapping("/galeria_Incidente/new")
	public String newCaleria_Incidente(Model model) {
		model.addAttribute("galeria_Incidente", new Galeria_Incidente());
		return "newgaleria_Incidente";
		
	}


	
	
	
	
	@GetMapping("/Galeria_Incidente/{id}/edit")
	public String editHistoria(@PathVariable Long id, Model model) {
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		return "galeria_Incidente-edit";
		
	}
	




	@PostMapping("/Galeria_Incidente")
	public String saveGaleria_Incidente(@ModelAttribute("galeria_Incidente") Galeria_Incidente galeria_Incidente) {
		System.out.println(galeria_Incidente);
		galeria_IncidenteRepository.save(galeria_Incidente);
		return "redirect:/Galeria_Incidente";
	}
	



	@GetMapping("/Galeria_Incidente/{id}/delete")
	public String deleteHistoria(@PathVariable Long id){

		galeria_IncidenteRepository.deleteById(id);
		return "redirect:/Galeria_Incidente";

	}
	
	
	
	
	@GetMapping("/Galeria_Incidente/delete")
	public String deleteHistorias() {
		galeria_IncidenteRepository.deleteAll();
		return "redirect:/Galeria_Incidente";
	}
	




	@GetMapping("/Galeria_Incidente/{code}/search")
	public String searchHistoriaByCode(@PathVariable Integer code, Model model) {
		
		return "galeria_Incidentepaginada";
		
	}
	
	
}

	