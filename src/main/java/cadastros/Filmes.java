package cadastros;

public class Filmes {

    private String nomeFilme;
    private String nomeDiretor;
    private String anoLancamento;
    private String anoNascimento;


    public Filmes() {
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setNomeFilme(String nameFilme) {
        nomeFilme = nameFilme;
    }

    public void setNomeDiretor(String nameDiretor) {
        nomeDiretor = nameDiretor;
    }

    public void setAnoLancamento(String ano) {
        anoLancamento = ano;
    }

    public void setAnoNascimento(String ano) {
        anoNascimento = ano;
    }
}