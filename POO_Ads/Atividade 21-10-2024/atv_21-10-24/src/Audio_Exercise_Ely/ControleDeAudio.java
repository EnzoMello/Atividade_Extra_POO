package Audio_Exercise_Ely;

public class ControleDeAudio {
    private int volume;

    // CRIANDO MEU CONSTRUTOR QUE INICIALIZA VOLUME
    public ControleDeAudio(int volume) {
        this.volume = volume;
    }

    // MÉTODO PARA AUMENTAR O VOLUME EM UM
    public int aumentaVolume() {
        if (volume < 10) {
            volume += 1;
        }
        return volume;
    }

    // MÉTODO PARA DIMINUIR VOLUME EM UM
    public int diminuiVolume() {
        if (volume > 0) {
            volume -= 1;
        }
        return volume;
    }

    // MÉTODO QUE RETORNA VOLUME
    public int lerVolume() {
        return volume;
    }
}
