package ar.candeyarossi.demo.controllers;

import java.util.ArrayList;

import ar.candeyarossi.demo.interfaces.ManejoDeFechas;
import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.models.Videojuego;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorVideojuegos implements ManejoDeFechas {
	private ArrayList<Videojuego> videojuegos;

	public ControladorVideojuegos() {
		this.videojuegos = new ArrayList<>();

		Videojuego v1 = new Videojuego(1l, "Silent Hill 2",
				"Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
				"https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2124490/capsule_616x353.jpg?t=1744248682",
				formatoFecha("2024-10-08"), 4.8);
		Videojuego v2 = new Videojuego(2l, "Outlast",
				"Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
				"https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/238320/header.jpg?t=1666817106",
				formatoFecha("2013-09-03"), 4.5);
		Videojuego v3 = new Videojuego(3l, "Resident Evil 2",
				"The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.",
				"https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/883710/capsule_616x353.jpg?t=1779433152",
				formatoFecha("2019-01-25"), 4.3);

		this.videojuegos.add(v1);
		this.videojuegos.add(v2);
		this.videojuegos.add(v3);
	}

	// @RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@GetMapping("/getAll")
	public String inicio(HttpSession sesion, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		modelo.addAttribute("videojuegos", this.videojuegos);
		return "videojuegos.jsp";
	}

	// PARAMETROS DE CONSULTA: /search?name=Outlast -> Query String
	@GetMapping("/search")
	public String getVideojuegoPorNombre(@RequestParam("name") String nombre) {

		String str = this.buscar(nombre, null).toString();
		return str;
	}

	// VARIABLES DE RUTA: /search/2 -> Path Variable
	@GetMapping("/search/{id}")
	public String getVideojuegoPorId(@PathVariable("id") Long id) {

		String str = this.buscar(null, id).toString();
		return str;
	}

	private Videojuego buscar(String nombre, Long id) {

		Videojuego v = null;
		for (int i = 0; i < this.videojuegos.size(); i++) {
			if (nombre != null && this.videojuegos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				v = this.videojuegos.get(i);
			} else if (id != null && this.videojuegos.get(i).getId() == id) {
				v = this.videojuegos.get(i);
			}
		}
		return v;
	}

	@GetMapping("/mostrarJSP")
	public String mostrarJSP() {

		return "pruebas.jsp";
	}

	@GetMapping("/form/add")
	public String formAgregar(HttpSession sesion) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		return "agregar.jsp";
	}

	@PostMapping("/add")
	public String guardar(@RequestParam String nombre,
			@RequestParam String descripcion,
			@RequestParam String portada,
			@RequestParam String fecha_lanzamiento,
			@RequestParam String rating) {

		Long nuevoId = this.videojuegos.size() + 1l;
		Videojuego v = new Videojuego(nuevoId,
				nombre,
				descripcion,
				portada,
				formatoFecha(fecha_lanzamiento),
				Double.parseDouble(rating));
		this.videojuegos.add(v);
		return "redirect:/getAll";
	}

	@GetMapping("/detail/{id}")
	public String detalle(HttpSession sesion, @PathVariable("id") Long id, Model modelo) {

		Usuario u = (Usuario) sesion.getAttribute("usuario");
		if (u == null) {
			return "redirect:/";
		}
		Videojuego v = buscar(null, id);
		modelo.addAttribute("videojuego", v);
		return "detalle.jsp";
	}
}
