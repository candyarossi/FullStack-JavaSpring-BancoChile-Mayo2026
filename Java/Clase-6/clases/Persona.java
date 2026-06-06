package clases;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    // ATRIBUTOS
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private int edad;
    private String email;
    private int id;
    public static int incrementId = 1;

    // MÉTODOS CONSTRUCTORES
    public Persona() {
        /*
         * this.nombreCompleto = "";
         * this.fechaNacimiento = LocalDate.now();
         * this.edad = 0;
         * this.email = "";
         */
        this("", LocalDate.now().toString(), "");
    }

    /*
     * public Persona(String nombreCompleto, String fechaNacimiento, int edad){
     * this.nombreCompleto = nombreCompleto;
     * this.edad = edad;
     * DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     * LocalDate fechaFormateada = LocalDate.parse(fechaNacimiento, formato);
     * this.fechaNacimiento = fechaFormateada;
     * }
     */

    public Persona(String nombreCompleto, String fechaNacimiento) {
        /*
         * this.nombreCompleto = nombreCompleto;
         * this.fechaNacimiento = ManejoDeFechas.formatoFecha(fechaNacimiento);
         * this.edad = calcularEdad();
         * this.email = "";
         */
        this(nombreCompleto, fechaNacimiento, "");
    }

    public Persona(String nombreCompleto, String fechaNacimiento, String email) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = ManejoDeFechas.formatoFecha(fechaNacimiento);
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
        this.fechaNacimiento = ManejoDeFechas.formatoFecha(fechaNacimiento);
        this.edad = calcularEdad();
    }

    public int getEdad() {
        return edad;
    }

    /*
     * public void setEdad(int edad) {
     * this.edad = edad;
     * }
     */

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

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombreCompleto + ", Fecha Nacimiento: " + fechaNacimiento + ", Edad: "
                + edad + ", Email: " + email;
    }
}
