/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas_slides;

import java.util.*;

public class Lista1{
     public static void main(String args[]){
            List<Integer> lista = new ArrayList<>();
            lista.add(10); 
            lista.add(20); 
            
            for(Integer obj: lista) {
                    System.out.println(obj);
            }
            System.out.println(lista.indexOf(20));
     }
     //int - Integer
     //char - Character
     //float - Float
     
}
