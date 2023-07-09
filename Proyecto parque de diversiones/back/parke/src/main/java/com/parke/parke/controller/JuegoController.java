package com.parke.parke.controller;


import java.time.LocalTime;
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

import com.parke.parke.model.Juego;

import com.parke.parke.service.IJuegoService;


@RestController
public class JuegoController {
    
    @Autowired
    private IJuegoService juegoServ;
    
    @CrossOrigin(origins = "*") 
    @GetMapping ("/juegos/traer")
    public List<Juego> getJuego() {
        
        return juegoServ.getJuego();
    }
    @CrossOrigin(origins = "*") 
    @PostMapping ("/juegos/crear")
    public String saveJuego (@RequestBody Juego juego) {
    	juegoServ.saveJuego(juego);
        
        return "el juego fue creada correctamente";
    }
    @CrossOrigin(origins = "*") 
    @DeleteMapping ("/juegos/borrar/{id}")
    public String deleteJuego(@PathVariable int id) {
    	juegoServ.deleteJuego(id);
        return "los juegos fue eliminada correctamente";
    }
    @CrossOrigin(origins = "*") 
    @PutMapping ("/juegos/editar/{id_original}")
    public Juego editJuego (@PathVariable int id_original,
            @RequestParam(required = false, name = "id") int nuevaId,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "cantidadDePersonas") int nuevaCantidad,
            @RequestParam(required = false, name = "precio") int nuevoPrecio,
            @RequestParam(required = false, name = "empleado") String nuevoEmpleado,
            @RequestParam(required = false, name = "horaInicio") LocalTime nuevoHoraInicio,
            @RequestParam(required = false, name = "horaFin") LocalTime nuevoHoraFin) {
            
    	juegoServ.editJuego(id_original, nuevaId, nuevoNombre, nuevaCantidad, nuevoPrecio, nuevoEmpleado, nuevoHoraInicio, nuevoHoraFin);
        
        Juego juego = juegoServ.findJuego(nuevaId);
        
        return juego;

    }
    @CrossOrigin(origins = "*") 
    @PutMapping ("/juegos/editar")
    public Juego editJuego(@RequestBody Juego juego) {
    	juegoServ.editJuego(juego);
    	
    	return juegoServ.findJuego(juego.getId());
    }

}
