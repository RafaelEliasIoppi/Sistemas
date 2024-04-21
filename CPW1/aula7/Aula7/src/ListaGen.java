import java.util.LinkedList;
import java.util.NoSuchElementException;

public interface ListaGen {
    void adicionar(Object obj);
    Object remover();
    String listar();
    int totalizar();
    void removerTodos();
    boolean contemElemento(Object obj);
    Object pegarElemento(int i) throws IndexOutOfBoundsException;
    Object pegarPrimeiroElemento() throws NoSuchElementException;
    Object pegarUltimoElemento() throws NoSuchElementException;
    void removerElementoPosicao(int indice) throws IndexOutOfBoundsException;
}


