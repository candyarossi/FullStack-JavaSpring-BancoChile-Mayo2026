package ar.candeyarossi.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Por favor proporciona tu nombre.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String nombre;

	@NotBlank(message = "Por favor proporciona tu apellido.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String apellido;

	@NotBlank(message = "El correo es requerido.")
	@Email(message = "Por favor proporciona un correo válido.")
	private String email;

	@NotBlank(message = "Por favor proporciona una contraseña.")
	@Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña necesita incluir al menos una letra mayúscula, una letra minúscula, un número y debe contener al menos 8 caracteres.")
	private String password;

	@Transient
	private String confirmarPassword;

	private Double coins;

	@OneToOne
	@JoinColumn(name = "id_videojuego")
	@Transient
	private Videojuego miVideojuego;

	@ManyToMany
	@JoinTable(name = "compras", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_videojuego"))
	private List<Videojuego> comprados;

	public Usuario() {

	}

	public Usuario(String nombre, String apellido, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getCoins() {
		return coins;
	}

	public void setCoins(Double coins) {
		this.coins = coins;
	}

	public Long getId() {
		return id;
	}

	public List<Videojuego> getComprados() {
		return comprados;
	}

	public void setComprados(List<Videojuego> comprados) {
		this.comprados = comprados;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", coins=" + coins + "]";
	}

	@Override
	public Usuario clone() {
		try {
			return (Usuario) super.clone();
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}

	@PrePersist
	public void setDefaultCoins() {
		this.coins = 500.0;
	}
}
