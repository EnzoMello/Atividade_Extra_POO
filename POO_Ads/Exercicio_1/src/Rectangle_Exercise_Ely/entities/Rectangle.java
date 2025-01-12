package Rectangle_Exercise_Ely.entities;

public class Rectangle {
    // CRIANDO OS ATRIBUTOS QUE USAREI NOS CONSTRUTORES
    private double lado1;
    private double lado2;

    // INICIANDO MEU CONSTRUTOR REFERENTE AOS ATRIBUTOS QUE SERÃO INICIALIZADOS NO MEU RETÂNGULO
    public Rectangle(double lado1, double lado2){
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    // FAÇO O ENCAPSULAMENTO PARA TER MAIOR SEGURANÇA SOBRE MEUS ATRIBUTOS
    public double getlado1(){
        return lado1;
    }

    public double getLado2(){
        return lado2;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    // MÉTODO QUE VAI CALCULAR ÁREA
    public double area(){
        return lado1 * lado2;
    }

    // MÉTODO QUE CALCULA O PERÍMETRO DO RETÂNGULO
    public double perimetro(){
        return 2 * lado1 + 2 * lado2;
    }
}
