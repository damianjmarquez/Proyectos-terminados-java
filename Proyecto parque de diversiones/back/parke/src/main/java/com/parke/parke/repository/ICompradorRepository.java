package com.parke.parke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parke.parke.model.Comprador;

@Repository
public interface ICompradorRepository extends JpaRepository <Comprador, Integer>{
    
}
