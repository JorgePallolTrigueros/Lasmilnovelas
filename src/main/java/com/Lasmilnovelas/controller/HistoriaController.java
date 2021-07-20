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
import com.Lasmilnovelas.entity.Galeria;
import com.Lasmilnovelas.entity.Historia;
import com.Lasmilnovelas.entity.Incidente;
import com.Lasmilnovelas.entity.Personaje;
import com.Lasmilnovelas.Repository.HistoriaRepository;
import com.Lasmilnovelas.Repository.IncidenteRepository;
import com.Lasmilnovelas.Repository.EtiquetaRepository;
import com.Lasmilnovelas.Repository.GaleriaRepository;
import com.Lasmilnovelas.Repository.PersonajeRepository;
import com.Lasmilnovelas.Repository.GeneroRepository;
import com.Lasmilnovelas.service.HistoriaSreviceAPI;

@Controller
public class HistoriaController {

	@Autowired
	private HistoriaRepository historiaRepository;
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	@Autowired
	private PersonajeRepository personajesRepository;
	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private HistoriaSreviceAPI historiaServiceAPI;
	@Autowired
	private IncidenteRepository incidenteRepository;
	@Autowired
	private GaleriaRepository galeriaRepository;


	@GetMapping({"/historias", "/"})
	public String findHistorias(Model model, HttpSession session) {
		model.addAttribute("historias", historiaRepository.findAll());
		return "historia-list";
	}
	

	@GetMapping({"/insertpersonajeenhistoria/{id}/"})
	public String insertpersonajeenhistoria(@PathVariable Long id, Model model) {
		Optional<Personaje> personajeOpt = personajesRepository.findById(id);
		if (!personajeOpt.isPresent()) {
			model.addAttribute("error", "ID Personaje not found.");
			model.addAttribute("personajes", personajesRepository.findAll());
			return "historia-list";
		}
		model.addAttribute("personaje", personajeOpt.get());
		return "insertpersonajeenhistoria";
	}
	

	@GetMapping({"/insertgaleriaenhistoria/{id}/"})
	public String insertgaleriaenhistoria(@PathVariable Long id, Model model) {
		Optional<Galeria> galeriaOpt = galeriaRepository.findById(id);
		if (!galeriaOpt.isPresent()) {
			model.addAttribute("error", "ID Galeria not found.");
			model.addAttribute("personajes", galeriaRepository.findAll());
			return "historia-list";
		}
		model.addAttribute("galeria", galeriaOpt.get());
		return "galeriaenhistoria";
	}
	
	
	@GetMapping({"/insertincidenteenhistoria/{id}/"})
	public String insertcapituloenhistoria(@PathVariable Long id, Model model) {
		Optional<Incidente> capituloOpt = incidenteRepository.findById(id);
		if (!capituloOpt.isPresent()) {
			model.addAttribute("error", "ID incidente not found.");
			model.addAttribute("capitulos", incidenteRepository.findAll());
			return "historia-list";
		}
		model.addAttribute("incidente", capituloOpt.get());
		return "incidenteenhistoria";
	}
	
	
	
	
	
	
	

	@GetMapping({"/inserthistoriaporgenero/{id}/"})
	public String insertpersonajeporgrupo(@PathVariable Long id, Model model) {
		Optional<Personaje> personajeOpt = personajesRepository.findById(id);
		if (!personajeOpt.isPresent()) {
			model.addAttribute("error", "ID Genero not found.");
			model.addAttribute("personajes", personajesRepository.findAll());
			return "greupo-list";
		}
		model.addAttribute("historia", personajeOpt.get());
		return "inserthistoriaporgenero";
	}





	@GetMapping("/historias/{id}/view")
	public String viewHistoria(@PathVariable Long id, Model model) {
		Optional<Historia> historiaOpt = historiaRepository.findById(id);
		if (!historiaOpt.isPresent()) {
			model.addAttribute("error", "ID historia not found.");
			model.addAttribute("historias", historiaRepository.findAll());
			return "historia-list";
		}
		model.addAttribute("historia", historiaOpt.get());
		return "historia-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/historias/new")
	public String newHistoria(Model model) {
		model.addAttribute("historia", new Historia());
		model.addAttribute("genero", generoRepository.findAll());
		model.addAttribute("etiquetasDBList", etiquetaRepository.findAll());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		
		return "historia-edit";
		
	}
	
	
	

	
	
	
	
	@GetMapping("/historias/{id}/insertcapitulo")
	public String insertCapitulo(@PathVariable Long id, Model model) {
		model.addAttribute("historia", historiaRepository.findById(id).get());	
		return "newcapitulo";
		
	}

	
	
	
	
	@GetMapping("/historias/{id}/edit")
	public String editHistoria(@PathVariable Long id, Model model) {
		model.addAttribute("historia", historiaRepository.findById(id).get());
		model.addAttribute("genero", generoRepository.findAll());
		model.addAttribute("etiquetasDBList", etiquetaRepository.findAll());
		model.addAttribute("incidenteDBList", incidenteRepository.findAll());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		return "historia-edit";
		
	}
	




	@PostMapping("/historias")
	public String saveHistoria(@ModelAttribute("historia") Historia historia) {
		System.out.println(historia);
		historiaRepository.save(historia);
		// Si queremos operar con el FilmProducer asociado a esta historia lo podemos obtener con getter:
		// historia.getFilmProducer().getYear()
		return "redirect:/historias";
	}
	
	



	@GetMapping("/historias/{id}/delete")
	public String deleteHistoria(@PathVariable Long id){

		historiaRepository.deleteById(id);
		return "redirect:/historias";

	}
	
	
	
	
	@GetMapping("/historias/delete")
	public String deleteHistorias() {
		historiaRepository.deleteAll();
		return "redirect:/historias";
	}
	




	@GetMapping("/historias/{code}/search")
	public String searchHistoriaByCode(@PathVariable Integer code, Model model) {
		
		return "historiapaginada";
		
	}
	
	

	
	@GetMapping(value = "/historiapaginada")
	public String finnAll (@RequestParam Map <String, Object> params, Model model){
		int page = params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 2);
		Page<Historia> pageHistorias = historiaServiceAPI.gettAll(pageRequest);
		
		int totalPage =  pageHistorias.getTotalPages();
		if (totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());		
			model.addAttribute("pages", pages);		
		}
		model.addAttribute("list", pageHistorias.getContent());

		return "historiapaginada";
	}
	
	
}