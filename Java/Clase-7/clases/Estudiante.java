package clases;

import java.util.ArrayList;
import java.util.Random;

public class Estudiante extends Persona implements Calculos {
    private int nroLegajo;
    private String bootcamp;
    private String cohorte;
    private ArrayList<Integer> calificaciones;
    public static ArrayList<Integer> legajos = new ArrayList<>();

    public Estudiante() {
        super();
        this.nroLegajo = 0;
        this.bootcamp = "";
        this.cohorte = "";
        this.calificaciones = new ArrayList<>();
    }

    public Estudiante(String nombreCompleto, String fechaNacimiento, String email, String bootcamp, String cohorte) {
        super(nombreCompleto, fechaNacimiento, email);
        this.nroLegajo = generarNroLegajo();
        this.bootcamp = bootcamp;
        this.cohorte = cohorte;
        this.calificaciones = new ArrayList<>();
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

    public ArrayList<Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Integer> calificaciones) {
        this.calificaciones = calificaciones;
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
                + cohorte + ", calificaciones=" + calificaciones + "]";
    }

    @Override
    public double calcularPromedioCalificaciones() {
        double suma = 0;
        for (int i = 0; i < calificaciones.size(); i++) {
            suma += calificaciones.get(i);
        }
        return suma / calificaciones.size();
    }

    @Override
    public String verCalificaciones() {
        return super.getNombreCompleto() + ": " + calificaciones;
    }

}
