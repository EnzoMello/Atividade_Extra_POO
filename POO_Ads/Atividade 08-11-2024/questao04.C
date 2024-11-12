#include <stdio.h>

int main() {
    int x = 10;
    float y = 5.5;
    int result = x + y; // 'y' é convertido implicitamente para int, perdendo a parte decimal

    printf("Resultado da soma: %d\n", result); // Saída: 15 (a parte decimal de 'y' é descartada)
    
    return 0;
}
