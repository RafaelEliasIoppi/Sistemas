
import javax.swing.JOptionPane;
import java.awt.Menu;

public class testes {
  

    public static void main(String[] args) {
        String aux = "";
        for(Menu item : Menu.values()){
            aux += item.getOpcao()  + " - " + item.getDescricao() + "\n";
        }
    }
}
