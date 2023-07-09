package com.parke.parke.service;


import java.time.LocalTime;
import java.util.List;

import com.parke.parke.model.Juego;


public interface IJuegoService {
	 //método para traer a todas las personas
    //lectura
    public List<Juego> getJuego();

    //alta
    public void saveJuego(Juego juego);

    //baja
    public void deleteJuego(int id);

    //lectura de un solo objeto
    public Juego findJuego(int id);

    //edición/modificación
    public void editJuego(int idOriginal, int idNueva,
                            String nuevoNombre,
                            int nuevaCantidadDePersonas,
                            int nuevoPrecio,
                            String nuevoEmpleado,
                            LocalTime nuevoHoraInicio,
                            LocalTime nuevoHoraFin
                            );

	void editJuego(Juego juego);
}
