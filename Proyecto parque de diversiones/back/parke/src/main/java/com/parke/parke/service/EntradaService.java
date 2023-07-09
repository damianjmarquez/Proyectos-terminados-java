package com.parke.parke.service;


import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parke.parke.model.Entrada;
import com.parke.parke.repository.IEntradaRepository;



@Service
public class EntradaService implements IEntradaService {
	
	@Autowired
    private IEntradaRepository entradaRepo;

	@Override
	public List<Entrada> getEntrada() {
		List<Entrada> listaEntrada = entradaRepo.findAll();
        return listaEntrada;
	}
	
	

	@Override
	public void saveEntrada(Entrada entrada) {
		entradaRepo.save(entrada);
		
	}

	@Override
	public void deleteEntrada(int id) {
		entradaRepo.deleteById(id);
		
	}

	@Override
	public Entrada findEntrada(int id) {
		Entrada entrada = entradaRepo.findById(id).orElse(null);
        return entrada;
	}

	

	

	@Override
	public void editEntrada(int idOriginal, int idNueva, String nuevoDni, String nuevojuego, Date nuevafecha, Long nuevoprecio, LocalTime nuevaHora) {

		//busco  el objeto original
    	Entrada entrada = this.findEntrada(idOriginal);
            
            //proceso de modificación a nivel lógico
    	entrada.setId(idNueva);
    	entrada.setDni(nuevoDni);
    	entrada.setJuego(nuevojuego);
    	entrada.setFecha(nuevafecha);
    	entrada.setPrecio(nuevoprecio);
    	entrada.setHora(nuevaHora);
    	
            
            
            //guardar los cambios
            this.saveEntrada(entrada);
		
	}
	
	

	@Override
	public void editEntrada(Entrada entrada) {
		// TODO Auto-generated method stub
		
	}

	
}