#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_LENGTH 100 // Tamanho máximo da linha no arquivo

typedef struct {
    int id;
    char nome[50];
    float salario;
} Registro;

int main() {
    FILE *arquivo_ascii, *arquivo_binario;
    Registro registro;
    clock_t inicio, fim;
    double tempo_ascii, tempo_binario;
    int num_registros_ascii = 0, num_registros_binario = 0;

    // Abre o arquivo ASCII
    arquivo_ascii = fopen("arquivo_colunas.txt", "r");
    if (arquivo_ascii == NULL) {
        perror("Erro ao abrir o arquivo ASCII");
        return EXIT_FAILURE;
    }

    // Mede o tempo de leitura do arquivo ASCII e conta o número de registros
    inicio = clock();
    while (!feof(arquivo_ascii)) {
        fscanf(arquivo_ascii, "%d %s %f", &registro.id, registro.nome, &registro.salario);
            num_registros_ascii++;
        }
    fim = clock();
    tempo_ascii = ((double)(fim - inicio)) / CLOCKS_PER_SEC;

    // Fecha o arquivo ASCII
    fclose(arquivo_ascii);

    // Abre o arquivo binário
    arquivo_binario = fopen("arquivo_binario.bin", "rb");
    if (arquivo_binario == NULL) {
        perror("Erro ao abrir o arquivo binário");
        return EXIT_FAILURE;
    }

    // Mede o tempo de leitura do arquivo binário e conta o número de registros
    inicio = clock();
    while (fread(&registro, sizeof(Registro), 1, arquivo_binario) == 1) {
        num_registros_binario++;
    }
    fim = clock();
    tempo_binario = ((double)(fim - inicio)) / CLOCKS_PER_SEC;

    // Fecha o arquivo binário
    fclose(arquivo_binario);

    printf("Número de registros no arquivo ASCII: %d\n", num_registros_ascii);
    printf("Número de registros no arquivo binário: %d\n", num_registros_binario);
    printf("Tempo de leitura do arquivo ASCII: %f segundos\n", tempo_ascii);
    printf("Tempo de leitura do arquivo binário: %f segundos\n", tempo_binario);

    return EXIT_SUCCESS;
}
