package com.example.Tarea.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Tarea.Models.PaqueteModel;
import com.example.Tarea.Services.ClienteService;
import com.example.Tarea.Services.PaqueteService;

@Controller
@RequestMapping("/web/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;
    @Autowired
    private ClienteService clienteService; 

    /**
     * Muestra la página principal de clientes con la lista y el formulario.
     */
    @GetMapping
    public String vistaPaquetes(Model model) {
        // ... cargas la lista de paquetes y el objeto para el form
        model.addAttribute("paquetes", paqueteService.getAllPaquetes());
        model.addAttribute("paquete", new PaqueteModel());

        // --- LA CLAVE ESTÁ AQUÍ ---
        // 2. Cargas TODOS los clientes y los agregas al modelo
        model.addAttribute("clientes", clienteService.getAllClientes()); 

        return "paquetes"; // 3. La plantilla 'paquetes.html' ahora tiene acceso a la lista
    }

    /**
     * Procesa el formulario para guardar un cliente nuevo o actualizado.
     */
    @PostMapping("/guardar")
    public String guardarPaquete(@ModelAttribute("paquete") PaqueteModel paquete) {
        paqueteService.savePaquete(paquete);
        return "redirect:/web/paquetes"; // Redirige a la página principal
    }

    /**
     * Muestra el formulario de edición con los datos de un cliente específico.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        // Busca el cliente o lanza una excepción si no lo encuentra
        PaqueteModel paquete = paqueteService.getPaqueteById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de paquete inválido: " + id));
        
        // Prepara el modelo para la vista de edición
        model.addAttribute("paquete", paquete); // El cliente a editar
        return "paquetes"; // Reutiliza la misma vista, pero el formulario aparecerá lleno
    }

    /**
     * Elimina un cliente por su ID.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id) {
        paqueteService.deletePaquete(id);
        return "redirect:/web/paquetes"; // Redirige a la página principal
    }
}
