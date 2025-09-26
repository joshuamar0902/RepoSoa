package com.example.Tarea.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Tarea.Models.RepartidorModel;
import com.example.Tarea.Services.RepartidorService;

@Controller
@RequestMapping("/web/repartidores") // Ruta base para todas las acciones de repartidores
public class RepartidorController {

    @Autowired
    private RepartidorService repartidorService;

    /**
     * Muestra la página principal de repartidores con la lista y el formulario para agregar uno nuevo.
     */
    @GetMapping
    public String vistaRepartidores(Model model) {
        // Agregamos la lista de todos los repartidores para la tabla
        model.addAttribute("repartidores", repartidorService.getAllRepartidores());
        // Agregamos un objeto RepartidorModel vacío para el formulario de creación
        model.addAttribute("repartidor", new RepartidorModel());
        return "repartidores"; // Devuelve el archivo templates/repartidores.html
    }

    /**
     * Procesa el envío del formulario para guardar un nuevo repartidor.
     */
    @PostMapping("/guardar")
    public String guardarRepartidor(@ModelAttribute("repartidor") RepartidorModel repartidor) {
        repartidorService.saveRepartidor(repartidor);
        return "redirect:/web/repartidores"; // Redirige a la página principal después de guardar
    }

    /**
     * Muestra el formulario de edición con los datos de un repartidor específico.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
    RepartidorModel repartidor = repartidorService.getRepartidorById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de repartidor inválido: " + id));
    model.addAttribute("repartidor", repartidor);

    // ¡¡¡ESTA ES LA SOLUCIÓN!!!
    return "repartidor-form"; // Correcto: Esto muestra el archivo repartidor-form.html.
}

    /**
     * Procesa el envío del formulario de edición para actualizar un repartidor.
     */
    @PostMapping("/actualizar/{id}")
    public String actualizarRepartidor(@PathVariable Integer id, @ModelAttribute("repartidor") RepartidorModel repartidor) {
        repartidor.setId(id); // Aseguramos que el ID sea el correcto
        repartidorService.saveRepartidor(repartidor);
        return "redirect:/web/repartidores"; // Redirige a la página principal
    }

    /**
     * Elimina un repartidor por su ID.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarRepartidor(@PathVariable Integer id) {
        repartidorService.deleteRepartidor(id);
        return "redirect:/web/repartidores"; // Redirige a la página principal
    }
}