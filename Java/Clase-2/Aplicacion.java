public class Aplicacion {
    public static void main(String[] args) {
        // STRINGS
        String str1 = "Hola Mundo!";
        String str2 = new String("Hola Mundo!");

        String saludo = "Hola" + " " + "Mundo!";

        String banco = "Banco";
        String chile = "Chile";

        // .concat()
        String strConcat = banco.concat(" ").concat(chile);
        System.out.println(strConcat);

        // .length()
        int longitud = strConcat.length();
        System.out.println("Tamaño de String: " + longitud);

        // .indexOf()
        int posicion = strConcat.indexOf("a");
        int posicion2 = strConcat.indexOf("Chile");
        System.out.println("La letra A está en " + posicion);
        System.out.println("La palabra CHILE está en " + posicion2);

        // .toUpperCase() .toLowerCase()
        String mayusculas = strConcat.toUpperCase();
        String minusculas = strConcat.toLowerCase();
        System.out.println(mayusculas);
        System.out.println(minusculas);

        // .trim()
        String conEspacios = "               " + strConcat + "                ";
        System.out.println(conEspacios);
        String sinEspacios = strConcat.trim();
        System.out.println(sinEspacios);

        // .equals() .equalsIgnoreCase()
        String paraComparar = "Banco Chile";
        String paraComparar2 = "banco chile";

        boolean rta1 = strConcat.equals(paraComparar); // true
        boolean rta2 = strConcat.equals(paraComparar2); // false

        boolean rta3 = strConcat.equalsIgnoreCase(paraComparar); // true
        boolean rta4 = strConcat.equalsIgnoreCase(paraComparar2); // true

        System.out.println("Equals: " + rta1 + " / " + rta2);
        System.out.println("EqualsIgnoreCase: " + rta3 + " / " + rta4);

        // CONDICIONALES
        int numero = -10;

        if (numero > 0) {
            System.out.println("El número es positivo.");
        } else if (numero < 0) {
            System.out.println("El número es negativo.");
        } else {
            System.out.println("El número es 0.");
        }

        // Operador ternario
        int edad = 20;

        if (edad >= 18) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }

        if (edad >= 18)
            System.out.println("Es mayor de edad.");
        else
            System.out.println("Es menor de edad.");

        String resultado = (edad >= 18) ? "Es mayor de edad." : "Es menor de edad.";
        System.out.println(resultado);

        // Switch
        int nroDia = 3;
        String nombreDia = null;

        switch (nroDia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sábado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "Número inválido";
                break;
        }

        System.out.println("El día es: " + nombreDia);

        // CICLOS
        int[] numeros = { 23, 86, 45, 97, 32, 53 };

        // for
        System.out.println("FOR:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        // while
        System.out.println("WHILE:");

        int i = 0;

        while (i < numeros.length) {
            System.out.println(numeros[i]);
            i++;
        }

        // do-while
        System.out.println("DO-WHILE");

        int j = 5;

        do {
            System.out.println(numeros[j]);
            j++;
        } while (j < numeros.length);

        // for-each
        System.out.println("FOR-EACH");

        for (int nro : numeros) {
            System.out.println(nro);
        }
    }
}