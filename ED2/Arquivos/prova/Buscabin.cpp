#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Empresa {
    int codigo;
    char nome[30];
} Empresa;

int main(void) {
    FILE *arquivo_ascii = fopen("alunos_ascii.txt", "r");
    if (arquivo_ascii == NULL) {
        perror("Erro ao abrir o arquivo ASCII");
        return 1;
    }

    // Contando quantos registros existem no arquivo ASCII
    int num_registros = 0;
    char linha[100];
    while (fgets(linha, sizeof(linha), arquivo_ascii) != NULL) {
        num_registros++;
    }

    // Voltando ao início do arquivo para ler os dados
    rewind(arquivo_ascii);

    // Alocação dinâmica de memória para armazenar os dados dos alunos
    Empresa *empresas = (Empresa *)malloc(num_registros * sizeof(Empresa));
    if (empresas == NULL) {
        printf("Erro na alocação de memória");
        
        return 1;
    }

    // Lendo os dados do arquivo ASCII e armazenando na memória
    for (int i = 0; i < num_registros; i++) {
        fscanf(arquivo_ascii, "%d  %[^\n]", &empresas[i].codigo, empresas[i].nome);
    }

    // Fechando o arquivo ASCII
    fclose(arquivo_ascii);

    // Abrindo arquivo para escrita binária
    FILE *arquivo_binario = fopen("alunos_binario.bin", "wb");
    if (arquivo_binario == NULL) {
        printf("Erro ao abrir o arquivo binário");
      
        return 1;
    }

    // Escrevendo os dados dos alunos no arquivo binário
    fwrite(empresas, sizeof(Empresa), num_registros, arquivo_binario);

    // Fechando o arquivo binário
    fclose(arquivo_binario);

    // Liberando a memória alocada
    free(empresas);

    printf("Dados gravados com sucesso no arquivo binário.\n");

    // Abrindo arquivo binário para leitura
    arquivo_binario = fopen("alunos_binario.bin", "rb");
    if (arquivo_binario == NULL) {
        printf("Erro ao abrir o arquivo binário para leitura");
        return 1;
    }

    // Obtendo o tamanho do arquivo binário
    fseek(arquivo_binario, 0, SEEK_END);
    long tamanho_arquivo = ftell(arquivo_binario);
    rewind(arquivo_binario);

    // Calculando o número de registros no arquivo binário
    int num_registros_binario = tamanho_arquivo / sizeof(Empresa);

    // Alocando memória para ler os dados do arquivo binário
    Empresa *empresas_binario = (Empresa *)malloc(num_registros_binario * sizeof(Empresa));
    if (empresas_binario == NULL) {
        printf("Erro na alocação de memória");
        
        return 1;
    }

    // Lendo os dados do arquivo binário
    fread(empresas_binario, sizeof(Empresa), num_registros_binario, arquivo_binario);

    // Imprimindo os dados lidos do arquivo binário
    for (int i = 0; i < num_registros_binario; i++) {
        printf("%d \t %s\n", empresas_binario[i].codigo, empresas_binario[i].nome);
    }

    // Fechando o arquivo binário
    fclose(arquivo_binario);

    // Liberando a memória alocada
    free(empresas_binario);

    return 0;
}
