package br.ufrn.imd;

public class Turma {
    private int codigo;
    private String nome;

    Turma(String nome){
        this.nome = nome;
        this.codigo = geradorDeCodigoAleatorio();
    }

    public int geradorDeCodigoAleatorio(){
        int range = (1000 - 9999) +1;
        int numeroAleatorio = (int) ((range * Math.random()) + 1000);

        return numeroAleatorio;
    }

    public String getNome() {
        return this.nome;
    }
    public int getCode() {
        return this.codigo;
    }

    // Está com erro, não consegue achar o professor....
    public String getProfessor() {
        return Professor.getEmail();
    }
}
