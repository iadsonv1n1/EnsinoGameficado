package repositorio;

import dominio.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoRepo extends AbstractRepo<Aluno> {

    private final static AlunoRepo INSTANCE = new AlunoRepo();

    public static AlunoRepo getInstance() {
        return INSTANCE;
    }

    public Aluno buscarPorNome(String nome){
        return data.stream().filter(c -> c.getUsername().equals(nome)).findAny().get();
    }


}
