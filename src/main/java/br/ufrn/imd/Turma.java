package br.ufrn.imd;

public class Turma {
    private int codigo;
    private String nome;
    private String professor;

    Turma(String professor, String nome){
        this.nome = nome;
        this.codigo = geradorDeCodigoAleatorio();
        this.professor = professor;
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

    // Está com erro, não consegue achar o professor....
    public String getProfessor() {
        return Professor.getEmail();
    }
}
