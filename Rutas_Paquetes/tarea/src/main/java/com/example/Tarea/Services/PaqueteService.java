package com.example.Tarea.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tarea.Models.PaqueteModel;
import com.example.Tarea.Repositories.PaqueteRepository;

@Service
public class PaqueteService {

    @Autowired // Inyecta el repositorio para poder usar sus métodos
    private PaqueteRepository paqueteRepository;

    // Método para obtener todos los paquetes
    public List<PaqueteModel> getAllPaquetes() {
        return paqueteRepository.findAll();
    }

    // Método para obtener un paquete por su ID
    public Optional<PaqueteModel> getPaqueteById(Integer id) {
        return paqueteRepository.findById(id);
    }

    // Método para guardar o actualizar un paquete
    public PaqueteModel savePaquete(PaqueteModel paquete) {
        return paqueteRepository.save(paquete);
    }

    // Método para eliminar un paquete
    public void deletePaquete(Integer id) {
        paqueteRepository.deleteById(id);
    }
}