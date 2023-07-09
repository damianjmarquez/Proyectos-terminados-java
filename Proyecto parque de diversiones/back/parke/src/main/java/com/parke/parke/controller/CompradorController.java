package com.parke.parke.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.parke.parke.service.ICompradorService;
import com.parke.parke.model.Comprador;


@RestController
public class CompradorController {

	 	@Autowired
	    private ICompradorService CompradorServ;
	 
	 
	    @CrossOrigin(origins = "*")
	    @GetMapping ("/compradores/traer")
	    public List<Comprador> getComprador() {
	        
	        return CompradorServ.getComprador();
	    }
	    @CrossOrigin(origins = "*") 
	    @PostMapping ("/Compradores/crear")
	    public String saveComprador (@RequestBody Comprador comprador) {
	    	CompradorServ.saveComprador(comprador);
	        
	        return "El comprador fue creada correctamente";
	    }
	    @CrossOrigin(origins = "*") 
	    @DeleteMapping ("/compradores/borrar/{id}")
	    public String deletePersona(@PathVariable int id) {
	    	CompradorServ.deleteComprador(id);
	        return "El comprador fue eliminado correctamente";
	    }
	    
	    
	    
	    @CrossOrigin(origins = "*") 
	    @PutMapping ("/compradores/editar/{id_original}")
	    public Comprador editComprador (@PathVariable int id_original,
	            @RequestParam(required = false, name = "id") int nuevaId,
	            @RequestParam(required = false, name = "nombre") String nuevoNombre,
	            @RequestParam(required = false, name = "apellido") String nuevoApellido,
	            @RequestParam(required = false, name = "nacimiento") String nuevaFecha,
	            @RequestParam(required = false, name = "dni") String nuevoDni,
	            @RequestParam(required = false, name = "telefono") String nuevoTelefono,
	            @RequestParam(required = false, name = "email") String nuevoEmail
	            ) {
	            
	    	CompradorServ.editComprador(id_original, nuevaId, nuevoNombre, nuevoApellido,
	    								nuevaFecha, nuevoDni, nuevoTelefono, nuevoEmail);
	        
	        Comprador comprador = CompradorServ.findComprador(nuevaId);
	        
	        return comprador;

	    }
	    
	   
	    @CrossOrigin(origins = "*") 
	    @PutMapping ("/Compradores/editar")
	    public Comprador editComprador(@RequestBody Comprador comprador) {
	    	CompradorServ.editComprador(comprador);
	    	
	    	return CompradorServ.findComprador(comprador.getId());
	    }
}
