package ar.candeyarossi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.models.Videojuego;
import ar.candeyarossi.demo.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {

    @Autowired
    private RepositorioVideojuegos repositorioVideojuegos;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

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

    public Usuario generarComprar(Long idUser, Long idJuego) {
        Usuario comprador = this.servicioUsuarios.obtenerUsuarioPorId(idUser);
        Videojuego juego = this.obtenerVideojuegoPorId(idJuego);

        List<Videojuego> juegosComprados = comprador.getComprados();
        juegosComprados.add(juego);
        comprador.setComprados(juegosComprados);

        Double restante = comprador.getCoins() - juego.getPrecio();
        comprador.setCoins(restante);

        return this.servicioUsuarios.modificarUsuario(comprador);
    }
}
