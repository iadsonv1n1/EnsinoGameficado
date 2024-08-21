package repositorio;

import dominio.Professor;


public class ProfessorRepo extends AbstractRepo<Professor> {

    private final static ProfessorRepo INSTANCE = new ProfessorRepo();

    public static ProfessorRepo getInstance() {
        return INSTANCE;
    }

    public Professor buscarPorNome(String nome){
        return dados.stream().filter(c -> c.getUsername().equals(nome)).findAny().get();
    }

}
