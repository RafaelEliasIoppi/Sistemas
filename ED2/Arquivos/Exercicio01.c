#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h> // Para usar a função tolower

int verificarPalavra(const char *conteudo, const char *palavra) {
    int tamanhoConteudo = strlen(conteudo);
    int tamanhoPalavra = strlen(palavra);
    int contagem = 0;

    for (int i = 0; i <= tamanhoConteudo - tamanhoPalavra; i++) {
        bool encontrada = true;
        for (int j = 0; j < tamanhoPalavra; j++) {
            if (tolower(conteudo[i + j]) != tolower(palavra[j])) { //Compara letra por letra com todo o conteúdo
                encontrada = false;
                break;
            }
        }
        // Verifique se a palavra foi encontrada e se a próxima posição é um espaço ou fim do arquivo
        if (encontrada && (i + tamanhoPalavra == tamanhoConteudo || isspace(conteudo[i + tamanhoPalavra]))) {
            contagem++; // Incrementa a contagem de ocorrências
        }
    }
    return contagem; 
}

int main() {
    char caracter;
    FILE *txt;
    char conteudo[410000];
    int tamanho = 0;
    int contA = 0;
    int direito =0;
    int dever = 0;
    int deveres = 0;

    // Abre o arquivo para leitura
    if ((txt = fopen("arquivo_texto.txt", "r")) == NULL) {
        printf("Erro ao abrir arquivo");
        return 1;
    } 

    // Lê o conteúdo do arquivo e armazena no vetor
    while ((caracter = fgetc(txt)) != EOF) {
        conteudo[tamanho++] = caracter; // Armazena o caractere no vetor conteudo e incrementa o tamanho

        if (caracter == 'a' || caracter == 'A') {
            contA++;
        }
    }

   

    // Busca pelas palavras
    direito = verificarPalavra(conteudo, "direito");
    dever = verificarPalavra(conteudo, "dever");
    deveres = verificarPalavra(conteudo, "deveres");

    fclose(txt);

    // Imprime o conteúdo do vetor de trás para frente
    printf("Conteúdo do arquivo invertido:\n");
    for (int i = tamanho - 1; i >= 0; i--) {
        printf("%c", conteudo[i]); // Imprime o caractere na posição i do vetor
    }
   
    printf("\nO numero de letras 'a' é: %d\n", contA);
    printf("O numero de vezes que a palavra - Direito - aparece: %d\n", direito);
    printf("O numero de vezes que a palavra - Dever   - aparece: %d\n", dever);
    printf("O numero de vezes que a palavra - Deveres - aparece: %d\n", deveres);

    return 0;
}
