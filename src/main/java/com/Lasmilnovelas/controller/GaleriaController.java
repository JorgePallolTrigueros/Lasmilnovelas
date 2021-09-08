package com.Lasmilnovelas.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.Lasmilnovelas.AppUtil;
import com.Lasmilnovelas.service.ImageStoreService;
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

	@Autowired
	private ImageStoreService imageStoreService;





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
	public String saveGaleria(@RequestParam("image") MultipartFile[] files, @ModelAttribute("galeria") Galeria galeria,@ModelAttribute("idHistoria") Long idHistoria) throws IOException, NoSuchAlgorithmException {
		System.out.println("Guardando Galeria");

		List<Galeria> galeriaList = new ArrayList<>();
		//si el archivo no es nulo y no esta vacio
		if(files!=null && files.length>0){
			//para cada uno de los archivos seleccionados se obtiene el hash
			for(MultipartFile file: files){

				//es el identificador unico de cada archivo
				String hash = AppUtil.getFileChecksum(file);

				//comprobando que la imagen no exista dentro de la galeria con el respectivo id de historia
				if(!galeriaRepository.imageExistInHistoriaWithHash(idHistoria,hash)){

					String name = "historia_"+idHistoria+"_"+hash+".jpg";
					System.out.println("image: "+file.getName()+"  , original name:  "+file.getOriginalFilename()+" , content type: "+file.getContentType()+" , empty: "+file.isEmpty()+" , size: "+file.getSize());

					//creando el objeto que contendra la informacion de cada una de las imagenes
					Galeria imgGaleria = new Galeria();
					//asociando la id de historia a la galeria
					imgGaleria.setHistoriaWithId(idHistoria);
					//guardando datos de la imagen
					imgGaleria.setHash(hash);
					//guardando la ruta de la imagen
					imgGaleria.setRuta(name);

					imageStoreService.save(file,name);

					//guardando en lista
					galeriaList.add(imgGaleria);
				}else{
					System.out.println("Imagen : "+hash+" ya existe dentro de galeria con historia: "+idHistoria);
				}
			}

			//si se han agregado imagenes para guardarlas
			if(galeriaList.size()>0){
				System.out.println("Guardandado: "+galeriaList.size()+" imagenes");
				galeriaRepository.saveAll(galeriaList);
			}else{
				System.out.println("No hay imagenes nuevas que guardar");
			}


		}

		//galeriaRepository.save(galeria);
		return "redirect:/historias";
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

	