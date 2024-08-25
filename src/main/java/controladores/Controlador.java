package controladores;

import java.util.List;

public interface Controlador<T> {

    void cadastrar(List<String> dados);

    /**
     * lista todos os objetos do repositorio da classe
     */
    void listar();

     T buscar(String nome);

}
