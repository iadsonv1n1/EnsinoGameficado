package repositorio;

import controladores.TurmaControlador;
import dominio.Aluno;
import dominio.Premio;
import dominio.Tarefa;
import dominio.Turma;

import java.util.NoSuchElementException;

public class TurmaRepo extends AbstractRepo<Turma>{
    private final static TurmaRepo TURMA_REPO = new TurmaRepo();

    public static TurmaRepo getInstance(){
        return TURMA_REPO;
    }

    public TurmaRepo() {}

    public Turma buscarTurmaPorNome(String nome){
        return dados.stream().filter(t -> t.getNome().equalsIgnoreCase(nome)).findAny().get();
    }

    public void adicionarAlunoATurma(String turma, String aluno) {

        Turma essa = buscarTurmaPorNome(turma);
        Aluno nome = AlunoRepo.getInstance().buscarPorNome(aluno);
        essa.adicionarAluno(nome);

    }

    public void adicionarTarefaATurma(String turma, String tarefa) {
        Turma essa = buscarTurmaPorNome(turma);
        Tarefa nome = TarefaRepo.getInstance().buscarTarefaPorNome(tarefa);
        essa.adicionarTarefa(nome);
    }

    public void adicionarPremioATurma(String turma, String tiutloDoPremio) {
        Turma essa = buscarTurmaPorNome(turma);
        Premio premio = PremioRepo.getInstance().buscarPremioPorNome(tiutloDoPremio);
        essa.adicionarPremio(premio);
    }
}
