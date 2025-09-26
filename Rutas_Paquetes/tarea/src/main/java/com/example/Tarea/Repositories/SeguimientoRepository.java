package com.example.Tarea.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Tarea.Models.SeguimientoModel;

@Repository
public interface SeguimientoRepository extends JpaRepository<SeguimientoModel, Integer> {
}