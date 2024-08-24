package controladores;

import dominio.Aluno;
import dominio.Professor;
import dominio.Turma;
import repositorio.TurmaRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class TurmaControlador implements Controlador<Turma> {
    ProfessorControlador controladorProfessor = new ProfessorControlador();

    /**
     * Verifica se o professor e a turma já estão cadastrados.
     * Se o professor estiver cadastrado e a turma não, ela será cadastrada.
     * Caso contrario sera exibida as seguintes mensagens 'Professor não econtrado'
     * ou 'Turma já existe'.
     *
     * @param dados (nome do professor, nome da turma)
     */

    @Override
    public void cadastrar (List<String> dados){
        Professor professor = controladorProfessor.buscar(dados.get(0));
        TurmaRepo turmaRepo = TurmaRepo.getInstance();

        if(professor != null){
            if((buscar(dados.get(1)) == null)) {
                turmaRepo.salvar(new Turma(dados.get(1), professor));
                listar();
            }else {
                System.out.println("Turma já existe!");
            }
        }
    }

    @Override
    public void listar(){
        TurmaRepo turmaRepo = TurmaRepo.getInstance();
        System.out.println(turmaRepo.buscarTodos());
    }

    @Override
    public Turma buscar(String nome){
        try{
            TurmaRepo turmaRepo = TurmaRepo.getInstance();
            return turmaRepo.buscarTurmaPorNome(nome);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public void adicionarAluno(List<String> dados) {
        TurmaRepo turmaRepo = TurmaRepo.getInstance();
        turmaRepo.adicionarAlunoATurma(dados.get(0), dados.get(1));
        System.out.println("Aluno adicionado à turma");
    }

    public void adicionarTarefa(List<String> dados) {
        TurmaRepo turmaRepo = TurmaRepo.getInstance();
        turmaRepo.adicionarTarefaATurma(dados.get(0), dados.get(1));
        System.out.println("Tarefa adicionada à turma");
    }


}
