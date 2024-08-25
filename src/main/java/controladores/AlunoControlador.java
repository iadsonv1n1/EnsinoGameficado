package controladores;

import dominio.Aluno;
import repositorio.AlunoRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class AlunoControlador implements Controlador<Aluno> {
    AlunoRepo alunoRepo = AlunoRepo.getInstance();

    @Override
    public void cadastrar(List<String> dados) throws IndexOutOfBoundsException{
        alunoRepo.salvar(new Aluno(dados.get(0), dados.get(1)));
        System.out.println("Aluno salvo!");
    }
    @Override
    public void listar() {
        System.out.println(alunoRepo.buscarTodos());
    }

    @Override
    public Aluno buscar (String nome) {
        try {
            return alunoRepo.buscarPorNome(nome);
        } catch (NoSuchElementException e) {
            System.out.print("Aluno não encontrado");
            return null;
        }
    }

}
