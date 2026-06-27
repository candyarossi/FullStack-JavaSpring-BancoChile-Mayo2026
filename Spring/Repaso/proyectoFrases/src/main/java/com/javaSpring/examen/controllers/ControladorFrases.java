package com.javaSpring.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javaSpring.examen.models.Frase;
import com.javaSpring.examen.services.ServicioFrases;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorFrases {

    @Autowired
    private ServicioFrases servicioFrases;

    @GetMapping("/frases") // Muestra todas las frases
    public String mostrarFrases(Model modelo, HttpSession sesion) {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        List<Frase> frases = this.servicioFrases.obtenerTodas();
        modelo.addAttribute("frases", frases);
        return "frases.jsp";
    }

    @GetMapping("/form/add") // Form de creacion
    public String formAgregar(HttpSession sesion, Model modelo) {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("frase", new Frase());
        return "agregar.jsp";
    }

    @GetMapping("/form/edit/{id}") // Form de edicion
    public String formEditar(HttpSession sesion, Model modelo, @PathVariable("id") Long id) {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("frase", this.servicioFrases.obtenerPorId(id));
        return "editar.jsp";
    }

    @PostMapping("/add") // Procesa creacion
    public String guardar(@Valid @ModelAttribute("frase") Frase frase, BindingResult validaciones) {
        validaciones = this.servicioFrases.validarFraseUnica(validaciones, frase);
        if (validaciones.hasErrors()) {
            return "agregar.jsp";
        }
        this.servicioFrases.crear(frase);
        return "redirect:/frases";
    }

    @PutMapping("/edit") // Procesa edicion
    public String actualizar(@Valid @ModelAttribute("frase") Frase frase, BindingResult validaciones) {
        validaciones = this.servicioFrases.validarFraseUnica(validaciones, frase);
        if (validaciones.hasErrors()) {
            return "editar.jsp";
        }
        this.servicioFrases.actualizar(frase);
        return "redirect:/frases";
    }

    @GetMapping("/detail/{id}") // Ruta detalle
    public String detalle(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if (idUsuario == null) {
            return "redirect:/";
        }
        modelo.addAttribute("frase", this.servicioFrases.obtenerPorId(id));
        return "detalle.jsp";
    }

    @DeleteMapping("/delete/{id}") // Procesa borrado
    public String eliminar(@PathVariable("id") Long id) {
        this.servicioFrases.eliminar(id);
        return "redirect:/frases";
    }
}
