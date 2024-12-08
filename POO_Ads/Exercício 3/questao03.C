#include <stdio.h>

int main() {
    int x = 10;
    float y = 5.5;
    int result = x + y; // 'y' é convertido implicitamente para int, resultando em perda de precisão

    printf("Resultado da soma: %d\n", result); // Saída: 15 (o valor decimal de y é descartado)

    return 0;
}

// Mesmo com y sendo float, implicitamente vira int. A linguagem C, por ter tipagem fraca, permite essas conversoes. Isso pode causar erros inesperados.