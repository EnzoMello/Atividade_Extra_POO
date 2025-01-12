package Circle_Exercise_Ely.entities;

public class Entities {
    // INICIO MEU ATRIBUTO RAIO
    private double raio;

    // CRIO MEU CONSTRUTOR QUE JÁ INICIA ATRIBUINDO O MEU ATRIBUTO RAIO A UM PARÂMETRO RAIO PASSADO
    public Entities(double raio){
        this.raio = raio;
    }

    // CRIANDO MEUS MÉTODOS PARA PERÍMETRO E ÁREA
    public double area(){
        return raio * raio * 3.14;
    }

    public double perimetro(){
        return 2 * 3.14 * raio;
    }
}
