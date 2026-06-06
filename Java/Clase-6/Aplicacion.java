import clases.Estudiante;
import clases.Instructor;

public class Aplicacion {
    public static void main(String[] args) {

        /*
         * Persona persona1 = new Persona();
         * Persona persona2 = new Persona("Lucía Pérez", "1994-02-19");
         * Persona persona3 = new Persona("Juana Álvarez", "1987-03-29",
         * "juana@mail.com");
         * 
         * persona1.setNombreCompleto("Roberto López");
         * persona1.setFechaNacimiento("1986-06-03");
         * 
         * persona2.setFechaNacimiento("2002-07-12");
         * 
         * int sumaEdades = persona1.getEdad() + persona2.getEdad();
         * 
         * System.out.println(persona1.toString());
         * System.out.println(persona2.toString());
         * System.out.println(persona3);
         * 
         * System.out.println("La persona1 es: " + persona1.getNombreCompleto());
         * System.out.println("Próximo ID: " + Persona.incrementId);
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
    }
}
