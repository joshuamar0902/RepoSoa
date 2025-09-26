package com.example.Tarea.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Tarea.Services.ClienteService;
import com.example.Tarea.Services.PaqueteService;
import com.example.Tarea.Services.RepartidorService;
import com.example.Tarea.Services.RutaService;

@Controller
@RequestMapping("/web")
public class DashboardController {

    @Autowired
    private RepartidorService repartidorService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PaqueteService paqueteService;

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public String showDashboard(Model model) {
        model.addAttribute("totalRepartidores", repartidorService.getAllRepartidores().size());
        model.addAttribute("totalClientes", clienteService.getAllClientes().size());
        model.addAttribute("totalPaquetes", paqueteService.getAllPaquetes().size());
        model.addAttribute("totalRutas", rutaService.getAllRutas().size());
        // Aquí podrías agregar los otros servicios (paquetes, rutas, etc.)
        // model.addAttribute("totalPaquetes", paqueteService.count());
        // model.addAttribute("totalRutas", rutaService.count());

        return "index"; // Devuelve el archivo templates/index.html
    }
}