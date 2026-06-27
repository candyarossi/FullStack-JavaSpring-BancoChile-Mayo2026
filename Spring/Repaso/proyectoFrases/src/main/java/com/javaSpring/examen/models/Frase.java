package com.javaSpring.examen.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "frases")
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo es requerido.")
    @Size(min = 10, message = "Debe contener al menos 10 caracteres.")
    private String texto;

    @NotBlank(message = "El campo es requerido.")
    @Size(min = 3, message = "Debe contener al menos 3 caracteres.")
    private String autor;

    @NotBlank(message = "El campo es requerido.")
    @Size(min = 5, message = "Debe contener al menos 5 caracteres.")
    private String categoria;

    @NotBlank(message = "El campo es requerido.")
    @Size(min = 5, message = "Debe contener al menos 5 caracteres.")
    private String idioma;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario creador;

    public Frase() {
    }

    public Frase(Long id, String texto, String autor, String categoria, String idioma, Usuario creador) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.categoria = categoria;
        this.idioma = idioma;
        this.creador = creador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return "Frase [id=" + id + ", texto=" + texto + ", autor=" + autor + ", categoria=" + categoria + ", idioma="
                + idioma + ", creador=" + creador + "]";
    }
}
