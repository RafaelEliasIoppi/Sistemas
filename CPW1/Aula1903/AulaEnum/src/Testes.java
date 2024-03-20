
import javax.swing.JOptionPane;

public class testes {
  

    public static void main(String[] args) {
        String aux = "";
        for(Menu item : Menu.values()) {
            aux += item.getOpcao()  + " - " + item.getDescricao() + "\n";
              }
              //javax.swing.JOptionPane.showMessageDialog(null, aux);
              System.out.println(aux);
    }
}
