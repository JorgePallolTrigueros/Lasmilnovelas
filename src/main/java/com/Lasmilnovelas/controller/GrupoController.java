package com.Lasmilnovelas.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Lasmilnovelas.Repository.EtiquetaRepository;
import com.Lasmilnovelas.Repository.GeneroRepository;
import com.Lasmilnovelas.Repository.GrupoRepository;
import com.Lasmilnovelas.Repository.HistoriaRepository;
import com.Lasmilnovelas.Repository.PersonajeRepository;
import com.Lasmilnovelas.entity.Grupo;
import com.Lasmilnovelas.entity.Historia;

@Controller
public class GrupoController {

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private PersonajeRepository personajesRepository;





	@GetMapping({"/grupos"})
	public String findHistorias(Model model, HttpSession session) {
		model.addAttribute("grupos", grupoRepository.findAll());
		return "grupo-list";
	}
	




	







	@GetMapping("/grupos/{id}/view")
	public String viewHistoria(@PathVariable Long id, Model model) {
		Optional<Grupo> grupoOpt = grupoRepository.findById(id);
		if (!grupoOpt.isPresent()) {
			model.addAttribute("error", "ID grupo not found.");
			model.addAttribute("grupos", grupoRepository.findAll());
			return "grupo-list";
		}
		model.addAttribute("grupo", grupoOpt.get());
		return "grupo-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/grupos/new")
	public String newHistoria(Model model) {
		model.addAttribute("grupo", new Historia());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		
		return "grupo-edit";
		
	}
	
	
	
	
	
	@GetMapping("/grupo/new")
	public String newGrupo(Model model) {
		model.addAttribute("grupo", new Grupo());
		return "newgrupo";
		
	}
	@GetMapping("/grupos/{id}/insertgrupo")
	public String insertGrupo(@PathVariable Long id, Model model) {
		model.addAttribute("grupo", grupoRepository.findById(id).get());	
		return "newgrupo";
		
	}

	
	
	
	
	@GetMapping("/grupos/{id}/edit")
	public String editHistoria(@PathVariable Long id, Model model) {
		model.addAttribute("grupo", grupoRepository.findById(id).get());
		model.addAttribute("grupoDBList", grupoRepository.findAll());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		return "grupo-edit";
		
	}
	




	@PostMapping("/grupos")
	public String saveGrupo(@ModelAttribute("grupo") Grupo grupo) {
		System.out.println(grupo);
		grupoRepository.save(grupo);

		return "redirect:/grupos";
	}
	



	@GetMapping("/grupos/{id}/delete")
	public String deleteHistoria(@PathVariable Long id){

		grupoRepository.deleteById(id);
		return "redirect:/grupos";

	}
	
	
	
	
	@GetMapping("/grupos/delete")
	public String deleteHistorias() {
		grupoRepository.deleteAll();
		return "redirect:/grupos";
	}
	



	

	
}
