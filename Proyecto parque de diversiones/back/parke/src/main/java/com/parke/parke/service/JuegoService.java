package com.parke.parke.service;


import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.parke.parke.model.Juego;

import com.parke.parke.repository.IJuegoRepository;



@Service
public class JuegoService implements IJuegoService {
	
	@Autowired
    private IJuegoRepository juegoRepo;

	@Override
	public List<Juego> getJuego() {
		List<Juego> listaCompradores = juegoRepo.findAll();
        return listaCompradores;
	}

	@Override
	public void saveJuego(Juego juego) {
		juegoRepo.save(juego);
		
	}

	@Override
	public void deleteJuego(int id) {
		juegoRepo.deleteById(id);
		
	}

	@Override
	public Juego findJuego(int id) {
		Juego juego = juegoRepo.findById(id).orElse(null);
        return juego;
	}

	

	

	@Override
	public void editJuego(int idOriginal, int idNueva, String nuevoNombre, int nuevaCantidad,
			int nuevoPrecio, String nuevoEmpleado, LocalTime nuevoHoraInicio,
            LocalTime nuevoHoraFin) {

		//busco  el objeto original
    	Juego juego = this.findJuego(idOriginal);
            
            //proceso de modificación a nivel lógico
    	juego.setId(idNueva);
    	juego.setNombre(nuevoNombre);
    	juego.setCantidadDePersonas(nuevaCantidad);
    	juego.setPrecio(nuevoPrecio);
    	juego.setEmpleado(nuevoEmpleado);
    	juego.setHoraInicio(nuevoHoraInicio);
    	juego.setHoraFin(nuevoHoraFin);
            
            
            //guardar los cambios
            this.saveJuego(juego);
		
	}
	
	

	@Override
	public void editJuego (Juego juego) {
		// TODO Auto-generated method stub
		
	}
}
