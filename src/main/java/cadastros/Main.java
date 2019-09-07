package cadastros;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private Scanner l;
    private boolean executeCadastroFilmes;
    private boolean executeCadastroDiretor;
    private boolean executePrincipal;
    private List<Filmes> cadastroFilmes;
    private List<Diretores> cadastroDiretor;

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        l = new Scanner(System.in);
        executePrincipal = true;
        executeCadastroDiretor = true;
        executeCadastroFilmes = true;
        cadastroFilmes = new ArrayList<Filmes>();
        //cadastroDiretor = new ArrayList<ListaDiretor>();

        System.out.println("*SISTEMA PARA CADASTRO DE FILMES E DIRETORES***\n");
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
            } else if (opcaoMenuPrincipal.equalsIgnoreCase("d")) {
                while (executeCadastroDiretor) {
                    String opcao = menuCadastroDiretor();

                    if (opcao.equalsIgnoreCase("n")) {
                        cadastrarDiretor();
                    } else if (opcao.equalsIgnoreCase("l")) {
                        listarCadastrosDiretores();
                    } else if (opcao.equalsIgnoreCase("s")) {
                        executeCadastroFilmes = false;
                    } else {
                        System.out.println("\nOpção inválida!\n");
                    }
                }

            } else if (opcaoMenuPrincipal.equalsIgnoreCase("s")) {
                executePrincipal = false;

            } else {
                System.out.println("\nOpção inválida!\n");
            }


        }


    }

    private String menuPricipal() {
        System.out.println("Informe uma opção:");
        System.out.println("F - Cadastrar Filmes");
        System.out.println("D - Cadastrar Diretor");
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

    private String menuCadastroDiretor() {
        System.out.println("Informe uma opção:");
        System.out.println("N - Adicionar novo diretor ao cadastro");
        System.out.println("L - Listar diretores cadastros");
        System.out.println("S - Sair");
        return l.nextLine();
    }

    private void cadastrarFilme() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Filmes");
            Filmes cad = new Filmes();
            cad.setNome(textInput("Nome do filme:"));
            cad.setAnoLancamento(textInput("Ano Lançamento: "));

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
                System.out.println("\tNome: " + cad.getNome());
                System.out.println("\tAno de Lançamento: " + cad.getAnoLancamento());
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private void cadastrarDiretor() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Diretores");
            Diretores cad = new Diretores();
            cad.setNome(textInput("Nome do Diretor:"));
            cad.setAnoNascimeento(textInput("Ano de Nascimento: "));

            String cadastrar = textInput("Deseja adicionar o diretor ao cadastro (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Diretor cadastrado!");
                cadastroDiretor.add(cad);
            } else if (cadastrar.equalsIgnoreCase("n")) {
                System.out.println("Cadastro cancelado !!!");
            } else {
                System.out.println("\nOpção inválida! \n");
            }

            String continua = textInput("Adicionar mais diretores? (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\nOpção inválida! \n");
                cadastrando = false;
            }
        }
    }

    private void listarCadastrosDiretores() {
        if (cadastroDiretor.size() == 0) {
            System.out.println("\nNão existem diretores cadastrados !!!\n");
        } else {
            System.out.println("\nLista de diretores cadastrados\n");
            for (int i = 0; i < cadastroDiretor.size(); i++) {
                Diretores cad = cadastroDiretor.get(i);
                System.out.println("Filme número: " + i);
                System.out.println("\tNome: " + cad.getNome());
                System.out.println("\tAno de Nascimento: " + cad.getAnoNascimeento());
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return l.nextLine();
    }
}
