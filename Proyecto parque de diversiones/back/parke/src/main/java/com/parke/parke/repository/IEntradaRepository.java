package com.parke.parke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parke.parke.model.Entrada;

@Repository
public interface IEntradaRepository extends JpaRepository <Entrada, Integer>{
    
}