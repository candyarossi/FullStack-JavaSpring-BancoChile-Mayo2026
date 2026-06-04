package clases;

public class Calculadora {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int sumar(int a, int b, int c) {
        return a + b + c;
    }

    public static int sumar(int a, int b, double c) {
        return a + b + (int) c;
    }
}
