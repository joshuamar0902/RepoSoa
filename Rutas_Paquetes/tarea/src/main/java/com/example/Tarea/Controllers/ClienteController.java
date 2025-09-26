package com.example.Tarea.Controllers;

import com.example.Tarea.Models.ClienteModel;
import com.example.Tarea.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Muestra la página principal de clientes con la lista y el formulario.
     */
    @GetMapping
    public String vistaClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        model.addAttribute("cliente", new ClienteModel()); // Para el formulario de creación
        return "clientes"; // Devuelve templates/clientes.html
    }

    /**
     * Procesa el formulario para guardar un cliente nuevo o actualizado.
     */
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("cliente") ClienteModel cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/web/clientes"; // Redirige a la página principal
    }

    /**
     * Muestra el formulario de edición con los datos de un cliente específico.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        // Busca el cliente o lanza una excepción si no lo encuentra
        ClienteModel cliente = clienteService.getClienteById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de cliente inválido: " + id));
        
        // Prepara el modelo para la vista de edición
        model.addAttribute("cliente", cliente); // El cliente a editar
        return "clientes"; // Reutiliza la misma vista, pero el formulario aparecerá lleno
    }

    /**
     * Elimina un cliente por su ID.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        clienteService.deleteCliente(id);
        return "redirect:/web/clientes"; // Redirige a la página principal
    }
}
