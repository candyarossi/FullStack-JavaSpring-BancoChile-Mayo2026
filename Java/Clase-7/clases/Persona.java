package clases;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona implements ManejoDeFechas {
    // ATRIBUTOS
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private int edad;
    private String email;
    private int id;
    public static int incrementId = 1;

    // MÉTODOS CONSTRUCTORES
    public Persona() {
        this("", LocalDate.now().toString(), "");
    }

    public Persona(String nombreCompleto, String fechaNacimiento) {
        this(nombreCompleto, fechaNacimiento, "");
    }

    public Persona(String nombreCompleto, String fechaNacimiento, String email) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = formatoFecha(fechaNacimiento);
        this.edad = calcularEdad();
        this.email = email;
        this.id = Persona.incrementId++;
    }

    // MÉTODOS GETTERS y SETTERS (Métodos de Instancia)
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = formatoFecha(fechaNacimiento);
        this.edad = calcularEdad();
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getIncrementId() {
        return incrementId;
    }

    // MÉTODO DE INSTANCIA
    private int calcularEdad() {
        Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
        int edadCalculada = diferencia.getYears();
        return edadCalculada;
    }

    public abstract String verCalificaciones();

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombreCompleto + ", Fecha Nacimiento: " + fechaNacimiento + ", Edad: "
                + edad + ", Email: " + email;
    }
}
