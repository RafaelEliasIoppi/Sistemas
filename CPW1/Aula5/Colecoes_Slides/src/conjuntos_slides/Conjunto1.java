package conjuntos_slides;

import java.util.*;

public class Conjunto1 {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();
        // nao permite elemento duplicado
        conjunto.add("Dois");
        conjunto.add("Tres");
        conjunto.add("Um");
        conjunto.add("Um");
        //numero de elementos do conjunto
        System.out.println("Numero de elementos: " + conjunto.size());
        for (String num : conjunto) {
            System.out.println(num);
        }
    }
}
