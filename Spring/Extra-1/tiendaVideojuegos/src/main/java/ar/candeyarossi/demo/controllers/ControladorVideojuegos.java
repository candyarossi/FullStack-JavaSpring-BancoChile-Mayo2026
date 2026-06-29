package ar.candeyarossi.demo.controllers;

import java.util.List;

import ar.candeyarossi.demo.interfaces.ManejoDeFechas;
import ar.candeyarossi.demo.models.Resena;
import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.models.Videojuego;
import ar.candeyarossi.demo.services.ServicioResenas;
import ar.candeyarossi.demo.services.ServicioUsuarios;
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

	@Autowired
	private ServicioUsuarios servicioUsuarios;

	@GetMapping("/getAll")
	public String inicio(HttpSession sesion, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		List<Videojuego> misComprados = this.servicioUsuarios.obtenerUsuarioPorId(u.getId()).getComprados();
		modelo.addAttribute("misComprados", misComprados);
		List<Videojuego> videojuegos = this.servicioVideojuegos.obtenerTodosLosVideojuegos();
		videojuegos.removeAll(misComprados);
		modelo.addAttribute("videojuegos", videojuegos);
		return "videojuegos.jsp";
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
		Videojuego v = this.servicioVideojuegos.crearModificarVideojuego(videojuego);
		return "redirect:/detail/" + v.getId();
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
		Videojuego v = this.servicioVideojuegos.crearModificarVideojuego(videojuego);
		return "redirect:/detail/" + v.getId();
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
		return "redirect:/detail/" + resena.getVideojuego().getId();
	}

	@GetMapping("/buy/{id}")
	public String comprar(@PathVariable("id") Long idJuego, HttpSession sesion, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}

		Usuario usuarioModificado = this.servicioVideojuegos.generarComprar(u.getId(), idJuego);
		u.setCoins(Math.round(usuarioModificado.getCoins() * 100.0) / 100.0);
		sesion.setAttribute("usuario", u);

		return "redirect:/getAll";
	}
}
