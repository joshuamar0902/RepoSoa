package com.example.Tarea.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Tarea.Models.RepartidorModel;

@Repository
public interface RepartidorRepository extends JpaRepository<RepartidorModel, Integer> {
}