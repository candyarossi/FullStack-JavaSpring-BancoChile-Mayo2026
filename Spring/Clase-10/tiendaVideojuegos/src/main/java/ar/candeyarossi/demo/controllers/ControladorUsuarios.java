package ar.candeyarossi.demo.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.models.UsuarioLogin;
import ar.candeyarossi.demo.services.ServicioUsuarios;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {

	@Autowired
	private ServicioUsuarios servicioUsuarios;

	@GetMapping("/")
	public String inicio(HttpSession sesion, Model modelo) {

		sesion.invalidate();
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarioLogin", new UsuarioLogin());
		return "login.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession sesion) {

		sesion.invalidate();
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(HttpSession sesion, @Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin,
			BindingResult validaciones, Model modelo) {

		HashMap<String, Object> resultado = this.servicioUsuarios.validarLogin(validaciones, usuarioLogin);
		BindingResult validacionesNuevas = (BindingResult) resultado.get("validaciones");
		Usuario usuarioDB = (Usuario) resultado.get("usuario");
		if (validacionesNuevas.hasErrors()) {
			modelo.addAttribute("usuario", new Usuario());
			return "login.jsp";
		}
		usuarioDB.setPassword("");
		sesion.setAttribute("usuario", usuarioDB);
		return "redirect:/getAll";
	}

	@PostMapping("/register")
	public String register(HttpSession sesion, @Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult validaciones, Model modelo) {

		validaciones = this.servicioUsuarios.validarRegistro(validaciones, usuario);
		if (validaciones.hasErrors()) {
			modelo.addAttribute("usuarioLogin", new UsuarioLogin());
			return "login.jsp";
		}
		this.servicioUsuarios.crearModificarUsuario(usuario);
		Usuario nuevoUsuario = usuario.clone();
		nuevoUsuario.setPassword("");
		sesion.setAttribute("usuario", nuevoUsuario);
		return "redirect:/getAll";
	}
}
