public enum Menu {
    CAD(1, "Cadastrar"),
    LISt(2, "Listar"),
    SAIR(3, "Sair");


private int opcao;
private String descricao;

private Menu(int opcao, String descricao) {
    this.opcao = opcao;
    this.descricao = descricao;
}

public int getOpcao() {
    return opcao;
    

}
public String getDescricao() {
    return descricao;
}
}
