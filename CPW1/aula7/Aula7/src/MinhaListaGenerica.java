import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MinhaListaGenerica implements ListaGen {
    private LinkedList<Object> lista;

    public MinhaListaGenerica() {
        lista = new LinkedList<>();
    }

    @Override
    public void adicionar(Object obj) {
        lista.add(obj);
    }

    @Override
    public Object remover() {
        return lista.poll(); // Remove e retorna o primeiro elemento da lista
    }

    @Override
    public String listar() {
        return lista.toString();
    }

    @Override
    public int totalizar() {
        return lista.size();
    }

    @Override
    public void removerTodos() {
        lista.clear();
    }

    @Override
    public boolean contemElemento(Object obj) {
        return lista.contains(obj);
    }

    @Override
    public Object pegarElemento(int i) throws IndexOutOfBoundsException {
        return lista.get(i);
    }

    @Override
    public Object pegarPrimeiroElemento() throws NoSuchElementException {
        return lista.getFirst();
    }

    @Override
    public Object pegarUltimoElemento() throws NoSuchElementException {
        return lista.getLast();
    }

    @Override
    public void removerElementoPosicao(int indice) throws IndexOutOfBoundsException {
        lista.remove(indice);
    }
}
