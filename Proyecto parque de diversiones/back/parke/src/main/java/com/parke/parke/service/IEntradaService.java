package com.parke.parke.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.parke.parke.model.Entrada;


public interface IEntradaService {

	//método para traer a todas las personas
    //lectura
    public List<Entrada> getEntrada();
    
   
 
    //alta
    public void saveEntrada(Entrada entrada);

    //baja
    public void deleteEntrada(int id);

    //lectura de un solo objeto
    public Entrada findEntrada(int id);

    //edición/modificación
    public void editEntrada(int idOriginal, int idNueva,
                            String nuevoDni,
                            String nnuevoJuego,
                            Date nuevoFecha,
                            Long nuevoPrecio,
                            LocalTime nuevaHora
                            );

	void editEntrada(Entrada Entrada);
}