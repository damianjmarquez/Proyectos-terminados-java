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

import com.parke.parke.model.Empleado;
import com.parke.parke.service.EmpleadoService;
import com.parke.parke.service.IEmpleadoService;



@RestController
public class EmpleadoController {

	 @Autowired
	    private IEmpleadoService empleadoServ;
	 
	 
	 
	    @CrossOrigin(origins = "*") 
	    @GetMapping ("/empleados/traer")
	    public List<Empleado> getEmpleado() {
	        
	        return empleadoServ.getEmpleado();
	    }
	    @CrossOrigin(origins = "*")
	    @PostMapping ("/empleados/crear")
	    public String saveComprador (@RequestBody Empleado empleado) {
	    	empleadoServ.saveEmpleado(empleado);
	        
	        return "El empleado fue creada correctamente";
	    }
	    @CrossOrigin(origins = "*")
	    @DeleteMapping ("/empleados/borrar/{id}")
	    public String deleteEmpleado(@PathVariable int id) {
	    	empleadoServ.deleteEmpleado(id);
	        return "El empleado fue eliminado correctamente";
	    }
	    
	    
	    
	    @CrossOrigin(origins = "*")
	    @PutMapping ("/empleados/editar/{id_original}")
	    public Empleado editEmpleado (@PathVariable int id_original,
	            @RequestParam(required = false, name = "id") int nuevaId,
	            @RequestParam(required = false, name = "nombre") String nuevoNombre,
	            @RequestParam(required = false, name = "apellido") String nuevoApellido,
	            @RequestParam(required = false, name = "dni") String nuevoDni,
	            @RequestParam(required = false, name = "nacimiento") String nuevoFechNac,
	            @RequestParam(required = false, name = "direccion") String nuevaDireccion,
	            @RequestParam(required = false, name = "mail") String nuevoEmail,
	            @RequestParam(required = false, name = "estadoCivil") String nuevoEstadoCivil,
	            @RequestParam(required = false, name = "telefono") String nuevoTelefono
	            
	            ) {
	            
	    	EmpleadoService empleadoService = new EmpleadoService();
			empleadoService.editEmpleado(id_original, nuevaId, nuevoNombre, nuevoApellido, nuevoDni, nuevoFechNac, nuevaDireccion, nuevoEmail,
					nuevoEstadoCivil, nuevoTelefono);
	        
	        Empleado empleado = empleadoServ.findEmpleado(nuevaId);
	        
	        return empleado;

	    }
	    
	   
	    @CrossOrigin(origins = "*")
	    @PutMapping ("/empleados/editar")
	    public Empleado editEmpleado(@RequestBody Empleado empleado) {
	    	empleadoServ.editEmpleado(empleado);
	    	
	    	return empleadoServ.findEmpleado(empleado.getId());
	    }
}

