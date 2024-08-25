package dominio;

import java.util.Objects;

public record Tarefa(String titulo, String descricao, int pontos) {
    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public String descricao() {
        return descricao;
    }

    @Override
    public int pontos() {
        return pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(titulo, tarefa.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
