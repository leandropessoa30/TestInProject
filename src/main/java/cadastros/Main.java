package cadastros;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
//import buscagoogle.BuscaFilmesGoogle;

public class Main {

    private Scanner l;
    private boolean executeCadastroFilmes;
    private boolean executePrincipal;
    private List<Filmes> cadastroFilmes;
   // BuscaFilmesGoogle busca = new BuscaFilmesGoogle();


    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        l = new Scanner(System.in);
        executePrincipal = true;
        executeCadastroFilmes = true;
        cadastroFilmes = new ArrayList<Filmes>();

        System.out.println("*SISTEMA PARA CADASTRO DE FILMES***\n");
        while (executePrincipal) {
            String opcaoMenuPrincipal = menuPricipal();

            if (opcaoMenuPrincipal.equalsIgnoreCase("f")) {
                while (executeCadastroFilmes) {
                    String opcao = menuCadastroFilmes();

                    if (opcao.equalsIgnoreCase("n")) {
                        cadastrarFilme();
                    } else if (opcao.equalsIgnoreCase("l")) {
                        listarCadastrosFilmes();
                    } else if (opcao.equalsIgnoreCase("s")) {
                        executeCadastroFilmes = false;
                    } else {
                        System.out.println("\nOpção inválida!\n");
                    }
                }

            } else if (opcaoMenuPrincipal.equalsIgnoreCase("b")) {
                System.out.println("\nBusca de Filmes e Diretores no Google\n");
                System.out.println("\nSerá realizado uma busca de diretores e filmes cadastrados.\n");

            } else if (opcaoMenuPrincipal.equalsIgnoreCase("s")) {
                executePrincipal = false;

            } else {
                System.out.println("\nOpção inválida!\n");
            }
        }


    }


    private String menuPricipal() {
        System.out.println("Informe uma opção:");
        System.out.println("F - Cadastrar e listar Filmes");
        System.out.println("B - Buscar no goole resultados de diretor e filme");
        System.out.println("S - Sair");
        return l.nextLine();

    }

    private String menuCadastroFilmes() {
        System.out.println("Informe uma opção:");
        System.out.println("N - Adicionar novo filme ao cadastro");
        System.out.println("L - Listar filmes cadastrados");
        System.out.println("S - Sair");
        return l.nextLine();
    }

    private void cadastrarFilme() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Filmes");
            Filmes cad = new Filmes();

            cad.setNomeFilme(textInput("Nome do filme:"));
            cad.setAnoLancamento(textInput("Ano Lançamento: "));

            cad.setNomeDiretor(textInput("Nome do diretor:"));
            cad.setAnoNascimento(textInput("Ano Nascimento: "));

            String cadastrar = textInput("Deseja adicionar o filme ao cadastro (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Filme cadastrado!");
                cadastroFilmes.add(cad);
            } else if (cadastrar.equalsIgnoreCase("n")) {
                System.out.println("Cadastro cancelado !!!");
            } else {
                System.out.println("\nOpção inválida! \n");
            }

            String continua = textInput("Adicionar mais filmes? (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")) {
                // se for s sai do if e volta para o inicio do while
                cadastrando = true;
            } else {
                System.out.println("\nOpção inválida! \n");
                cadastrando = false;
            }
        }
    }

    private void listarCadastrosFilmes() {
        if (cadastroFilmes.size() == 0) {
            System.out.println("\nNão existem filmes cadastrados !!!\n");
        } else {
            System.out.println("\nLista de filmes cadastrados\n");
            for (int i = 0; i < cadastroFilmes.size(); i++) {
                Filmes cad = cadastroFilmes.get(i);
                System.out.println("Filme número: " + i);
                System.out.println("\tNome do Filme: " + cad.getNomeFilme());
                System.out.println("\tAno de Lançamento: " + cad.getAnoLancamento());
                System.out.println("\tNome do Diretor: " + cad.getNomeDiretor());
                System.out.println("\tAno de Nascimento: " + cad.getAnoNascimento());
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return l.nextLine();
    }
}
