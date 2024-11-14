public class Triangulo {
    private int a;
    private int b;
    private int c;

    // Construtor que inicia meus atibutos e os relaciona com as variáveis declaradas
    public Triangulo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Método que verifica se os lados formam um triângulo
    public boolean ehTriangulo() {
        return (Math.abs(b - c) < a && a < (b + c)) &&
               (Math.abs(a - c) < b && b < (a + c)) &&
               (Math.abs(a - b) < c && c < (a + b));
    }

    // Método que verifica se o triângulo é isósceles
    public boolean ehIsoceles() {
        if (!ehTriangulo()) {
            return false;
        }
        return (a == b || b == c || a == c);
    }

    // Método que verifica se o triângulo é equilátero
    public boolean ehEquilatero() {
        if (!ehTriangulo()) {
            return false;
        }
        return (a == b && b == c);
    }

    // Método que verifica se o triângulo é escaleno
    public boolean ehEscaleno() {
        if (!ehTriangulo()) {
            return false;
        }
        return (a != b && b != c && a != c);
    }

    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(3, 4, 5);
        Triangulo t2 = new Triangulo(2, 2, 3);
        Triangulo t3 = new Triangulo(5, 5, 5);
        Triangulo t4 = new Triangulo(1, 2, 3); 

        System.out.println("Triângulo t1: " + t1.ehTriangulo()); // true
        System.out.println("É Isósceles? " + t1.ehIsoceles()); // false
        System.out.println("É Equilátero? " + t1.ehEquilatero()); // false
        System.out.println("É Escaleno? " + t1.ehEscaleno()); // true

        System.out.println("Triângulo t2: " + t2)
    }
}