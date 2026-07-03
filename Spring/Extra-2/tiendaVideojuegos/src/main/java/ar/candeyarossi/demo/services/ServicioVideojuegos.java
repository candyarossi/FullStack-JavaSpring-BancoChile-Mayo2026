package ar.candeyarossi.demo.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import ar.candeyarossi.demo.models.Usuario;
import ar.candeyarossi.demo.models.Videojuego;
import ar.candeyarossi.demo.models.VideojuegoUsuario;
import ar.candeyarossi.demo.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {

    @Autowired
    private RepositorioVideojuegos repositorioVideojuegos;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    public Page<Videojuego> obtenerTodosLosVideojuegos(int pagina, String orden) {

        PageRequest config = PageRequest.of(pagina, 6);
        if (orden != null) {
            Sort tipoOrden = null;
            if (orden.equals("ASC")) {
                tipoOrden = Sort.by(Sort.Direction.ASC, "nombre");
            } else if (orden.equals("DESC")) {
                tipoOrden = Sort.by(Sort.Direction.DESC, "nombre");
            }
            config = PageRequest.of(pagina, 6, tipoOrden);
        }
        return this.repositorioVideojuegos.findAll(config);
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

    public void pruebasJPQL() {

        Videojuego v1 = this.repositorioVideojuegos.obtenerVideojuegoPorCreador(3l).orElse(null);
        System.out.println(v1);

        Videojuego v2 = this.repositorioVideojuegos.obtenerVideojuegoPorCreadorV2(3l).orElse(null);
        System.out.println(v2);

        this.repositorioVideojuegos.actualizarVideojuego(16l, "Juego Editado",
                "Descripcion",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdFJW9eKU2Zj7_iqAha2uTewg_p0ogvcV7LUxY5-ot5pqh7iq_MnuB_kgz&s=10",
                LocalDate.parse("2026-07-01"), 4.0, 75.0, 1l);

        this.repositorioVideojuegos.guardarVideojuego("Juego 3", "Desc 2",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2faH8A1KB7olkJWQbb9AO8zC7_0avBPr_4w&s",
                LocalDate.parse("2026-06-22"), 3.5, 100.0, 4l);

        this.repositorioVideojuegos.eliminarVideojuego(37l);

        List<Object[]> obj = this.repositorioVideojuegos.obtenerVideojuegoConUsuario(3l);
        System.out.println(obj.toString());

        for (int i = 0; i < obj.size(); i++) {
            for (int j = 0; j < obj.get(i).length; j++) {
                System.out.println("i = " + j + ", " + obj.get(i)[j]);
            }
        }

        for (Object[] fila : obj) {
            VideojuegoUsuario videojuegoUsuario = new VideojuegoUsuario(fila);
            System.out.println(videojuegoUsuario);
        }
    }

    public Videojuego obtenerVideojuegoPorUsuario(Long idUsuario) {
        return this.repositorioVideojuegos.obtenerVideojuegoPorCreadorV2(idUsuario).orElse(null);
    }

    public HashMap<String, Object> validarSubidaImagen(BindingResult validaciones, MultipartFile imagen) {

        HashMap<String, Object> resultado = new HashMap<>();
        if (!imagen.isEmpty()) {
            try {
                String rutaImagen = ServicioImagenes.uploadFile(imagen);
                resultado.put("rutaImagen", rutaImagen);
                resultado.put("validaciones", validaciones);
            } catch (Exception e) {
                validaciones.rejectValue("imagen", "errorImagen", "Hubo un error al cargar la imagen.");
                resultado.put("validaciones", validaciones);
            }
        }
        return resultado;
    }

    public boolean borrarImagen(String imagen) {
        return ServicioImagenes.deleteFile(imagen);
    }
}
