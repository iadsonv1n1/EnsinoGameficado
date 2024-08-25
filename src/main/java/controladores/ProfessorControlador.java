package controladores;

import dominio.Professor;
import repositorio.ProfessorRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class ProfessorControlador implements Controlador<Professor> {
    ProfessorRepo professorRepo = ProfessorRepo.getInstance();

    @Override
    public void cadastrar(List<String> dados) throws IndexOutOfBoundsException {
        professorRepo.salvar(new Professor(dados.get(0), dados.get(1)));
        System.out.println("Professor salvo!");
    }

    @Override
    public void listar() {
        System.out.println(professorRepo.buscarTodos());
    }

    @Override
    public Professor buscar(String nome) {
        try {
            return professorRepo.buscarProfessorPorNome(nome);
        } catch (NoSuchElementException e) {
            System.out.print("Professor não encontrado");
            return null;
        }
    }

}
