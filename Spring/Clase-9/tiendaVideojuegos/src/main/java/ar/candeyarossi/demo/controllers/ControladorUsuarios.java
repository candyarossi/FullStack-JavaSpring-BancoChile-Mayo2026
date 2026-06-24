package ar.candeyarossi.demo.controllers;

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
		return "login.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession sesion) {

		sesion.invalidate();
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(RedirectAttributes flash, HttpSession sesion, @RequestParam String email,
			@RequestParam String password) {

		Usuario u = this.servicioUsuarios.obtenerUsuarioPorEmail(email);
		if (u != null) {
			if (!u.getPassword().equals(password)) {
				flash.addFlashAttribute("errorPassword2", "Contraseña incorrecta.");
				return "redirect:/";
			}
			u.setPassword("");
			sesion.setAttribute("usuario", u);
			return "redirect:/getAll";
		}
		return "redirect:/";
	}

	@PostMapping("/register")
	public String register(HttpSession sesion, @Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult validaciones) {

		validaciones = this.servicioUsuarios.validarRegistro(validaciones, usuario);
		if (validaciones.hasErrors()) {
			return "login.jsp";
		}
		this.servicioUsuarios.crearModificarUsuario(usuario);
		Usuario nuevoUsuario = usuario.clone();
		nuevoUsuario.setPassword("");
		sesion.setAttribute("usuario", nuevoUsuario);
		return "redirect:/getAll";
	}
}
