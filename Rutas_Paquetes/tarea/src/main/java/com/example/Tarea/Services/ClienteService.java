package com.example.Tarea.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tarea.Models.ClienteModel;
import com.example.Tarea.Repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    public ClienteModel saveCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    public void updateCliente(Integer id, ClienteModel clienteDetails) {
        Optional<ClienteModel> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            ClienteModel clienteExistente = optionalCliente.get();
            clienteExistente.setNombre(clienteDetails.getNombre());
            clienteExistente.setDireccion(clienteDetails.getDireccion());
            clienteExistente.setTelefono(clienteDetails.getTelefono());
            clienteExistente.setCorreo(clienteDetails.getCorreo());
            clienteRepository.save(clienteExistente);
        }
    }
}