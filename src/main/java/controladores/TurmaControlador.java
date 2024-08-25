package controladores;

import dominio.Professor;
import dominio.Tarefa;
import dominio.Turma;
import repositorio.TarefaRepo;
import repositorio.TurmaRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class TurmaControlador implements Controlador<Turma> {
    ProfessorControlador controladorProfessor = new ProfessorControlador();
    TurmaRepo turmaRepo = TurmaRepo.getInstance();

    /**
     * Verifica se o professor e a turma já estão cadastrados.
     * Se o professor estiver cadastrado e a turma não, ela será cadastrada.
     * Caso contrario será exibida as seguintes mensagens 'Professor não econtrado'
     * ou 'Turma já existe'.
     *
     * @param dados (nome do professor, nome da turma)
     */
    @Override
    public void cadastrar (List<String> dados) throws IndexOutOfBoundsException {
        Professor professor = controladorProfessor.buscar(dados.get(0));
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
        System.out.println(turmaRepo.buscarTodos());
    }

    @Override
    public Turma buscar(String nome){
        try{
            return turmaRepo.buscarTurmaPorNome(nome);
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     *
     * @param dados (Turma: nome, Aluno: nome)
     */
    public void adicionarAluno(List<String> dados) {
        try {
            turmaRepo.adicionarAlunoATurma(dados.get(0), dados.get(1));
            System.out.println("Aluno adicionado à turma");

        }catch (NoSuchElementException e){
            System.out.println("TURMA NÃO ENCONTRADA!");
        }
    }

    /**
     *
     * @param dados (Turma: nome, Tarefa: titulo)
     */
    public void adicionarTarefa(List<String> dados) {
        try {
            turmaRepo.adicionarTarefaATurma(dados.get(0), dados.get(1));
            System.out.println("Tarefa adicionada à turma");

        }catch (NoSuchElementException e){
            System.out.println("TAREFA NÃO ENCONTRADA!");
        }
    }

    public void adicionarPremio(List<String> dados) {
        try {
            turmaRepo.adicionarPremioATurma(dados.get(0), dados.get(1));
            System.out.println("Premio adicionado a turma");

        }catch (NoSuchElementException e){
            System.out.println("PREMIO NÃO ENCONTRADA!");
        }
    }


}
