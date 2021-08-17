package com.Lasmilnovelas.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Lasmilnovelas.Repository.EtiquetaRepository;
import com.Lasmilnovelas.Repository.GeneroRepository;
import com.Lasmilnovelas.Repository.IncidenteRepository;
import com.Lasmilnovelas.Repository.PersonajeRepository;
import com.Lasmilnovelas.entity.Historia;
import com.Lasmilnovelas.entity.Incidente;
import com.Lasmilnovelas.entity.Personaje;

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
	




	@PostMapping(value ="/incidentes" ,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String savePersonaje(@RequestParam("image") MultipartFile file, @ModelAttribute("incidente") Incidente incidente,@ModelAttribute("idHistoria") Long idHistoria) {
		System.out.println("Guardando Incidente");
		System.out.println(incidente);
		System.out.println("Incidente");
		if(idHistoria!=null){
			System.out.println("Se lleno la idHistoria "+idHistoria);
			incidente.setHistoria(new Historia(idHistoria));
		}

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
					incidente.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

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