package br.ufrn.imd;

import java.util.List;

public class Turma {
    private int codigo;
    private String nome;
    public List<Aluno> alunos;
    //public List<Tarefa> tarefas;
    //public List<Premio> premios;

    Turma(String nome){
        this.nome = nome;
        this.codigo = geradorDeCodigoAleatorio();
    }

    public int geradorDeCodigoAleatorio(){
        int range = (9999 - 1000) + 1;
        int numeroAleatorio = (int) ((range * Math.random()) + 1000);
        return numeroAleatorio;
    }

    public String getNome() {
        return this.nome;
    }
    public int getCode() {
        return this.codigo;
    }

}
