package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
    // ATRIBUTOS
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private int edad;

    // MÉTODOS CONSTRUCTORES
    public Persona() {
        this.nombreCompleto = "";
        this.fechaNacimiento = LocalDate.now();
        this.edad = 0;
    }

    /*
     * public Persona(String nombreCompleto, String fechaNacimiento, int edad){
     *      this.nombreCompleto = nombreCompleto;
     *      this.edad = edad;
     *      DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     *      LocalDate fechaFormateada = LocalDate.parse(fechaNacimiento, formato);
     *      this.fechaNacimiento = fechaFormateada;
     * }
     */

    public Persona(String nombreCompleto, String fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaFormateada = LocalDate.parse(fechaNacimiento, formato);

        this.fechaNacimiento = fechaFormateada;
        this.edad = calcularEdad();
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
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaFormateada = LocalDate.parse(fechaNacimiento, formato);
        this.fechaNacimiento = fechaFormateada;
        this.edad = calcularEdad();
    }

    public int getEdad() {
        return edad;
    }

    /*
     * public void setEdad(int edad) {
     *      this.edad = edad;
     * }
     */

    // MÉTODO DE INSTANCIA
    private int calcularEdad() {
        Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
        int edadCalculada = diferencia.getYears();
        return edadCalculada;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + ", Fecha Nacimiento: " + fechaNacimiento + ", Edad: " + edad;
    }
}
