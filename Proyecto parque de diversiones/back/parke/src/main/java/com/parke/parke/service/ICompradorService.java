package com.parke.parke.service;

import java.util.List;

import com.parke.parke.model.Comprador;


public interface ICompradorService {

	//método para traer a todas las personas
    //lectura
    public List<Comprador> getComprador();
 
    //alta
    public void saveComprador(Comprador comprador);

    //baja
    public void deleteComprador(int id);

    //lectura de un solo objeto
    public Comprador findComprador(int id);

    //edición/modificación
    public void editComprador(int idOriginal, int idNueva,
                            String nuevoNombre,
                            String nnuevoApellido,
                            String nuevoFechNac,
                            String nnuevoDni,
                            String nuevoTelefono,
                            String nnuevoEmail
                            );

	void editComprador(Comprador comprador);
}
