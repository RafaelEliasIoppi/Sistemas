#include <stdio.h>
#include <stdlib.h>

int busca_sequencial(int *vetor, int tamanho, int valor) {
    int acessos = 0;
    for (int i = 0; i < tamanho; i++) {
        acessos++;
        if (vetor[i] == valor) {
            return acessos;
        }
    }
    return acessos;
}

int busca_binaria(int *vetor, int tamanho, int valor) {
    int acessos = 0;
    int esquerda = 0, direita = tamanho - 1;
    while (esquerda <= direita) {
        int meio = (esquerda + direita) / 2;
        acessos++;
        if (vetor[meio] == valor) {
            return acessos;
        }
        else if (vetor[meio] < valor) {
            esquerda = meio + 1;
        }
        else {
            direita = meio - 1;
        }
    }
    return acessos;
}

int main() {
    // Abrir o arquivo
    FILE *arquivo = fopen("dados.txt", "r");
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    // Ler o número de elementos no arquivo
    int tamanho = 0;
    int valor;
    while (fscanf(arquivo, "%d", &valor) != EOF) {
        tamanho++;
    }

    // Alocar memória para o vetor
    int *vetor = (int *)malloc(tamanho * sizeof(int));
    if (vetor == NULL) {
        perror("Erro ao alocar memória");
        fclose(arquivo);
        return 1;
    }

    // Voltar para o início do arquivo
    fseek(arquivo, 0, SEEK_SET);

    // Ler os valores do arquivo para o vetor
    int i = 0;
    while (fscanf(arquivo, "%d", &vetor[i]) != EOF) {
        i++;
    }

    // Fechar o arquivo
    fclose(arquivo);

    // Valores a serem buscados
    int valores[] = {7341488, 85, 265654, 732765, 8313596, 45744};
    int total_acessos_sequencial = 0;
    int total_acessos_binaria = 0;
    int tam_vetor = sizeof(valores) / sizeof(valores[0]);

    // Realizar as buscas
    for (int j = 0; j < tam_vetor; j++) {
        total_acessos_sequencial += busca_sequencial(vetor, tamanho, valores[j]);
        total_acessos_binaria += busca_binaria(vetor, tamanho, valores[j]);
    }

    // Imprimir os resultados
    printf("Total de acessos na busca sequencial: %d\n", total_acessos_sequencial);
    printf("Total de acessos na busca binária: %d\n", total_acessos_binaria);

    // Calcular e imprimir o ganho de desempenho
    double ganho_desempenho = ((double)(total_acessos_sequencial - total_acessos_binaria) / total_acessos_sequencial) * 100;
    printf("Ganho de desempenho da busca binária em relação à busca sequencial: %.2f%%\n", ganho_desempenho);

    // Liberar memória alocada
    free(vetor);

    return 0;
}
