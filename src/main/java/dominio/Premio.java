package dominio;

public record Premio(String nome, int pontos) {

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontos;
    }

}
