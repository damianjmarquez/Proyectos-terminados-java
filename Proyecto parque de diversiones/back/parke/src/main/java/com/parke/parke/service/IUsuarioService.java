package com.parke.parke.service;

import java.util.List;

import com.parke.parke.model.Usuario;


public interface IUsuarioService {

    //método para traer a todas las personas
    //lectura
    public List<Usuario> getPersonas();

    //alta
    public void savePersona(Usuario perso);

    //baja
    public void deletePersona(Long id);

    //lectura de un solo objeto
    public Usuario findPersona(Long id);

    //edición/modificación
    public void editPersona(Long idOriginal, Long idNueva,
                            String nuevoUsuario,
                            String nnuevoContraseña,
                            String nuevotipoUsuario
                            );

	void editPersona(Usuario per);
    
    
}