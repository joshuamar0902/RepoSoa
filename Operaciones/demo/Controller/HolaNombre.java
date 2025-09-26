package com.demo.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaNombre {

    @GetMapping("/bienvenido{nombre}")
    public String obtenerUsuario(@PathVariable String nombre) {
        return "Hola " + nombre+ " Bienvenido a la UCC";
    }
}

