import java.util.ArrayList;
import java.util.List;

public class MexicanWave {
    public static String wave(String s) {
        // Inicializa uma string vazia para construir a string resultante
        String result = "";

        // Itera através de cada caractere da string
        for (int i = 0; i < s.length(); i++) {
            // Se o caractere for um espaço em branco, pula para o próximo caractere
            if (Character.isWhitespace(s.charAt(i))) {
                continue;
            }
            // Capitaliza o caractere atual e o concatena com o restante da string
            String wave = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
            // Adiciona a string modificada à string resultante, seguida por uma vírgula e um espaço
            result += wave + ", ";
        }

        // Remove a última vírgula e espaço adicionados ao final
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2);
        }

        return result;
    }

    public static void main(String[] args) {
        // Teste da função wave
        String input = "rafael";
        String output = wave(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
