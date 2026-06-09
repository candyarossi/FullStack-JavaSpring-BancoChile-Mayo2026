import java.util.ArrayList;
import java.util.Arrays;

import clases.Estudiante;
import clases.Instructor;

public class Aplicacion {
    public static void main(String[] args) {

        /*
         * Persona persona = new Instructor("", "", "");
         * Persona persona2 = new Estudiante();
         * ArrayList<Persona> usuarios = new ArrayList<>();
         */

        Estudiante estudiante1 = new Estudiante("Candela Yarossi", "1996-10-08", "candyarossi@gmail.com",
                "Full Stack Java", "A");

        Estudiante estudiante2 = new Estudiante("Estudiante 2", "1985-03-21", "asd@asd.com", "Java", "A");
        Estudiante estudiante3 = new Estudiante("Estudiante 3", "1997-12-08", "asd2@asd.com", "Java", "A");

        System.out.println(estudiante1);
        System.out.println(estudiante2);
        System.out.println(estudiante3);

        Instructor instructor1 = new Instructor("Instructor 1", "1985-04-19", "instructor@mail.com");

        instructor1.agregarBootcamp("Java");

        instructor1.agregarAlumno(estudiante1);
        instructor1.agregarAlumno(estudiante3);

        System.out.println(instructor1);

        ArrayList<Integer> calificaciones1 = new ArrayList<Integer>(Arrays.asList(6, 9, 7));
        ArrayList<Integer> calificaciones2 = new ArrayList<Integer>(Arrays.asList(10, 8, 7));

        estudiante1.setCalificaciones(calificaciones2);
        estudiante3.setCalificaciones(calificaciones1);

        System.out.println("El promedio de calificaciones del estudiante 1 es: "
                + String.format("%.2f", estudiante1.calcularPromedioCalificaciones()));
        System.out.println("El promedio de calificaciones del estudiante 3 es: "
                + String.format("%.2f", estudiante3.calcularPromedioCalificaciones()));

        System.out.println("El promedio de las calificaciones de los estudiantes del instructor 1 es: "
                + String.format("%.2f", instructor1.calcularPromedioCalificaciones()));

        System.out.println(estudiante1.verCalificaciones());
        System.out.println(instructor1.verCalificaciones());
    }
}
