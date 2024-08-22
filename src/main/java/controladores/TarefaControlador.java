package controladores;

import dominio.Tarefa;
import repositorio.TarefaRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class TarefaControlador implements Controlador<Tarefa> {
    TarefaRepo tarefaRepo = TarefaRepo.getInstance();
    @Override
    public void cadastrar(List<String> dados) {
        tarefaRepo.salvar(new Tarefa(dados.get(0), dados.get(1), Integer.parseInt(dados.get(2))));
        System.out.println("Tarefa Cadastrada!");
    }

    @Override
    public void listar() {
        System.out.println(tarefaRepo.buscarTodos());
    }

    @Override
    public Tarefa buscar(String titulo) {
        try{
            return tarefaRepo.buscarTarefaPorNome(titulo);
        }catch (NoSuchElementException e){
            System.out.println("Tarefa não encontrada");
            return null;
        }
    }
}
