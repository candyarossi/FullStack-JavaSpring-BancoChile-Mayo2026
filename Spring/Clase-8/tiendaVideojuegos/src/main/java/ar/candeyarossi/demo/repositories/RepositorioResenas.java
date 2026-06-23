package ar.candeyarossi.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.candeyarossi.demo.models.Resena;

@Repository
public interface RepositorioResenas extends CrudRepository<Resena, Long> {

}
