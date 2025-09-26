package com.example.Tarea.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Tarea.Models.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    // Listo, con esto ya tienes el CRUD para tus clientes.
}