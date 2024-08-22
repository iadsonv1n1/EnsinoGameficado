package repositorio;

import dominio.Tarefa;

public class TarefaRepo extends AbstractRepo<Tarefa> {
    private final static TarefaRepo TAREFA_REPO = new TarefaRepo();

    public static TarefaRepo getInstance(){
        return TAREFA_REPO;
    }

    public Tarefa buscarTarefaPorNome(String titulo){
        return dados.stream().filter(t -> t.titulo().equals(titulo)).findAny().get();
    }
}
