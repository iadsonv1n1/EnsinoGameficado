package repositorio;

import dominio.Professor;


public class ProfessorRepo extends TurmaRepo {

    private final static ProfessorRepo PROFESSOR_REPO = new ProfessorRepo();

    public static ProfessorRepo getInstance() {
        return PROFESSOR_REPO;
    }

    public Professor buscarProfessorPorNome(String nome){
        return dados.stream().filter(c -> c.getNome().equalsIgnoreCase(nome)).findAny().get();
    }

}
