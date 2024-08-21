package repositorio;

import dominio.Aluno;
import dominio.Professor;
import java.util.List;
import java.util.stream.Collectors;


public class ProfessorRepo extends AbstractRepo<Professor> {

    private final static ProfessorRepo INSTANCE = new ProfessorRepo();

    public static ProfessorRepo getInstance() {
        return INSTANCE;
    }

    public Professor buscarPorNome(String nome){
        return data.stream().filter(c -> c.getUsername().equals(nome)).findAny().get();
    }

}
