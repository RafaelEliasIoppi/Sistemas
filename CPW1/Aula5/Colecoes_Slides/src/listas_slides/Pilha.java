package listas_slides;

import java.util.LinkedList;

public class Pilha {
    public static void main(String[] args) {
        LinkedList<Integer> pilhaNumeros = new LinkedList<>();

        pilhaNumeros.push(3); // int
        pilhaNumeros.push(231); // int
        pilhaNumeros.push(33); // int
        pilhaNumeros.pop(); //remove o ultimo elemento (33)
        if(pilhaNumeros!= null){
            System.out.println(pilhaNumeros.size()>0?"Pilha não está vazia":"Pilha está vazia");
        }
    }
    //

}
