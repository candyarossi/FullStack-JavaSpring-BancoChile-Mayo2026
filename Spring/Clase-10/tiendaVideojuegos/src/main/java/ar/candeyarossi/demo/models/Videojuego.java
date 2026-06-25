package ar.candeyarossi.demo.models;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Este campo es obligatorio.")
	@Size(min = 5, max = 40, message = "Debe contener entre 5 y 40 caracteres.")
	private String nombre;

	@Size(max = 400, message = "Debe contener menos de 400 caracteres.")
	private String descripcion;

	@URL(message = "No es una URL válida.")
	private String portada;

	@NotNull(message = "Este campo es obligatorio.")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fecha_lanzamiento;

	@Min(value = 1, message = "El valor debe ser mayor o igual a 1.")
	@Max(value = 5, message = "El valor debe ser menor o igual a 5.")
	private Double rating;

	private Double precio;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario creador;

	@OneToMany(mappedBy = "videojuego")
	private List<Resena> resenas;

	@ManyToMany
	@JoinTable(name = "compras", joinColumns = @JoinColumn(name = "id_videojuego"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	@Transient
	private List<Usuario> compradores;

	public Videojuego() {

	}

	public Videojuego(String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento,
			Double rating) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.portada = portada;
		this.fecha_lanzamiento = fecha_lanzamiento;
		this.rating = rating;
		this.precio = this.generarPrecioRandom();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public LocalDate getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setResenas(List<Resena> resenas) {
		this.resenas = resenas;
	}

	public List<Resena> getResenas() {
		return resenas;
	}

	public void setCompradores(List<Usuario> compradores) {
		this.compradores = compradores;
	}

	public List<Usuario> getCompradores() {
		return compradores;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
				+ ", fecha_lanzamiento=" + fecha_lanzamiento + ", rating=" + rating + ", precio=" + precio
				+ ", creador=" + creador.getId() + "]";
	}

	private Double generarPrecioRandom() {
		return (Math.round(ThreadLocalRandom.current().nextDouble(5.0, 150.0)) * 100.0) / 100.0;
	}

	@PrePersist
	public void setPrecioRandom() {
		this.precio = this.generarPrecioRandom();
	}

}
