package com.parke.parke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.parke.parke.model.Usuario;

import com.parke.parke.repository.IUsuarioRepository;



@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private IUsuarioRepository persoRepo;

    @Override
    public List<Usuario> getPersonas() {
        
        List<Usuario> listaPersonas = persoRepo.findAll();
        return listaPersonas;     
    }

    @Override
    public void savePersona(Usuario perso) {
        persoRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Usuario findPersona(Long id) {
    	Usuario perso = persoRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoUsuario, String nuevocontraseña, String nuevotipoUsuario) {
            //busco  el objeto original
    	Usuario perso = this.findPersona(idOriginal);
            
            //proceso de modificación a nivel lógico
            perso.setId(idNueva);
            perso.setUsuario(nuevoUsuario);
            perso.setContraseña(nuevocontraseña);
            perso.setTipo(nuevotipoUsuario);
            
            
            //guardar los cambios
            this.savePersona(perso);
    }
    //fin

	@Override
	public void editPersona(Usuario per) {
		// TODO Auto-generated method stub
		
	}
  
    
}
