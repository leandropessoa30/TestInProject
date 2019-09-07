package cadastros;

public class Filmes {

    private String nome;

    private String anoLancamento;

    private String login;

    public Filmes() {

    }

    public String getNome() {
        return nome;
    }

    public String getAnoLancamento(){
        return anoLancamento;
    }

    public void setNome(String name) {

        nome = name;
    }

    public void setAnoLancamento(String ano) {
        anoLancamento = ano;
    }
}