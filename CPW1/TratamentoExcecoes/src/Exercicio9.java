public class Exercicio9 {
    public static class Objeto { // Make the Objeto class static
        private String nome;
    
        public Objeto(String nome) {
            this.nome = nome;
        }
    
        public String getNome() {
            return nome;
        }
    }
    
    public static Objeto criaObjeto() { 
        // lógica para criar um objeto
        return new Objeto("Rafael"); // supondo que você tenha uma lógica real aqui
    }

    public static void main(String[] args) {
        try {
            Object obj = criaObjeto();
            if (obj != null) {
                System.out.println(obj.toString());
            } else {
                System.out.println("O objeto retornado é nulo.");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

   
}
