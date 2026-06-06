package clases;

import java.util.ArrayList;

public class Instructor extends Persona {
    private ArrayList<Estudiante> alumnos;
    private ArrayList<String> bootcamps;

    public Instructor(String nombreCompleto, String fechaNacimiento, String email) {
        super(nombreCompleto, fechaNacimiento, email);
        this.alumnos = new ArrayList<>();
        this.bootcamps = new ArrayList<>();
    }

    public ArrayList<Estudiante> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Estudiante> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<String> getBootcamps() {
        return bootcamps;
    }

    public void setBootcamps(ArrayList<String> bootcamps) {
        this.bootcamps = bootcamps;
    }

    public void agregarBootcamp(String bootcamp) {
        this.bootcamps.add(bootcamp);
    }

    public void agregarAlumno(Estudiante alumno) {
        this.alumnos.add(alumno);
    }

    @Override
    public String toString() {
        return "Instructor: " + super.toString() + " [alumnos=" + alumnos + ", bootcamps=" + bootcamps + "]";
    }

}
