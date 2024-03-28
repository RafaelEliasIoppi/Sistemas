#include <stdio.h>
#include <locale.h>

#define TAM_VET 1000000

int ler_arquivo_para_vetor( char *nome_arquivo, int vetor[], int *tamanho) {
    FILE *arquivo = fopen(nome_arquivo, "r"); // Abre o arquivo para leitura
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s.\n", nome_arquivo);
        return 0; // Retorna 0 se houver erro ao abrir o arquivo
    }

    *tamanho = 0; // Inicializa o tamanho do vetor

    while (*tamanho < TAM_VET && fscanf(arquivo, "%d", &vetor[*tamanho]) == 1) {
        (*tamanho)++; // Incrementa o tamanho do vetor
    }

    fclose(arquivo); // Fecha o arquivo
    return 1; // Retorna 1 se os dados foram lidos com sucesso
}
// Função para buscar um valor no vetor usando busca sequencial
int busca_sequencial( int vetor[], int tamanho, int valor, int *acessos) { // o vetor da busca, tam do vetor, o valor buscado, o contador é um ponteiro
    for (int i = 0; i < tamanho; i++) {
        (*acessos)++; // Incrementa o contador de acessos. incrementa a variavel cont_sequencial
        if (vetor[i] == valor) {
            return i; // Retorna o índice do valor encontrado
        }
    }
    return -1; // Retorna -1 se o valor não for encontrado
}

// Função para buscar um valor no vetor usando busca binária
int busca_binaria(int vetor[], int tamanho, int valor, int *acessos) {
    int esquerda = 0;
    int direita = tamanho - 1;
    
    while (esquerda <= direita) {
        (*acessos)++; // Incrementa o contador de acessos. incrementa a variavel cont_binario
        int meio = (esquerda + direita) / 2;
        
        if (vetor[meio] == valor) {
            return meio; // Retorna o índice do valor encontrado
        } else if (vetor[meio] < valor) {
            esquerda = meio + 1;
        } else {
            direita = meio - 1;
        }
    }
    
    return -1; // Retorna -1 se o valor não for encontrado
}


int main() {
    setlocale(LC_ALL, "Portuguese"); // Define o locale para português

    int vetor[TAM_VET]; // Vetor para armazenar os dados
    int tamanho_vetor; // Tamanho atual do vetor
    int cont_sequencial = 0; // Contador de acessos para a busca sequencial
    int total_cont_sequencial = 0; // Total de acessos para a busca sequencial
    int cont_binaria = 0; // Contador de acessos para a busca binária
    int total_cont_binaria = 0; // Total de acessos para a busca binária

    // Chama a função para ler os dados do arquivo e armazená-los no vetor
    if (!ler_arquivo_para_vetor("dados.txt", vetor, &tamanho_vetor)) {
        printf("Falha ao carregar os dados do arquivo. O programa será encerrado.\n");
        return 1; // Encerra o programa se houver erro ao ler o arquivo
    }

    // Valores a serem buscados
    int valores[] = {7341488, 85, 265654, 732765, 8313596, 45744};
    int num_valores = sizeof(valores) / sizeof(valores[0]); //retorna o numero de elementos do vetor

    // Busca sequencial para cada valor
    for (int i = 0; i < num_valores; i++) {
        int indice = busca_sequencial(vetor, tamanho_vetor, valores[i], &cont_sequencial);//passa o vetor da busca, o TAM do vetor, o valor ,e o contador (ponteiro)
        if (indice != -1) { // sempre que o valor é diferente de -1 o contador é incrementado
            total_cont_sequencial += cont_sequencial; //
            printf("Valor --> %d --> encontrado na posição --> %d com --> %d acessos (busca sequencial).\n", valores[i], indice, cont_sequencial);
        } else {
            printf("Valor --> %d --> não encontrado (busca sequencial).\n", valores[i]);
        }
    }

 // Busca binária para cada valor
for (int i = 0; i < num_valores; i++) {
    int indice = busca_binaria(vetor, tamanho_vetor, valores[i], &cont_binaria);
    if (indice != -1) {
        total_cont_binaria += cont_binaria;
        printf("Valor --> %d --> encontrado na posição --> %d com --> %d acessos (busca binária).\n", valores[i], indice, cont_binaria);
    } else {
        printf("Valor --> %d --> não encontrado (busca binária).\n", valores[i]);
    }
}

printf("Total de acessos da busca sequencial: %d\n", total_cont_sequencial);
printf("Total de acessos da busca binária: %d\n", total_cont_binaria);

int diferenca = total_cont_sequencial - total_cont_binaria;
printf("Diferença da busca binária em relação à busca sequencial: %d acessos\n", diferenca);

return 0; 
}

