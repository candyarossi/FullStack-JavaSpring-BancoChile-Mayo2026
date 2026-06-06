package clases;

import java.util.ArrayList;
import java.util.Random;

public class Estudiante extends Persona {
    private int nroLegajo;
    private String bootcamp;
    private String cohorte;
    public static ArrayList<Integer> legajos = new ArrayList<>();

    public Estudiante() {
        super();
        this.nroLegajo = 0;
        this.bootcamp = "";
        this.cohorte = "";
    }

    public Estudiante(String nombreCompleto, String fechaNacimiento, String email, String bootcamp, String cohorte) {
        super(nombreCompleto, fechaNacimiento, email);
        this.nroLegajo = generarNroLegajo();
        this.bootcamp = bootcamp;
        this.cohorte = cohorte;
        Estudiante.legajos.add(this.nroLegajo);
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public String getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(String bootcamp) {
        this.bootcamp = bootcamp;
    }

    public String getCohorte() {
        return cohorte;
    }

    public void setCohorte(String cohorte) {
        this.cohorte = cohorte;
    }

    public static ArrayList<Integer> getLegajos() {
        return legajos;
    }

    private int generarNroLegajo() {
        Random random = new Random();
        int numeroGenerado = 1000 + random.nextInt(9000); // [1000 - 9999]
        if (Estudiante.legajos.contains(numeroGenerado)) {
            // Recursividad
            this.generarNroLegajo();
        }
        return numeroGenerado;
    }

    @Override
    public String toString() {
        return "Estudiante: " + super.toString() + " [nroLegajo=" + nroLegajo + ", bootcamp=" + bootcamp + ", cohorte="
                + cohorte + "]";
    }

}
