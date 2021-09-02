package com.Lasmilnovelas.controller;

import com.Lasmilnovelas.Repository.EtiquetaRepository;
import com.Lasmilnovelas.Repository.GeneroRepository;
import com.Lasmilnovelas.entity.Etiqueta;
import com.Lasmilnovelas.entity.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("etiquetas")
public class EtiquetaController {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    //GET localhost:9070/etiquetas/lista-etiquetas

    @GetMapping({"/lista-etiquetas"})
    public List<Etiqueta> findListaEtiquetas(@RequestParam(value = "q", required = false) String query) {

        System.out.println("Se llamo a find lista etiquetas");

        List<Etiqueta> etiquetas = etiquetaRepository.findAll();

        if(query !=null && !query.trim().isEmpty()){
            //consulta sobre los resultados que ya se extraen de la lista de etiquetas
            etiquetas.stream().filter(etiqueta -> etiqueta.getNombre().contains(query)).collect(Collectors.toList());
        }
        return etiquetas;
    }
}
