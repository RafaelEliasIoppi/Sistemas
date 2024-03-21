import java.util.Scanner;

package br.edu.ifrs.pw1.menu;

public class Menu2 {
    public static void main(String[] args) {
        String aux = "";
        for (Menu item : Menu.values()) {
            aux += item.getOpcao() + " - " + item.getDescricao() + "\n";
        }
        System.out.println(aux);
        
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        
        // Add your code here to handle the selected option
        
        scanner.close();
    }
}
