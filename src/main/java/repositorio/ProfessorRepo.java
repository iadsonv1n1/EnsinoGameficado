package repositorio;

import dominio.Professor;


public class ProfessorRepo extends AbstractRepo<Professor> {

    private final static ProfessorRepo PROFESSOR_REPO = new ProfessorRepo();

    public static ProfessorRepo getInstance() {
        return PROFESSOR_REPO;
    }

    public Professor buscarProfessorPorNome(String nome){
        return dados.stream().filter(c -> c.getNome().equals(nome)).findAny().get();
    }

}
