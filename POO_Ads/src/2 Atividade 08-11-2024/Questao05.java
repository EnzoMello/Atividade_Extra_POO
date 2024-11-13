public class Main{
    // String... args é uma maneira de emular o RestParameter do tsypescript, permitindo passar uma quantidade variável de strings
    public static void exibir(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public static void main(String[] args) {
        // Chamadas de função com diferentes números de parâmetros
        exibir("a", "b");              
        exibir("a", "b", "c");          
        exibir("a", "b", "c", "d");     
    }
}

/* Em TypeScript:
 * function exibir(...args: string[]) {
    args.forEach(arg => console.log(arg));
}

// Chamadas de função com diferentes números de parâmetros
exibir("a", "b");              // Imprime: "a", "b"
exibir("a", "b", "c");          // Imprime: "a", "b", "c"
exibir("a", "b", "c", "d");     // Imprime: "a", "b", "c", "d"

 */
