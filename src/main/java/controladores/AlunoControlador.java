package controladores;

import dominio.Aluno;
import repositorio.AlunoRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class AlunoControlador implements Controlador<Aluno> {

    @Override
    public void cadastrar(List<String> dados) {
        AlunoRepo alunoRepo = AlunoRepo.getInstance();
        alunoRepo.salvar(new Aluno(dados.get(0), dados.get(1)));
        System.out.println("Aluno salvo!");
    }
    @Override
    public void listar() {
        AlunoRepo alunoRepo = AlunoRepo.getInstance();
        System.out.println(alunoRepo.buscarTodos());
    }

    @Override
    public Aluno buscar (String nome) {
        try {
            AlunoRepo alunoRepo = AlunoRepo.getInstance();
            return alunoRepo.buscarPorNome(nome);
        } catch (NoSuchElementException e) {
            System.out.print("Aluno não encontrado");
            return null;
        }
    }

}
