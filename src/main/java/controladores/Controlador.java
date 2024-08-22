package controladores;

import dominio.Aluno;

import java.util.List;

public interface Controlador<T> {

    void cadastrar(List<String> String);

    void listar();

     T buscar(String nome);

}
