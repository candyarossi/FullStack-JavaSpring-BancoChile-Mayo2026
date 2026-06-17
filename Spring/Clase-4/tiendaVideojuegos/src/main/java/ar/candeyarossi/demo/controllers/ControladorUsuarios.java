package ar.candeyarossi.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.candeyarossi.demo.models.Usuario;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorUsuarios {
	private ArrayList<Usuario> usuarios;

	public ControladorUsuarios() {
		super();
		this.usuarios = new ArrayList<>();
	}

	@GetMapping("/")
	public String inicio(HttpSession sesion) {

		sesion.invalidate();
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

		Usuario u = buscar(email);
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
	public String register(RedirectAttributes flash, HttpSession sesion, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam String email, @RequestParam String password) {

		if (password.length() < 4) {
			flash.addFlashAttribute("errorPassword1", "La contraseña debe contener al menos 4 caracteres.");
			return "redirect:/";
		}
		Long nuevoId = this.usuarios.size() + 1l;
		Usuario u = new Usuario(nuevoId, nombre, apellido, email, password);
		this.usuarios.add(u);
		Usuario nuevoUsuario = u.clone();
		nuevoUsuario.setPassword("");
		sesion.setAttribute("usuario", nuevoUsuario);
		return "redirect:/getAll";
	}

	private Usuario buscar(String email) {
		
		Usuario u = null;
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i).getEmail().equalsIgnoreCase(email)) {
				u = this.usuarios.get(i);
			}
		}
		return u;
	}

}
