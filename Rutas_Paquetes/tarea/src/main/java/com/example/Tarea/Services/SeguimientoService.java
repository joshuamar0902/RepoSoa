package com.example.Tarea.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tarea.Models.SeguimientoModel;
import com.example.Tarea.Repositories.SeguimientoRepository;

@Service
public class SeguimientoService {

    @Autowired
    private SeguimientoRepository seguimientoRepository;

    public List<SeguimientoModel> getAllSeguimientos() {
        return seguimientoRepository.findAll();
    }

    public Optional<SeguimientoModel> getSeguimientoById(Integer id) {
        return seguimientoRepository.findById(id);
    }

    public SeguimientoModel saveSeguimiento(SeguimientoModel seguimiento) {
        return seguimientoRepository.save(seguimiento);
    }

    public void deleteSeguimiento(Integer id) {
        seguimientoRepository.deleteById(id);
    }
}