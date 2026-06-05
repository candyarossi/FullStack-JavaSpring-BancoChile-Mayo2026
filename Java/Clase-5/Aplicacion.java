import clases.Persona;

public class Aplicacion {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Lucía Pérez", "1994-02-19");

        persona1.setNombreCompleto("Roberto López");
        persona1.setFechaNacimiento("1986-06-03");

        persona2.setFechaNacimiento("2002-07-12");

        System.out.println(persona1.toString());
        System.out.println(persona2.toString());

        System.out.println("La persona1 es: " + persona1.getNombreCompleto());
    }
}