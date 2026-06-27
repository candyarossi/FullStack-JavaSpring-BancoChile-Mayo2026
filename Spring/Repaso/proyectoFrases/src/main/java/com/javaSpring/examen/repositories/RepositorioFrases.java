package com.javaSpring.examen.repositories;

import org.springframework.stereotype.Repository;

import com.javaSpring.examen.models.Frase;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

@Repository
public interface RepositorioFrases extends CrudRepository<Frase, Long> {
    Optional<Frase> findByTexto(String texto);
}
