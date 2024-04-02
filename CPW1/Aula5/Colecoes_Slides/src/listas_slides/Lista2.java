/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas_slides;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lista2{
     public static void main(String args[]){
            // cria uma lista duplamente encadeada
            LinkedList<Number> numeros = new LinkedList<>();
            // adiciona elementos na lista
            numeros.add(10); // int
            numeros.add(20.8); //double
            numeros.add(30L); //long    
            numeros.add(23.5F); //float
            numeros.removeFirst(); //remove o primeiro elemento (10)
            numeros.removeLast(); //remove o ultimo elemento (23.5)
            numeros.remove(); //remove o primeiro elemento da lista

            for (Number num: numeros) {
                System.out.println(num);
            }
            //outra forma de percorrer uma lista é usando o padrão de projeto Iterator igual ao for acima
            Iterator<Number> iter = numeros.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
            //Imprimi o telefone na posição 3
            System.out.println( "Posicao 3 =>" + numeros.get(3));
     }
}

