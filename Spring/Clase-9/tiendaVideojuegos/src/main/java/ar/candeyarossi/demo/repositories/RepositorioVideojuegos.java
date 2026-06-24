package ar.candeyarossi.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.candeyarossi.demo.models.Videojuego;

@Repository
public interface RepositorioVideojuegos extends CrudRepository<Videojuego, Long> {

}
