public class Telefone {
    int prefixo;
    int numero;


    public Telefone() {
        this.prefixo = 0;
        this.numero = 0;
    }
    public Telefone(int prefixo, int numero) {
        this.prefixo = prefixo;
        this.numero = numero;
    }

    public int getPrefixo() {
        return prefixo;
    }
    public void setPrefixo(int prefixo) {
        this.prefixo = prefixo;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return "Telefone: (" + prefixo + ")" + numero;
    }
}
