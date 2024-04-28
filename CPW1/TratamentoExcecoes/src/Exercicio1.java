public class Exercicio1 {

    public static void main(String[] args) {
        Telefone telefones[] = new Telefone[5];
        telefones[0] = new Telefone();
        telefones[2] = new Telefone(51, 55667788);

        for (int i = 0; i < telefones.length; i++) {
            try {
                if (telefones[i] != null) {
                    System.out.println( telefones[i].toString());
                } else {
                    System.out.println("Erro: O telefone na posição " + i + " é nulo.");
                }
            } catch (NullPointerException e) {
                System.out.println("Erro: Ocorreu uma exceção ao processar o telefone na posição " + i + ".");
            }
        }
      }
       
    }
