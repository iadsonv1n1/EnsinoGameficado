package br.ufrn.imd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static br.ufrn.imd.Banco.adicionarTurma;

public class Sistema{
    public List<Professor> professores = new ArrayList<>();

    public boolean fecharSistema(String sair){
        if(sair.equalsIgnoreCase("sair")){
            return true;
        } else {
            return false;
        }
    }
    public void mostraMenu(){
        System.out.println( "1- Cadastrar-se \n"+
                            "2- Adicionar Turma \n"+
                            "3- Adicionar Tarefa \n"+
                            "4- Adicionar Aluno \n"+
                            "5- Adicionar Premio \n" +
                            "6- Menu");
    }

    public void verificarOpcao(String opcao){
        if(opcao.equals("1")){
            cadastrarProfessor(separarDados(lerLinha()));
        } else if(opcao.equals("2")) {
            cadastrarTurma(separarDados(lerLinha()));
        } else if(opcao.equals("sair")){
            fecharSistema(opcao);
        }
    }

    public String lerLinha(){
        Scanner ler = new Scanner(System.in);
        String linha = ler.nextLine();

        return linha;
    }

    public List<String> separarDados(String linha){
        List<String> dadosSeparados = List.of(linha.split(";\\s"));
        return dadosSeparados;
    }

    public void cadastrarProfessor(List<String> dados){
        Professor professor = new Professor(dados.get(0), dados.get(1));

        if(professorExiste(professor)){
            System.out.println("PROFESSOR JÁ CADASTRADO!");
        }else {
            this.professores.add(professor);
            Banco.adicionarProfessor(professor);
        }
    }

    public void cadastrarTurma(List<String> dados) {
        Banco.procurarProfessor(dados.get(0))
                .thenAccept(email -> {
                    if (email != null && !email.isEmpty()) {
                        Turma turma = new Turma(email, dados.get(1));
                        Banco.adicionarTurma(turma);
                    } else {
                        System.out.println("Professor não encontrado.");
                    }
                })
                .exceptionally(ex -> {
                    System.err.println("Erro ao buscar professor: " + ex.getMessage());
                    return null;
                });
    }

    public boolean professorExiste(Professor professor){
        boolean verificador = false;
        for(Professor p: professores){
            if(professor.equals(p)){
                verificador = true;
                break;
            }
        }
        return verificador;
    }

}
