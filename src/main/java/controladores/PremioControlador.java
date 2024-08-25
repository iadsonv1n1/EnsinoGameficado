package controladores;

import dominio.Premio;
import repositorio.PremioRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class PremioControlador implements Controlador<Premio> {
    PremioRepo premioRepo = PremioRepo.getInstance();
    @Override
    public void cadastrar(List<String> dados) throws IndexOutOfBoundsException {
        premioRepo.salvar(new Premio(dados.get(0), Integer.parseInt(dados.get(1))));
    }

    @Override
    public void listar() {
        System.out.println(premioRepo.buscarTodos());
    }

    @Override
    public Premio buscar(String titulo) {
        try {
            return premioRepo.buscarPremioPorNome(titulo);
        } catch (NoSuchElementException e) {
            System.out.print("Premio não encontrado");
            return null;
        }
    }
}
