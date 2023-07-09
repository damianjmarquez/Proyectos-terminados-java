package com.parke.parke.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.parke.parke.service.IEntradaService;
import com.parke.parke.model.Entrada;


@RestController
public class EntradaController {

	 	@Autowired
	    private IEntradaService entradaServ;
	 
	 
	    @CrossOrigin(origins = "*")
	    @GetMapping ("/entrada/traer")
	    public List<Entrada> getEntrada() {
	        
	        return entradaServ.getEntrada();
	    }
	    @CrossOrigin(origins = "*") 
	    @PostMapping ("/entrada/crear")
	    public String saveEntrada (@RequestBody Entrada entrada) {
	    	entradaServ.saveEntrada(entrada);
	        
	        return "El comprador fue creada correctamente";
	    }
	    @CrossOrigin(origins = "*") 
	    @DeleteMapping ("/entrada/borrar/{id}")
	    public String deleteEntrada(@PathVariable int id) {
	    	entradaServ.deleteEntrada(id);
	        return "la entrada fue eliminado correctamente";
	    }
	    
	    
	    
	    @CrossOrigin(origins = "*") 
	    @PutMapping ("/entrada/editar/{id_original}")
	    public Entrada editEntrada (@PathVariable int id_original,
	            @RequestParam(required = false, name = "id") int nuevaId,
	            @RequestParam(required = false, name = "dni") String nuevoDni,
	            @RequestParam(required = false, name = "juego") String nuevoJuego,
	            @RequestParam(required = false, name = "fecha")  Date nuevaFecha,
	            @RequestParam(required = false, name = "precio") Long nuevoPrecio,
	            @RequestParam(required = false, name = "hora") LocalTime nuevaHora
	            ) {
	            
	    	entradaServ.editEntrada(id_original, nuevaId, nuevoDni, nuevoJuego,
	    								nuevaFecha, nuevoPrecio, nuevaHora);
	        
	        Entrada entrada = entradaServ.findEntrada(nuevaId);
	        
	        return entrada;

	    }
	    
	   
	    @CrossOrigin(origins = "*") 
	    @PutMapping ("/entrada/editar")
	    public Entrada editEntrada(@RequestBody Entrada entrada) {
	    	entradaServ.editEntrada(entrada);
	    	
	    	return entradaServ.findEntrada(entrada.getId());
	    }
}
