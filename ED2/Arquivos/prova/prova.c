#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
//****************Atividade 01********************** 
typedef struct {
    int icodigo;
    char esfera[16];
    char solicitante[80];
    char situacao[10];
    char data[16];
    char motivo[80];
} DADOS;


//****************Atividade 04.2********************** 
DADOS* busca_binaria(int codigo, DADOS *vetor, int tamanho) {
    int esquerda = -1;
    int direita = tamanho;

    while (esquerda < direita - 1) {
        int meio = (esquerda + direita) / 2;
        if (vetor[meio].icodigo < codigo)
            esquerda = meio;
        else
            direita = meio;
    }

    if (vetor[direita].icodigo == codigo)
        return &vetor[direita]; // Retorna o ponteiro para a estrutura se o código for encontrado
    else
        return NULL; // Retorna NULL se o código não for encontrado
}





int main() {
	
   setlocale(LC_ALL, "Portuguese");

    FILE *txt;
    FILE *bin;
    int num_solicitantes = 0;
    int linhas = 0;
    int codigoBuscado;
   
   
//****************Atividade 02.1**********************    
    DADOS *solicitantes = (DADOS *)malloc(1000 * sizeof(DADOS));
   

    if ((txt = fopen("dados.prn", "r")) == NULL) {
        printf("Erro ao abrir arquivo");
   		return 1;
   }
   
     
    while (!feof(txt)) {
        if (linhas % 1000 == 0){
//****************Atividade 02.2**********************      
                solicitantes = (DADOS *)realloc(solicitantes, (linhas + 1000) * sizeof(DADOS));
            }

        fscanf(txt, "%d %10s %79[^\n] %8s %10s %80[^\n]", &solicitantes[num_solicitantes].icodigo, solicitantes[num_solicitantes].esfera, solicitantes[num_solicitantes].solicitante, solicitantes[num_solicitantes].situacao, solicitantes[num_solicitantes].data, solicitantes[num_solicitantes].motivo);
        // printf("%d - %s - %s - %s - %s - %s\n", solicitantes[num_solicitantes].icodigo, solicitantes[num_solicitantes].esfera, solicitantes[num_solicitantes].solicitante, solicitantes[num_solicitantes].situacao, solicitantes[num_solicitantes].data, solicitantes[num_solicitantes].motivo);
            
        num_solicitantes++;
        linhas++;
    }
        fclose(txt);

//****************Atividade 03.1*********************
    
    if ((bin = fopen("dados.bin", "wb")) == NULL) {
        printf("Erro ao abrir arquivo binário para gravação");
        return 1;
    }
    fwrite(solicitantes, sizeof(DADOS), num_solicitantes, bin);
    fclose(bin);
    printf("Arquivo binário 'dados.bin' gerado com sucesso!\n");


    //Leitura dos dados do arquivo binário */
    if ((bin = fopen("dados.bin", "rb")) == NULL) {
        printf("Erro ao abrir arquivo binário para leitura");
        return 1;
    }
    
    fseek(bin, 0, SEEK_END); //Move o ponteiro de arquivo para o final do arquivo
    num_solicitantes = ftell(bin) / sizeof(DADOS); // Obtém o tamanho total do arquivo em bytes e divide pelo tamanho de um registro
    rewind(bin);// Reposiciona o ponteiro de arquivo para o início do arquivo

  
    DADOS *dados_lidos = (DADOS *)malloc(num_solicitantes * sizeof(DADOS));
   
//****************Atividade 03.2**********************
    fread(dados_lidos, sizeof(DADOS), num_solicitantes, bin);
    fclose(bin);

       

   do {
    printf("Digite o código para buscar informações (ou 0 para sair): ");
    scanf("%d", &codigoBuscado);

    if (codigoBuscado != 0) {
//****************Atividade 04.1********************** "
        DADOS *resultado = busca_binaria(codigoBuscado, dados_lidos, num_solicitantes);
        if (resultado != NULL) {
            printf("Valor Localizado na posição de memória: %p\n", *resultado);
            printf("%d \t- %s - %s - %s - %s - %s\n", resultado->icodigo, resultado->esfera, resultado->solicitante, resultado->situacao, resultado->data, resultado->motivo);
        } else {
            printf("Valor NÃO Localizado\n");
        }
    }
} while (codigoBuscado != 0);

// Liberando a memória alocada
	free(dados_lidos);
	free(solicitantes);

system("pause");
return 0;
}