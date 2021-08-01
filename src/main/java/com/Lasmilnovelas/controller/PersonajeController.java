package com.Lasmilnovelas.controller;


import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
import com.Lasmilnovelas.Repository.GrupoRepository;
import com.Lasmilnovelas.service.HistoriaSreviceAPI;
import com.Lasmilnovelas.service.PersonajeSreviceAPI;

import org.springframework.web.multipart.MultipartFile;

@Controller
public class PersonajeController {
	
	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private PersonajeRepository personajesRepository;

	@Autowired
	private PersonajeSreviceAPI personajesServiceAPI;

	
	
	
	@GetMapping({"/insertpersonajeporgrupo/{id}/"})
	public String insertpersonajeporgrupo(@PathVariable Long id, Model model) {
		Optional<Personaje> personajeOpt = personajesRepository.findById(id);
		if (!personajeOpt.isPresent()) {
			model.addAttribute("error", "ID Personaje not found.");
			model.addAttribute("personajes", personajesRepository.findAll());
			return "greupo-list";
		}
		model.addAttribute("personaje", personajeOpt.get());
		return "insertpersonajeporgrupo";
	}
	
	

	
	
	
	
	
	@GetMapping({"/personajes"})
	public String findPersonajes(Model model, HttpSession session) {
		model.addAttribute("personajes", personajesRepository.findAll());
		return "persolist";
	}
	


	@GetMapping("/personajes/{id}/view")
	public String viewHistoria(@PathVariable Long id, Model model) {
		Optional<Personaje> personajeOpt = personajesRepository.findById(id);
		if (!personajeOpt.isPresent()) {
			model.addAttribute("error", "ID Personaje not found.");
			model.addAttribute("personajes", personajesRepository.findAll());
			return "personaje-list";
		}
		model.addAttribute("personaje", personajeOpt.get());
		return "personaje-view";
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/personajes/new")
	public String newPersonaje(Model model) {
		model.addAttribute("personaje", new Personaje());
		model.addAttribute("grupo", grupoRepository.findAll());
		return "personaje-edit";
		
	}
	



	@GetMapping("/personajes/{id}/edit")
	public String editPersonaje(@PathVariable Long id, Model model) {
		model.addAttribute("personaje", personajesRepository.findById(id).get());
		model.addAttribute("grupo", grupoRepository.findAll());
		return "personaje-edit";
		
	}
	


	@PostMapping(value ="/personajes" ,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String savePersonaje(@RequestParam("image") MultipartFile file, @ModelAttribute("personaje") Personaje personaje) {
		System.out.println(personaje);

		//si el archivo no es nulo y no esta vacio
		if(file!=null && !file.isEmpty()){
			System.out.println("image: "+file.getName()+"  , original name:  "+file.getOriginalFilename()+" , content type: "+file.getContentType()+" , empty: "+file.isEmpty()+" , size: "+file.getSize());
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			//si el nombre del archivo contiene dos puntos
			if(fileName.contains(".."))
			{
				System.out.println("archivo no valido");
			}else{
				try {
					personaje.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		personajesRepository.save(personaje);
		return "redirect:/personajes";
	}
	



	@GetMapping("/personajes/{id}/delete")
	public String deleteHistoria(@PathVariable Long id){

		personajesRepository.deleteById(id);
		return "redirect:/personajes";

	}
	
	
	
	
	@GetMapping("/personajes/delete")
	public String deletePersonajes() {
		personajesRepository.deleteAll();
		return "redirect:/personajes";
	}
	




	@GetMapping("/personajes/{code}/search")
	public String searchHistoriaByCode(@PathVariable Integer code, Model model) {
		
		return "personajepaginada";
		
	}
	
	

	
	@GetMapping(value = "/personajepaginada")
	public String finnAll (@RequestParam Map <String, Object> params, Model model){
		int page = params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 2);
		Page<Personaje> pagePersonajes = personajesServiceAPI.gettAll(pageRequest);
		
		int totalPage =  pagePersonajes.getTotalPages();
		if (totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());		
			model.addAttribute("pages", pages);		
		}
		model.addAttribute("list", pagePersonajes.getContent());

		return "personajepaginada";
	}
	
	
	
}
