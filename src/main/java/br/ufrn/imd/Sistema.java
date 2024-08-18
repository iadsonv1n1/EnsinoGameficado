package br.ufrn.imd;

import java.util.*;

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
        } else if(opcao.equals("4")) {
            cadastrarAluno(separarDados(lerLinha()));
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
        String email = dados.get(0);
        Turma turma = new Turma(dados.get(1));
        for (Professor p : professores) {
            if (email.equals(p.getEmail())) {
                p.setTurmas(turma);
            } else {
                System.out.println("Professor não correspondente");
            };
        }
    }

    /*** params Email + Turma + NomeDoAluno ***/
    public void cadastrarAluno(List<String> dados) {
        String email = dados.get(0); // Email do prof
        Aluno aluno = new Aluno(dados.get(2)); // Nome do aluno
        for (Professor p : professores) {
            if (email.equals(p.getEmail())) {
               for (Turma t : p.turmas ) {
                   if (t.alunos.contains(aluno) ) {
                       System.out.println("Aluno já existe na turma");
                   } else {
                       t.alunos.add(aluno);
                   }
               }
            } else {
                System.out.println("Professor não correspondente");
            };
        }
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
