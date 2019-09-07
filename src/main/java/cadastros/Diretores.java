package cadastros;

public class Diretores {
    private String nome;

    private String anoNascimeento;

    private String login;

    public Diretores() {

    }

    public String getNome() {
        return nome;
    }

    public String getAnoNascimeento(){
        return anoNascimeento;
    }

    public void setNome(String name) {

        nome = name;
    }

    public void setAnoNascimeento(String ano) {
        anoNascimeento = ano;
    }
}
