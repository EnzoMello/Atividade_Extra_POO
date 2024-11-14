public class Equipamento{
    public boolean sensor;

    // Iniciando meu construtor
    public Equipamento(boolean sensor){
        this.sensor = sensor;
    }

    // Método para ligar o equipamento
    public boolean liga(){
        if (sensor = false){
            sensor = true;
        }
        return sensor;
    }

    // Método para desligar o equipamento
    public boolean desliga(){
        if (sensor){
            sensor = false;
        }
    }

    // Método para inverter estado
    public boolean inverte(){
       sensor = !sensor;
       return sensor;
    }

    // Método para verificar se o equipamento está ligado
    public boolean estaLigado(){
        return sensor;
    }

    public static void main(String[] args){
        Equipamento equipamento = new equipamento(true);

        equipamento.liga();
        equipamento.desliga(); 
        equipamento.inverte();

        System.out.println(equipamento.estaLigado());
    }
}