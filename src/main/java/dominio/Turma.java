package dominio;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
/** - A turma possui um condigo Aleatorio de 4 digitos;
    - A turma possui um Professor para identificar de quem é a turma;
 */
public class Turma {
    private int codigo;
    private String nome;
    private Professor professor;
    public List<Tarefa> tarefas = new LinkedList<>();
    public List<Aluno> alunos = new LinkedList<>();
    public List<Premio> premios = new LinkedList<>();

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

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void adicionarPremio(Premio premio) {
        premios.add(premio);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo + '\'' +
                ", professor=" + professor +  '\'' +
                ", tarefas=" + tarefas +  '\'' +
                ", alunos=" + alunos + '}';
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
