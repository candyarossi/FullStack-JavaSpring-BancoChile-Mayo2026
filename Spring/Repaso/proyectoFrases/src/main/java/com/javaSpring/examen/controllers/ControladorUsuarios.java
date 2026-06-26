package com.javaSpring.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaSpring.examen.models.Usuario;
import com.javaSpring.examen.models.UsuarioLogin;
import com.javaSpring.examen.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @GetMapping("/") // Form login
    public String formLogin(Model modelo) {
        modelo.addAttribute("usuarioLogin", new UsuarioLogin());
        return "login.jsp";
    }

    @GetMapping("/form/registro") // Form registro
    public String formRegistro(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "registro.jsp";
    }

    @GetMapping("/logout") // Cierre de sesion
    public String logout(HttpSession sesion) {
        sesion.invalidate();
        return "redirect:/";
    }

    @PostMapping("/registro") // Procesa form registro
    public String procesaRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones,
            HttpSession sesion) {
        validaciones = this.servicioUsuarios.validarRegistro(validaciones, usuario);
        if (validaciones.hasErrors()) {
            return "registro.jsp";
        }
        Usuario usuarioCreado = this.servicioUsuarios.crear(usuario);
        sesion.setAttribute("nombreCompletoUsuario", usuarioCreado.getNombre() + " " + usuarioCreado.getApellido());
        sesion.setAttribute("idUsuario", usuarioCreado.getId());
        return "redirect:/frases";
    }

    @PostMapping("/login") // Procesa form login
    public String procesaLogin(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin,
            BindingResult validaciones, HttpSession sesion) {
        validaciones = this.servicioUsuarios.validarLogin(validaciones, usuarioLogin);
        if (validaciones.hasErrors()) {
            return "login.jsp";
        }
        Usuario usuarioDB = this.servicioUsuarios.obtenerPorCorreo(usuarioLogin.getCorreo());
        sesion.setAttribute("nombreCompletoUsuario", usuarioDB.getNombre() + " " + usuarioDB.getApellido());
        sesion.setAttribute("idUsuario", usuarioDB.getId());
        return "redirect:/frases";
    }

}
