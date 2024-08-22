package controladores;

import dominio.Premio;
import repositorio.AlunoRepo;
import repositorio.PremioRepo;
import repositorio.ProfessorRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class PremioControlador implements Controlador<Premio> {

    @Override
    public void cadastrar(List<String> dados) {
        PremioRepo premioRepo = PremioRepo.getInstance();
        premioRepo.salvar(new Premio(dados.get(0), Integer.parseInt(dados.get(1))));
    }

    @Override
    public void listar() {
        PremioRepo premioRepo = PremioRepo.getInstance();
        System.out.println(premioRepo.buscarTodos());
    }

    @Override
    public Premio buscar(String nome) {
        try {
            PremioRepo premioRepo = PremioRepo.getInstance();
            return premioRepo.buscarPontuacao(nome);
        } catch (NoSuchElementException e) {
            System.out.print("Premio não encontrado");
            return null;
        }
    }
}
