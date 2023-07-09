package com.parke.parke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parke.parke.model.Comprador;
import com.parke.parke.repository.ICompradorRepository;
import com.parke.parke.service.ICompradorService;


@Service
public class CompradorService implements ICompradorService {
	
	@Autowired
    private ICompradorRepository compradorRepo;

	@Override
	public List<Comprador> getComprador() {
		List<Comprador> listaCompradores = compradorRepo.findAll();
        return listaCompradores;
	}

	@Override
	public void saveComprador(Comprador comprador) {
		compradorRepo.save(comprador);
		
	}

	@Override
	public void deleteComprador(int id) {
		compradorRepo.deleteById(id);
		
	}

	@Override
	public Comprador findComprador(int id) {
		Comprador comprador = compradorRepo.findById(id).orElse(null);
        return comprador;
	}

	

	

	@Override
	public void editComprador(int idOriginal, int idNueva, String nuevoNombre, String nnuevoApellido,
			String nuevoFechNac, String nnuevoDni, String nuevoTelefono, String nnuevoEmail) {

		//busco  el objeto original
    	Comprador comprador = this.findComprador(idOriginal);
            
            //proceso de modificación a nivel lógico
    	comprador.setId(idNueva);
    	comprador.setNombre(nuevoNombre);
    	comprador.setApellido(nnuevoApellido);
    	comprador.setNacimiento(nuevoFechNac);
    	comprador.setDni(nnuevoDni);
    	comprador.setTelefono(nuevoTelefono);
    	comprador.setEmail(nnuevoEmail);
            
            
            //guardar los cambios
            this.saveComprador(comprador);
		
	}
	
	

	@Override
	public void editComprador(Comprador comprador) {
		// TODO Auto-generated method stub
		
	}

	
}
