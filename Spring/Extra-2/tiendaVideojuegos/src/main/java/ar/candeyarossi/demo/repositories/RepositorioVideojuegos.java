package ar.candeyarossi.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.candeyarossi.demo.models.Videojuego;

@Repository
public interface RepositorioVideojuegos
        extends CrudRepository<Videojuego, Long>, PagingAndSortingRepository<Videojuego, Long> {

    // EJEMPLOS SELECT
    @Query(value = "SELECT v FROM Videojuego v WHERE v.creador.id = ?1")
    Optional<Videojuego> obtenerVideojuegoPorCreador(Long idCreador);

    @Query(value = "SELECT * FROM videojuegos WHERE id_usuario = ?1", nativeQuery = true)
    Optional<Videojuego> obtenerVideojuegoPorCreadorV2(Long idCreador);

    // EJEMPLO UPDATE
    @Transactional
    @Modifying
    @Query(value = "UPDATE videojuegos SET nombre = ?2, descripcion = ?3, portada = ?4, fecha_lanzamiento = ?5, rating = ?6, precio = ?7, id_usuario = ?8 WHERE id = ?1", nativeQuery = true)
    void actualizarVideojuego(Long id, String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento,
            double rating, double precio, Long id_usuario);

    // EJEMPLO DELETE
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM videojuegos WHERE id = ?1", nativeQuery = true)
    void eliminarVideojuego(Long id);

    // EJEMPLO INSERT
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO videojuegos (nombre, descripcion, portada, fecha_lanzamiento, rating, precio, id_usuario) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void guardarVideojuego(String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento,
            double rating, double precio, Long id_usuario);

    // EJEMPLO JOIN
    @Query(value = "SELECT * FROM videojuegos v JOIN usuarios u ON v.id_usuario = u.id WHERE u.id = ?1", nativeQuery = true)
    List<Object[]> obtenerVideojuegoConUsuario(Long idUsuario);
}
