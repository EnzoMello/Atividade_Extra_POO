function soma(x: number, y?: any): number {
    return x + y
    }
    console.log(soma(1, 2));
    console.log(soma(1, "2"));
    console.log(soma(1));

    // No y, ter um valor como any permite que ele receba qualquer tipo. Então, ele retorna 3 na primeira alternativa, 12 na segunda(ocorrer concatenação de String ao número) e 1 na terceira, já que y não é passado.