import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

import clases.Calculadora;

public class Aplicacion {
    public static void main(String[] args) {

        // Métodos Estáticos y Modularización
        int rta = Calculadora.sumar(8, 9);
        int rta2 = Calculadora.sumar(8, 9, rta);
        int rta3 = Calculadora.sumar(8, 9, 10.7);

        System.out.println("La suma entre 8 y 9 es: " + rta);
        System.out.println("La suma entre 8, 9 y 17 es: " + rta2);
        System.out.println("La suma entre 8, 9 y 10.7 es: " + rta3);

        Date fechaActual = new Date();
        System.out.println("La fecha actual es: " + fechaActual);

        // Arreglos Estáticos
        int[] numeros = new int[5];
        String[] numeros2 = { "1", "2", "3", "4", "5" };

        numeros[0] = 10;
        numeros[2] = 23;
        // numeros[8] = 56;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        // Arreglos Dinámicos
        ArrayList<String> colores = new ArrayList<String>();

        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Azul");

        colores.addAll(Arrays.asList("Amarillo", "Violeta", "Naranja"));

        colores.remove("Verde");
        colores.remove(1);

        String primerColor = colores.get(0);

        colores.set(1, "Negro");

        boolean contieneAzul = colores.contains("Azul");

        for (int i = 0; i < colores.size(); i++) {
            System.out.println(colores.get(i));
        }

        System.out.println(colores);
        System.out.println(primerColor);
        System.out.println(contieneAzul);
    }
}
