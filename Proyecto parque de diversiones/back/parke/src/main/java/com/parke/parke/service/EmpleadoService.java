package com.parke.parke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parke.parke.model.Empleado;
import com.parke.parke.repository.IEmpleadoRepositorio;



@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
    private IEmpleadoRepositorio empleadoRepo;

	@Override
	public List<Empleado> getEmpleado() {
		List<Empleado> listaEmpleados = empleadoRepo.findAll();
        return listaEmpleados;
	}

	@Override
	public void saveEmpleado(Empleado empleado) {
		empleadoRepo.save(empleado);
		
	}

	@Override
	public void deleteEmpleado(int id) {
		empleadoRepo.deleteById(id);
		
	}

	@Override
	public Empleado findEmpleado(int id) {
		Empleado empleado = empleadoRepo.findById(id).orElse(null);
        return empleado;
	}

	

	

	@Override
	public void editEmpleado(int idOriginal, int idNueva,String nuevoNombre,String nuevoApellido,String nuevoDni,String nuevoFechNac, 
			String nuevaDireccion,String nuevoEmail,String nuevoEstadoCivil,String nuevoTelefono) {

		//busco  el objeto original
    	Empleado empleado = this.findEmpleado(idOriginal);
            
            //proceso de modificación a nivel lógico
    	empleado.setId(idNueva);
    	empleado.setNombre(nuevoNombre);
    	empleado.setApellido(nuevoApellido);
    	empleado.setDni(nuevoDni);
    	empleado.setNacimiento(nuevoFechNac);
    	empleado.setDni(nuevaDireccion);
    	empleado.setMail(nuevoEmail);
    	empleado.setEstadoCivil(nuevoEstadoCivil);
    	empleado.setTelefono(nuevoTelefono);
    
    	
            
            
            //guardar los cambios
            this.saveEmpleado(empleado);
		
	}
	
	

	@Override
	public void editEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	
}

