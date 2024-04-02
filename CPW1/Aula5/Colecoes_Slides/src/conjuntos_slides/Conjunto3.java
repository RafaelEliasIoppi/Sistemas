package conjuntos_slides;
import java.util.*;

public class Conjunto3 {

    public static void main(String[] args) {
        Set<String> cidades = new TreeSet<>();
        cidades.add("Porto Alegre");
        cidades.add("Canoas");
        cidades.add("Alvorada");
        cidades.add("Viamão");
        for (String cidade : cidades) {
            System.out.println(cidade);
        }
        //ou cidades.forEach(cidade -> System.out.println(cidade));
    }
}
