public class Exercicio2 {

        public static void main(String args[]) {
            int i = 5571;
            try {
                i = i / 0;
            } catch (ArithmeticException e) {
                System.out.println("Divisão por zero");
                return; // Encerra a execução do programa após a exceção
            }
            System.out.println("O resultado: " + i);
        }
        
}
