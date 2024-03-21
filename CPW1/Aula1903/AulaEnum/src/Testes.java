
import javax.swing.JOptionPane;

public class Testes {
  

    public static void main(String[] args) {
        String aux = "";
        for(Menu item : Menu.values()) {
            aux += item.getOpcao()  + " - " + item.getDescricao() + "\n";
              }
              //javax.swing.JOptionPane.showMessageDialog(null, aux);
              System.out.println(aux);
            
              System.out.println("---------------------");
              for (Menu menu : Menu.values()) {
                  System.out.println (menu.getOpcao() + " - " + menu.getDescricao());
                  
              }
            }
   
}
