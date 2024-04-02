/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas_slides;

import java.util.*;

public class Lista1{
     public static void main(String args[]){
           // cria uma lista no formato de um vetor 
           // ser usar number pode usar qualquer tipo de numero
           List<Number> lista = new ArrayList<>();
           // adiciona elementos na lista
            lista.add(10); 
            lista.add(20); 
            lista.add(20L);// long
            lista.add(20.5F);//float
            lista.add(30.0);//double
            lista.add(10);
            
            for(Number obj: lista) {
                    System.out.println(obj);
            }
            System.out.println("Retorna o indice da primeira ocorrencia do objeto 30.0 => " + lista.indexOf(30.0) + " posicao"); //retorna o indice da primeira ocorrencia do objeto
            System.out.println("Retorna o indice da ultima ocorrencia do objeto 10 => " + lista.lastIndexOf(10) + " posicao"); 
            System.out.println("Retorna o tamanho da lista => " + lista.size());
            //remove o valor 20F da coleção
            lista.remove(20F);
           // remove o valor da posição 0
            lista.remove(0);
            
            
           


     }      
     //int - Integer
     //char - Character
     //float - Float
     
}
