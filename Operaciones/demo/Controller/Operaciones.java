package com.demo.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Operaciones {

    @GetMapping("/suma/{num1}/{num2}")
    public String Suma(@PathVariable int num1,@PathVariable int num2) {
        int resultado = num1 + num2;
        return "La suma de " + num1 + " y " + num2 + " es: " + resultado;
    }
    @GetMapping("/resta/{num1}/{num2}")
    public String Resta(@PathVariable int num1,@PathVariable int num2) {
        int resultado = num1 - num2;
        return "La resta de " + num1 + " y " + num2 + " es: " + resultado;
    }
    @GetMapping("/multiplicacion/{num1}/{num2}")
    public String Multiplicacion(@PathVariable int num1,@PathVariable int num2) {
        int resultado = num1 * num2;
        return "La multiplicación de " + num1 + " y " + num2 + " es: " + resultado;
    }
    @GetMapping("/division/{num1}/{num2}")
    public String Division(@PathVariable float num1,@PathVariable float num2) {
        float resultado = num1 / num2;
        return "La división de " + num1 + " y " + num2 + " es: " + resultado;
    }
}