package ar.candeyarossi.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.candeyarossi.demo.models.Usuario;
import java.util.Optional;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    // Queries personalizadas...
}
