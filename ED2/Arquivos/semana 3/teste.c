#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

typedef struct {
    char nome[20];
    int idade;
} Cpessoa; 

void le_arquivo(FILE *bin) {
    Cpessoa aluno;
    printf("Informe o nome: "); 
    scanf("%s", aluno.nome);
    printf("Informe a idade: "); 
    scanf("%d", &aluno.idade);
    fwrite(&aluno, sizeof(Cpessoa), 1, bin); 
    fflush(stdin); 
}

void lista_arquivo(FILE *bin) {
    Cpessoa aluno;
    rewind(bin); // Move o ponteiro do arquivo para o início

    // Lê uma estrutura Cpessoa do arquivo binário e imprime os dados
    while (fread(&aluno, sizeof(Cpessoa), 1, bin)) {
        printf("%s \t %d\n", aluno.nome, aluno.idade);
    }
}

int main(void) {
    int opcao;
    FILE *bin;
    int fim = 1;
    
    bin = fopen("arquivo_binario.dat", "ab+"); // Abrindo o arquivo no modo de adição binária
    
    if(bin == NULL) {
        printf("Erro ao abrir arquivo");
        return 1;
    }
    
    while(fim != 0) {
        printf("\n[1] - Inserir\n");
        printf("[2] - Listar\n");
        printf("[3] - Sair\n");
        printf("Digite a opcao: ");
        scanf("%d", &opcao);
        getchar(); // Limpar o buffer de entrada
        
        switch(opcao) {
            case 1:
                le_arquivo(bin);
                break;
            case 2:
                lista_arquivo(bin);
                break;
            case 3:
                printf("\nSaindo...");
                fim = 0; // Controle de saída do while
                break;
            default:
                printf("\nDigite uma opcao valida");
        }
    }
    
    fclose(bin); 
    return 0;
}