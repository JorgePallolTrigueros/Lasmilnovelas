package com.Lasmilnovelas.controller;


import java.io.IOException;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.Lasmilnovelas.service.ImageStoreService;
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
import com.Lasmilnovelas.entity.Genero;
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
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
	private ImageStoreService imageStoreService;

	@GetMapping({"/historias", "/"})
	public String findHistorias(Model model, HttpSession session) {

		List<Historia> historias = historiaRepository.findAll();

		for(Historia h:historias){
			h.setImagen(imageStoreService.base64("imagenes/portada_historia_"+h.getId()+".jpg"));
		}

		model.addAttribute("historias", historias);

		return "historia-list";
	}
	

	
	
	
	


	@GetMapping({"/historias/{id_historia}/insertgaleriaenhistoria"})
	public String insertgaleriaenhistoria(@PathVariable Long id_historia, Model model) {
		//establecer el id de la historia al modelo
		model.addAttribute("idHistoria",id_historia);

		//crear el personaje
		Galeria galeria = new Galeria();
		//asignarle historia
		galeria.setHistoria(historiaRepository.findById(id_historia).get());
		//se llena galeria en el modelo
		model.addAttribute("galeria", galeria);
		return "galeriaenhistoria";
	}

	
	
	@GetMapping({"/historias/{id_historia}/insertpersonajeenhistoria"})
	public String insertpersonajeenhistoria(@PathVariable Long id_historia, Model model) {

		//establecer el id de la historia al modelo
		model.addAttribute("idHistoria",id_historia);

		//crear el personaje
		Personaje personaje = new Personaje();
		//asignarle historia
		personaje.setHistoria(historiaRepository.findById(id_historia).get());
		//se llena personaje en el modelo
		model.addAttribute("personaje", personaje);
		
		return "insertpersonajeenhistoria";
	}
	

	@GetMapping({"/historias/{id_historia}/insertcapituloenhistoria"})
	public String insertcapituloenhistoria(@PathVariable Long id_historia, Model model) {

		//establecer el id de la historia al modelo
		model.addAttribute("idHistoria",id_historia);

		//crear el personaje
		Incidente incidente = new Incidente();
		//asignarle historia
		incidente.setHistoria(historiaRepository.findById(id_historia).get());
		//se llena personaje en el modelo
		model.addAttribute("incidente", incidente);
		
		return "capituloenhistoria";
	}




	@GetMapping("/historias/{id}/view")
	public String viewHistoria(@PathVariable Long id, Model model) {
		Optional<Historia> historiaOpt = historiaRepository.findById(id);
		if (!historiaOpt.isPresent()) {
			model.addAttribute("error", "ID historia not found.");

			List<Historia> historias = historiaRepository.findAll();
			for(Historia h:historias){
				h.setImagen(imageStoreService.base64("imagenes/portada_historia_"+h.getId()+".jpg"));
				h.setUrl(imageStoreService.base64("imagenes/portada_historia_"+h.getId()+".jpg"));
			}

			model.addAttribute("historias", historias);
			return "historia-list";
		}

		Historia historia = historiaOpt.get();

		historia.setImagen(imageStoreService.base64("imagenes/portada_historia_"+historia.getId()+".jpg"));


		//recorrer la lista de galeria en historia
		for(Galeria galeria:historia.getGalerias()){
			//sacando la imagen de la ruta y cargandola en el campo imagen
			//esto se mostrara como base 64
			galeria.setImagen(imageStoreService.base64("imagenes/"+galeria.getRuta()));
		}

		model.addAttribute("historia", historia);
		return "historia-view";
	}
	
	
	
	
	
	
	
	@GetMapping("/historias/new")
	public String newHistoria(Model model) {
		model.addAttribute("historia", new Historia());
		model.addAttribute("generoDBList", generoRepository.findAll());
		model.addAttribute("etiquetaDBList", etiquetaRepository.findAll());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		
		return "historia-edit";
		
	}
	
	
	

	
	
	
	

	
	
	
	
	@GetMapping("/historias/{id}/edit")
	public String editHistoria(@PathVariable Long id, Model model) {
		model.addAttribute("historia", historiaRepository.findById(id).get());
		model.addAttribute("generoDBList", generoRepository.findAll());
		model.addAttribute("etiquetaDBList", etiquetaRepository.findAll());
		model.addAttribute("incidenteDBList", incidenteRepository.findAll());
		model.addAttribute("personajeDBList", personajesRepository.findAll());	
		return "historia-edit";
		
	}

	@PostMapping(value ="/historias" ,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String saveHistoria(@RequestParam("image") MultipartFile file, @ModelAttribute("historia") Historia historia,@ModelAttribute("idGenero") Long idGenero) {



		System.out.println("Guardando Historia");
		System.out.println(historia);
		System.out.println("Historia");
		if(idGenero!=null){
			System.out.println("Se lleno la idGenero "+idGenero);
			historia.setGenero(new Genero(idGenero));
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

				/*
				try {
					historia.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
		}

		historia = historiaRepository.saveAndFlush(historia);

		//se conoce por que ya se guardo
		historia.getId();

		imageStoreService.save(file,"portada_historia_"+historia.getId()+".jpg");

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

		return "insertpersonajeenhistoria";
	}
	
	
}