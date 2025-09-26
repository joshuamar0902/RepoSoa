package com.example.Tarea.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tarea.Models.RutaModel;
import com.example.Tarea.Repositories.RutaRepository;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<RutaModel> getAllRutas() {
        return rutaRepository.findAll();
    }

    public Optional<RutaModel> getRutaById(Integer id) {
        return rutaRepository.findById(id);
    }

    public RutaModel saveRuta(RutaModel ruta) {
        return rutaRepository.save(ruta);
    }

    public void deleteRuta(Integer id) {
        rutaRepository.deleteById(id);
    }
}