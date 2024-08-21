import dominio.Aluno;
import dominio.Professor;
import dominio.Turma;
import repositorio.AlunoRepo;
import repositorio.ProfessorRepo;
import repositorio.TurmaRepo;

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
            System.out.print("Professor não encontrado");
            return null;
        }
    }
    public Turma buscarTurmaPorNome(String nome){
        try{
            TurmaRepo turmaRepo = TurmaRepo.getInstance();
            return turmaRepo.buscarTurmaPorNome(nome);
        }catch (NoSuchElementException e){
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


    public void cadastrarTurma (List<String> dados){
        Professor professor = buscarProfessorPorNome(dados.get(0));
        TurmaRepo turmaRepo = TurmaRepo.getInstance();

        if(professor != null){
            if((buscarTurmaPorNome(dados.get(1)) == null)) {
                turmaRepo.salvar(new Turma(dados.get(1), professor));
                listarTurmas();
            }else {
                System.out.println("Turma já existe!");
            }
        }
    }
    public void listarTurmas(){
        TurmaRepo turmaRepo = TurmaRepo.getInstance();
        System.out.println(turmaRepo.buscarTodos());
    }

}
