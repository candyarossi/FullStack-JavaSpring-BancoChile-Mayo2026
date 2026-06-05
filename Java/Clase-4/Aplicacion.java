import java.util.HashMap;
import java.util.Set;

public class Aplicacion {
    public static void main(String[] args) {

        // HASHMAPS o MAPAS DE HASH
        HashMap<String, Integer> edades = new HashMap<String, Integer>();

        edades.put("Juan", 46);
        edades.put("Maria", 34);
        edades.put("Laura", 62);
        edades.put("Maria", 26);

        System.out.println(edades);

        int edadLaura = edades.get("Laura");
        System.out.println("La edad de Laura es: " + edadLaura);

        edades.remove("Laura");
        System.out.println(edades);

        System.out.println("¿Está vacío el hashmap? " + edades.isEmpty());
        System.out.println("Tamaño del HM: " + edades.size());

        // edades.clear();
        // System.out.println(edades);

        Set<String> claves = edades.keySet();

        for (String clave : claves) {
            System.out.println(clave + ":" + edades.get(clave));
        }

        // EXCEPCIONES
        int[] numeros = { 1, 2, 3, 4, 5, 6 };

        try {
            int posicion2 = numeros[2];
            int posicion3 = numeros[3];
            int posicion8 = numeros[8];

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No se puede acceder a ese índice.");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
        }
    }
}