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
import com.Lasmilnovelas.Repository.IncidenteRepository;
import com.Lasmilnovelas.Repository.PersonajeRepository;
import com.Lasmilnovelas.entity.Incidente;

@Controller
public class IncidenteController {

	@Autowired
	private IncidenteRepository incidenteRepository;
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	@Autowired
	private PersonajeRepository personajesRepository;
	@Autowired
	private GeneroRepository generoRepository;




	@GetMapping({"/incidentes"})
	public String findIncidentes(Model model, HttpSession session) {
		model.addAttribute("incidentes", incidenteRepository.findAll());
		return "incidente-list";
	}
	




	







	@GetMapping("/incidentes/{id}/view")
	public String viewIncidente(@PathVariable Long id, Model model) {
		Optional<Incidente> incidenteOpt = incidenteRepository.findById(id);
		if (!incidenteOpt.isPresent()) {
			model.addAttribute("error", "ID incidente not found.");
			model.addAttribute("incidentes", incidenteRepository.findAll());
			return "incidente-list";
		}
		model.addAttribute("incidente", incidenteOpt.get());
		return "incidente-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/incidentes/new")
	public String newIncidente(Model model) {
		model.addAttribute("incidente", new Incidente());
		model.addAttribute("genero", generoRepository.findAll());
		model.addAttribute("etiquetasDBList", etiquetaRepository.findAll());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		
		return "incidente-edit";
		
	}
	
	
	

	
	
	


	
	
	
	
	@GetMapping("/incidentes/{id}/edit")
	public String editIncidente(@PathVariable Long id, Model model) {
		model.addAttribute("incidente", incidenteRepository.findById(id).get());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		return "incidente-edit";
		
	}
	




	@PostMapping("/incidentes")
	public String saveIncidente(@ModelAttribute("incidente") Incidente incidente) {
		System.out.println(incidente);
		incidenteRepository.save(incidente);
		return "redirect:/incidentes";
	}
	



	@GetMapping("/incidentes/{id}/delete")
	public String deleteIncidente(@PathVariable Long id){

		incidenteRepository.deleteById(id);
		return "redirect:/incidentes";

	}
	
	
	
	
	@GetMapping("/incidentes/delete")
	public String deleteIncidentes() {
		incidenteRepository.deleteAll();
		return "redirect:/incidentes";
	}
	




	@GetMapping("/incidentes/{code}/search")
	public String searchIncidenteByCode(@PathVariable Integer code, Model model) {
		
		return "incidentepaginada";
		
	}
	
	

	

	
	
}