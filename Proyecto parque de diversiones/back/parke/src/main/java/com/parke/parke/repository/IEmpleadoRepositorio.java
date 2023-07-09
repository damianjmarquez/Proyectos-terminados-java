package com.parke.parke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.parke.parke.model.Empleado;

@Repository
public interface IEmpleadoRepositorio extends JpaRepository <Empleado, Integer>{
    
}
