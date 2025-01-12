package Financial_Exercise_Ely.entities;

public class FinancialSituation {
    private double valorCreditos;
    private double valorDebitos;

    // APÓS CRIAR MEUS ATRIBUTOS, CRIO MEU CONSTRUTOR PARA INCIALIZAR OS ATRIBUTOS DA MINHA CLASSE
    public FinancialSituation(double valorCreditos, double valorDebitos){
        this.valorCreditos = valorCreditos;
        this.valorDebitos = valorDebitos;
    }

    // CRIO MÉTODO PARA RETORNA SALDO
    public double calcularSaldo(){
        return valorCreditos - valorDebitos;
    }
}
