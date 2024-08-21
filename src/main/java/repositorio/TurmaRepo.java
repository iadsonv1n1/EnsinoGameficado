package repositorio;

import dominio.Turma;

public class TurmaRepo extends AbstractRepo<Turma>{
    private final static TurmaRepo TURMA_REPO = new TurmaRepo();

    public static TurmaRepo getInstance(){
        return TURMA_REPO;
    }

    public TurmaRepo() {}

    public Turma buscarTurmaPorNome(String nome){
        return dados.stream().filter(t -> t.getNome().equals(nome)).findAny().get();
    }
}
