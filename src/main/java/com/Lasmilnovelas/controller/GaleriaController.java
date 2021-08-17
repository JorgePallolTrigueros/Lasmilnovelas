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

import com.Lasmilnovelas.Repository.GaleriaRepository;
import com.Lasmilnovelas.entity.Galeria;
import com.Lasmilnovelas.entity.Historia;
import com.Lasmilnovelas.entity.Incidente;
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
	




	@PostMapping(value ="/galerias" ,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String saveGaleria(@RequestParam("image") MultipartFile file, @ModelAttribute("galeria") Galeria galeria,@ModelAttribute("idHistoria") Long idHistoria) {
		System.out.println("Guardando Galeria");
		System.out.println(galeria);
		System.out.println("Galeria");
		if(idHistoria!=null){
			System.out.println("Se lleno la idHistoria "+idHistoria);
			galeria.setHistoria(new Historia(idHistoria));
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
					galeria.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		galeriaRepository.save(galeria);
		return "redirect:/galerias";
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

	