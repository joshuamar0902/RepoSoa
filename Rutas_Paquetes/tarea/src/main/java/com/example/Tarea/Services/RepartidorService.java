package com.example.Tarea.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tarea.Models.RepartidorModel;
import com.example.Tarea.Repositories.RepartidorRepository;
@Service
public class RepartidorService {

    @Autowired
    private RepartidorRepository repartidorRepository;

    public List<RepartidorModel> getAllRepartidores() {
        return repartidorRepository.findAll();
    }

    public Optional<RepartidorModel> getRepartidorById(Integer id) {
        return repartidorRepository.findById(id);
    }

    public RepartidorModel saveRepartidor(RepartidorModel repartidor) {
        return repartidorRepository.save(repartidor);
    }

    public void deleteRepartidor(Integer id) {
        repartidorRepository.deleteById(id);
    }

    public void updateRepartidor(Integer id, RepartidorModel repartidorDetails) {
        Optional<RepartidorModel> optionalRepartidor = repartidorRepository.findById(id);
        if (optionalRepartidor.isPresent()) {
            RepartidorModel repartidorExistente = optionalRepartidor.get();
            repartidorExistente.setNombre(repartidorDetails.getNombre());
            repartidorExistente.setTelefono(repartidorDetails.getTelefono());
            repartidorExistente.setVehiculo(repartidorDetails.getVehiculo());
            repartidorExistente.setPlaca_vehiculo(repartidorDetails.getPlaca_vehiculo());
            repartidorExistente.setActivo(repartidorDetails.getActivo());
            repartidorRepository.save(repartidorExistente);
        }
    }


}