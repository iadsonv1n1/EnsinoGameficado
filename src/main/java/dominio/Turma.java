package dominio;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Turma {
    private int codigo;
    private String nome;
    private Professor professor;

    public Turma (String nome, Professor professor){
        this.nome = nome;
        this.codigo = geradorDeCodigo();
        this.professor = professor;
    }

    public int geradorDeCodigo (){
        return ThreadLocalRandom.current().nextInt(1000,9999);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Turma turma = (Turma) o;

        if (codigo != turma.codigo) return false;
        return Objects.equals(nome, turma.nome);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + codigo;
        return result;
    }

}
