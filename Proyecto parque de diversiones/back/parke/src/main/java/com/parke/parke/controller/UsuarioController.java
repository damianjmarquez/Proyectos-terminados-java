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

import com.parke.parke.model.Usuario;

import com.parke.parke.service.IUsuarioService;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService persoServ;
    
    @CrossOrigin(origins = "*") 
    @GetMapping ("/personas/traer")
    public List<Usuario> getPersonas() {
        
        return persoServ.getPersonas();
    }
    @CrossOrigin(origins = "*") 
    @PostMapping ("/personas/crear")
    public String savePersona (@RequestBody Usuario perso) {
        persoServ.savePersona(perso);
        
        return "La persona fue creada correctamente";
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500") 
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        persoServ.deletePersona(id);
        return "La persona fue eliminada correctamente";  
    }
    @CrossOrigin(origins = "*") 
    @PutMapping ("/personas/editar/{id_original}")
    public Usuario editPersona (@PathVariable Long id_original,
            @RequestParam(required = false, name = "id") Long nuevaId,
            @RequestParam(required = false, name = "usuario") String nuevoUsuario,
            @RequestParam(required = false, name = "contraseña") String nuevoContraseña,
            @RequestParam(required = false, name = "tipo") String nuevotipoUsuario) {
            
        persoServ.editPersona(id_original, nuevaId, nuevoUsuario, nuevoContraseña,nuevotipoUsuario );
        
        Usuario perso = persoServ.findPersona(nuevaId);
        
        return perso;

    }
    @CrossOrigin(origins = "*")   
    @PutMapping ("/personas/editar")
    public Usuario editPersona(@RequestBody Usuario per) {
    	persoServ.editPersona(per);
    	
    	return persoServ.findPersona(per.getId());
    }
    
    
}
