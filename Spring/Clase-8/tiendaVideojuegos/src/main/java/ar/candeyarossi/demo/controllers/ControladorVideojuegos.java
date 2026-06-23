package ar.candeyarossi.demo.controllers;

import java.util.List;

import ar.candeyarossi.demo.interfaces.ManejoDeFechas;
import ar.candeyarossi.demo.models.Resena;
import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.models.Videojuego;
import ar.candeyarossi.demo.services.ServicioResenas;
import ar.candeyarossi.demo.services.ServicioVideojuegos;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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

@Controller
public class ControladorVideojuegos implements ManejoDeFechas {

	@Autowired
	private ServicioVideojuegos servicioVideojuegos;

	@Autowired
	private ServicioResenas servicioResenas;

	// @RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@GetMapping("/getAll")
	public String inicio(HttpSession sesion, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		List<Videojuego> videojuegos = this.servicioVideojuegos.obtenerTodosLosVideojuegos();
		modelo.addAttribute("videojuegos", videojuegos);
		return "videojuegos.jsp";
	}

	@GetMapping("/mostrarJSP")
	public String mostrarJSP() {

		return "pruebas.jsp";
	}

	@GetMapping("/form/add")
	public String formAgregar(HttpSession sesion, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		modelo.addAttribute("videojuego", new Videojuego());
		return "agregar.jsp";
	}

	@PostMapping("/add")
	public String guardar(@Valid @ModelAttribute("videojuego") Videojuego videojuego, BindingResult validaciones) {

		if (validaciones.hasErrors()) {
			return "agregar.jsp";
		}
		this.servicioVideojuegos.crearModificarVideojuego(videojuego);
		return "redirect:/getAll";
	}

	@GetMapping("/detail/{id}")
	public String detalle(HttpSession sesion, @PathVariable("id") Long id, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		Videojuego v = this.servicioVideojuegos.obtenerVideojuegoPorId(id);
		modelo.addAttribute("videojuego", v);
		modelo.addAttribute("resena", new Resena());
		return "detalle.jsp";
	}

	@GetMapping("/form/edit/{id}")
	public String formEditar(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		modelo.addAttribute("videojuego", this.servicioVideojuegos.obtenerVideojuegoPorId(id));
		return "editar.jsp";
	}

	@PutMapping("/edit")
	public String editar(@Valid @ModelAttribute("videojuego") Videojuego videojuego, BindingResult validaciones) {

		if (validaciones.hasErrors()) {
			return "editar.jsp";
		}
		this.servicioVideojuegos.crearModificarVideojuego(videojuego);
		return "redirect:/getAll";
	}

	@DeleteMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		this.servicioVideojuegos.eliminarVideojuego(id);
		return "redirect:/getAll";
	}

	@PostMapping("/comment")
	public String comentar(@Valid @ModelAttribute("resena") Resena resena, BindingResult validaciones) {

		if (validaciones.hasErrors()) {
			return "detalle.jsp";
		}
		this.servicioResenas.crear(resena);
		return "redirect:/getAll";
	}
}
