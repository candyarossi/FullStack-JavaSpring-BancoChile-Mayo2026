package ar.candeyarossi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.candeyarossi.demo.models.Videojuego;
import ar.candeyarossi.demo.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {

    @Autowired
    private RepositorioVideojuegos repositorioVideojuegos;

    public List<Videojuego> obtenerTodosLosVideojuegos() {
        return (List<Videojuego>) this.repositorioVideojuegos.findAll();
    }

    public Videojuego obtenerVideojuegoPorId(Long id) {
        return this.repositorioVideojuegos.findById(id).orElse(null);
    }

    public Videojuego crearModificarVideojuego(Videojuego videojuego) {
        return this.repositorioVideojuegos.save(videojuego);
    }

    public void eliminarVideojuego(Long id) {
        this.repositorioVideojuegos.deleteById(id);
    }
}
