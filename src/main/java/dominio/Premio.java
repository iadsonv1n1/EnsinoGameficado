package dominio;

import java.util.Objects;

public record Premio(String nome, int pontos) {

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premio premio = (Premio) o;
        return Objects.equals(nome, premio.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Premio: " + nome + "\n" +
                "           Pontos necessarios: " + pontos + "\n";
    }
}
