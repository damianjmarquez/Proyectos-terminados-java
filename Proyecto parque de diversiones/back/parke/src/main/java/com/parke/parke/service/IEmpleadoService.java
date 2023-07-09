package com.parke.parke.service;

import java.util.List;


import com.parke.parke.model.Empleado;


public interface IEmpleadoService {

	//método para traer a todas las personas
    //lectura
    public List<Empleado> getEmpleado();
 
    //alta
    public void saveEmpleado(Empleado empleado);

    //baja
    public void deleteEmpleado(int id);

    //lectura de un solo objeto
    public Empleado findEmpleado(int id);

    //edición/modificación
    public void editEmpleado(int idOriginal, int idNueva,
                            String nuevoNombre,
                            String nnuevoApellido,
                            String nnuevoDni,
                            String nuevoFechNac,
                            String nuevaDireccion,
                            String nnuevoEmail,
                            String nuevoEstadoCivil,
                            String nuevoTelefono
                            
                            
                            );

	void editEmpleado(Empleado comprador);
}
