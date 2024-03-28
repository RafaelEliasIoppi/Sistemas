#include <stdio.h>
#include <stdlib.h>

int main() {
    double *a;
    int i;
    size_t tamanho = 1; // Começa com um tamanho mínimo de 1

    // Tenta alocar memória em blocos cada vez maiores até falhar
    while (1) {
        a = (double *)malloc(sizeof(double) * tamanho); // Tenta alocar memória

        
        if (a == NULL) {
                
            break; // se alocação falhar sai do while
        }

        tamanho *= 2; // Dobra o tamanho a cada iteração
        free(a); 
    }
    

    printf("A) Posicao de Memoria ocuapda: %zu\n", tamanho);

    // Calcula quantos MB ou GB o programa reservou
    size_t bytes = sizeof(double) * tamanho;
    double megabytes = (double)bytes / (1024 * 1024);
    double gigabytes = megabytes / 1024;
    printf("b) Quantos MB ou GB o seu programa reservou? %.2f MB (%.2f GB)\n", megabytes, gigabytes);

    // Imprime os cinco primeiros endereços de memória
    printf("c) Quais sao os cinco primeiros enderecos de memoria?\n");
    for (i = 0; i < 5 && i < tamanho; i++) {
        printf("Endereco de a[%d]: %p\n", i, &a[i]);
    }
    // Calcula o deslocamento de cada endereço
    size_t deslocamento = sizeof(double); // Tamanho de um double em bytes
    printf("d) O deslocamento de cada endereço e de quantos bytes? %zu bytes.\n", deslocamento);
    printf("   Cada endereço de memoria e deslocado em %zu bytes.\n", deslocamento);

    return 0;
}