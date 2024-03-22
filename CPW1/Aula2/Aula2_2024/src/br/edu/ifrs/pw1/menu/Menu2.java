package br.edu.ifrs.pw1.menu;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifrs.pw1.clientes.ClientePessoaFisica;
import br.edu.ifrs.pw1.contatos.Endereco;
import br.edu.ifrs.pw1.documentos.Cpf; 

public class Menu2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<ClientePessoaFisica> clientes = new ArrayList<>();
        while (true) {
            switch (montaMenu()) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.next();
                    System.out.print("Digite seu telefone: ");
                    String telefone = scanner.next();
                    System.out.println("Informe o CPF");
                    long numCpf = scanner.nextLong();
                    System.out.println("Informe o digito do CPF");
                    int digCpf = scanner.nextInt();
                    Cpf cpf = new Cpf(numCpf, digCpf);
                    System.out.print("Informe o número de endereços: ");
                    int numEnderecos = scanner.nextInt();
                    ArrayList<Endereco> enderecos = new ArrayList<>();
                    for (int i = 0; i < numEnderecos; i++) {
                        System.out.print("Informe o logradouro: ");
                        String logradouro = scanner.next();
                        System.out.print("Informe o complemento: ");
                        String complemento = scanner.next();
                        System.out.print("Informe o CEP: ");
                        long cep = scanner.nextLong();
                        Endereco endereco = new Endereco(logradouro, complemento, cep);
                        enderecos.add(endereco);
                    }
                    ClientePessoaFisica clienteCad = new ClientePessoaFisica(telefone, enderecos, nome, cpf);

                    clientes.add(clienteCad);
                    break;

                case 2:
                    for (ClientePessoaFisica cli : clientes) {
                        System.out.println(cli.getNome());
                        System.out.println(cli.getCpf());
                        System.out.println(cli.getTelefone());
                        System.out.println(cli.getEnderecos());
                    }
                    break;
                case 3:
                    System.out.println("Sair");
                    scanner.close(); // Fechar o Scanner antes de sair do programa
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        }
    }

    private static int montaMenu() {
        String menu = "1-Cadastrar Cliente Pessoa Física\n" +
                      "2-Listar Clientes\n" +
                     "3-Sair\n";
        //converte de string para int
        System.out.println(menu);
       Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
        return opcao;
    }
}
