package dominio;

import java.util.Objects;

public record Professor(String nome, String senha) {

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Professor\n" +
                "nome='" + nome + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(nome, professor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
