// CRIANDO A CLASSE CONTROLE DE ÁUDIO
class ControleDeAudio {
    private volume: number; // NUMBER SERVE TANTO PARA INT QUANTO PARA FLOAT, DIFERENTE DO JAVA(TEM INT E TEM FLOAT)

    // CRIANDO UM CONSTRUTOR, AQUI POSSO USAR DIRETO CONSTRUCTOR
    constructor(volume: number = 2){
        this.volume = volume; // MEU ATRIBUTO VOLUME VIRA O VOLUME PARÂMETRO
    }

    // CRIANDO OS MÉTODOS PARA AUMENTAR,DIMINUIR E LER VOLUME RESPECTIVAMENTE
    aumentar(): number{
        if(this.volume < 10){
            this.volume += 1;
        }
        return this.volume;
    }

    diminui(): number{
        if(this.volume > 0){
            this.volume -= 1;
        }
        return this.volume;
    }

    lerVolume(): number{
        return this.volume;
    }

    // AGORA, DEPOIS DE CRIAR OS MÉTODOS, CRIO A MAIN. ELA DIFERE APENAS UM POUCO DO JAVA, ASSIM COMO OS MÉTODOS
    public static main(): void {
        // NOTE QUE SE USA UM POUCO DE JAVASCRIPT NA DECLARAÇÃO DE UMA VARIÁVEL QUE CARREGA MEU CONSTRUTOR
        const audio = new ControleDeAudio(2);

        console.log(`Aumentando o audio: ${audio.aumentar()}`);
        console.log(`Aumentando o audio: ${audio.aumentar()}`);
        console.log(`diminuindo o audio: ${audio.diminui()}`);
        console.log(`lendo o audio: ${audio.lerVolume()}`);


    }

}
// CHAMA O MÉTODO PRINCIPAL
ControleDeAudio.main();