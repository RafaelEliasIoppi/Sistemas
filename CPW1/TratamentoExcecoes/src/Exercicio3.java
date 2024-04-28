public class Exercicio3 {
    public static void main(String[] args) {
        try {
            int i = (int) Math.random();
            System.out.println("Valor de i: " + i); // Imprime o valor de i
            int j = 10 / i;
            System.out.println(j);
        } catch (ArithmeticException e) {
            System.out.println("Divisão por zero");
        }
    }
}
