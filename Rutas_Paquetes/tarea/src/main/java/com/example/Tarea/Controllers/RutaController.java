package com.example.Tarea.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Tarea.Models.RutaModel;
import com.example.Tarea.Services.RepartidorService;
import com.example.Tarea.Services.RutaService;

@Controller
@RequestMapping("/web/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

     @Autowired
    private RepartidorService repartidorService;


    /**
     * Muestra la página principal de clientes con la lista y el formulario.
     */
    @GetMapping
    public String vistaRutas(Model model) {
        // ... cargas la lista de rutas y el objeto para el form
        model.addAttribute("rutas", rutaService.getAllRutas());
        model.addAttribute("ruta", new RutaModel());

        // --- LA CLAVE ESTÁ AQUÍ ---
        // 2. Cargas TODOS los repartidores y los agregas al modelo
        model.addAttribute("repartidores", repartidorService.getAllRepartidores());

        return "rutas"; // 3. La plantilla 'rutas.html' ahora tiene acceso a la lista
    }

    /**
     * Procesa el formulario para guardar una ruta nueva o actualizada.
     */
    @PostMapping("/guardar")
    public String guardarRuta(@ModelAttribute("ruta") RutaModel ruta) {
        rutaService.saveRuta(ruta);
        return "redirect:/web/rutas"; // Redirige a la página principal
    }

    /**
     * Muestra el formulario de edición con los datos de una ruta específica.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        // Busca la ruta o lanza una excepción si no lo encuentra
        RutaModel ruta = rutaService.getRutaById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de ruta inválido: " + id));

        // Prepara el modelo para la vista de edición
        model.addAttribute("ruta", ruta); // La ruta a editar
        return "rutas"; // Reutiliza la misma vista, pero el formulario aparecerá lleno
    }

    /**
     * Elimina una ruta por su ID.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarRuta(@PathVariable Integer id) {
        rutaService.deleteRuta(id);
        return "redirect:/web/rutas"; // Redirige a la página principal
    }
}
