import dominio.Aluno;
import dominio.Professor;
import repositorio.AlunoRepo;
import repositorio.ProfessorRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class Controlador {

    public void cadastrarProfessor(List<String> strings) {
        ProfessorRepo professorRepo = ProfessorRepo.getInstance();
        professorRepo.salvar(new Professor(strings.get(0), strings.get(1)));
        System.out.println("Professor salvo!");
    }

    public void listarProfessores() {
        ProfessorRepo professorRepo = ProfessorRepo.getInstance();
        System.out.println(professorRepo.buscarTodos());
    }

    public Professor buscarProfessorPorNome(String strings) {
        try {
            ProfessorRepo professorRepo = ProfessorRepo.getInstance();
            return professorRepo.buscarPorNome(strings);
        } catch (NoSuchElementException e) {
            System.out.println("Professor não encontrado");
            return null;
        }
    }

    public void cadastrarAluno(List<String> strings) {
        AlunoRepo alunoRepo = AlunoRepo.getInstance();
        alunoRepo.salvar(new Aluno(strings.get(0), strings.get(1)));
    }

    public void listarAlunos() {
        AlunoRepo alunoRepo = AlunoRepo.getInstance();
        System.out.println(alunoRepo.buscarTodos());
    }

}
