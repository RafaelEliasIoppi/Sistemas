public class Testes {
    public static void main(String[] args) {
        // Criando uma instância da MinhaListaGenerica
        MinhaListaGenerica lista = new MinhaListaGenerica();

        // Testando os métodos
        lista.adicionar("Primeiro");
        lista.adicionar("Segundo");
        lista.adicionar("Terceiro");

        System.out.println("Lista após adicionar elementos: " + lista.listar());
        System.out.println("Total de elementos na lista: " + lista.totalizar());

        System.out.println("Primeiro elemento da lista: " + lista.pegarPrimeiroElemento());
        System.out.println("Último elemento da lista: " + lista.pegarUltimoElemento());

        try {
            System.out.println("Elemento na posição 1: " + lista.pegarElemento(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fora dos limites da lista.");
        }

        lista.removerElementoPosicao(1);
        System.out.println("Lista após remover elemento na posição 1: " + lista.listar());

        lista.removerTodos();
        System.out.println("Lista após remover todos os elementos: " + lista.listar());
        System.out.println("Total de elementos na lista após remover todos: " + lista.totalizar());
    }

}
