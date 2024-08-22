package repositorio;

import dominio.Aluno;

public class AlunoRepo extends AbstractRepo<Aluno> {

    private final static AlunoRepo INSTANCE = new AlunoRepo();

    public static AlunoRepo getInstance() {
        return INSTANCE;
    }

    public Aluno buscarPorNome(String nome){
        return dados.stream().filter(c -> c.getNome().equals(nome)).findAny().get();
    }

}
