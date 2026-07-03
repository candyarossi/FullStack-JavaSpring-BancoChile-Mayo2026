package ar.candeyarossi.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.candeyarossi.demo.models.Resena;
import ar.candeyarossi.demo.repositories.RepositorioResenas;

@Service
public class ServicioResenas {

    @Autowired
    private RepositorioResenas repositorioResenas;

    public Resena crear(Resena resena) {
        return this.repositorioResenas.save(resena);
    }
}
