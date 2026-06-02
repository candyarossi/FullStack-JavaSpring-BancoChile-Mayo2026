public class Aplicacion {
    public static void main(String[] args) {
        System.out.print("¡Hola Mundo!");

        // TIPOS DE DATOS
        // Datos primitivos: byte, short, int, long, float, double, char, boolean
        int edad = 19;
        long edad2 = 19l;
        float altura = 1.75f;
        double altura2 = 1.75;
        boolean esEstudiante = true;
        char inicial = 'J';

        // Clases envoltura / wrappers: Byte, Short, Integer, Long, Float, Double,
        // Character, Boolean, String
        String nombreCompleto = "Juan Pérez";

        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("Es Estudiante: " + esEstudiante);
        System.out.println("Inicial: " + inicial);
        System.out.println("Nombre: " + nombreCompleto);

        // CASTING o CASTEO de Datos
        double miDouble = 10.5;
        int miEntero = (int) miDouble;

        int miEntero2 = 10;
        double miDouble2 = miEntero2;

        char letra = 'C';
        String palabra = String.valueOf(letra);
    }
}