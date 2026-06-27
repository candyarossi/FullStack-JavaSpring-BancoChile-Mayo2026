package com.javaSpring.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javaSpring.examen.models.Frase;
import com.javaSpring.examen.repositories.RepositorioFrases;

@Service
public class ServicioFrases {

    @Autowired
    private RepositorioFrases repositorioFrases;

    public Frase crear(Frase frase) {
        return this.repositorioFrases.save(frase);
    }

    public List<Frase> obtenerTodas() {
        return (List<Frase>) this.repositorioFrases.findAll();
    }

    public Frase obtenerPorId(Long id) {
        return this.repositorioFrases.findById(id).orElse(null);
    }

    public Frase obtenerPorTexto(String texto) {
        return this.repositorioFrases.findByTexto(texto).orElse(null);
    }

    public Frase actualizar(Frase frase) {
        return this.repositorioFrases.save(frase);
    }

    public void eliminar(Long id) {
        this.repositorioFrases.deleteById(id);
    }

    public BindingResult validarFraseUnica(BindingResult validaciones, Frase frase) {
        Frase fraseDB = this.obtenerPorTexto(frase.getTexto());
        if (fraseDB != null) {
            validaciones.rejectValue("texto", "textoRepetido", "La frase debe ser única.");
        }
        return validaciones;
    }
}