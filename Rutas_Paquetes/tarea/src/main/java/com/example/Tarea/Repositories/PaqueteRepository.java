package com.example.Tarea.Repositories;

import com.example.Tarea.Models.PaqueteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<PaqueteModel, Integer> {
    // ¡Eso es todo!
    // Al extender JpaRepository, esta interfaz ya tiene métodos como:
    // save()        -> para crear y actualizar
    // findById()    -> para buscar uno por su ID
    // findAll()     -> para obtener una lista de todos
    // deleteById()  -> para borrar
}