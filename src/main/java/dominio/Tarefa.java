package dominio;

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
}
