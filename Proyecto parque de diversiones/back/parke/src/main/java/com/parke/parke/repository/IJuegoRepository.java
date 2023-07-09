package com.parke.parke.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parke.parke.model.Juego;





@Repository
public interface IJuegoRepository extends JpaRepository <Juego, Integer> {

}
