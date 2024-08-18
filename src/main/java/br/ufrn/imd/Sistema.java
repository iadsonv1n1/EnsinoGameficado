package br.ufrn.imd;

import java.util.*;
import java.util.stream.Stream;

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

    public void executar(String opcao){
        if(opcao.equals("1")){
            cadastrarProfessor(separarDados(lerLinha()));
        } else if(opcao.equals("2")) {
            cadastrarTurma(separarDados(lerLinha()));
        } else if(opcao.equals("4")) {
            //cadastrarAluno(separarDados(lerLinha()));
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
        if(professorExiste(dados.get(1))){
            System.out.println("PROFESSOR JÁ CADASTRADO!");
        }else {
            this.professores.add(new Professor(dados.get(0), dados.get(1)));
        }
    }

    public boolean professorExiste(String email){
        return  professores.stream().anyMatch(p -> p.getEmail().equals(email));
    }

    public Professor pegarProfessor(String email){
        return professores.stream().filter(p -> p.getEmail().equals(email)).findAny().get();
    }

    public void cadastrarTurma(List<String> dados) {
        if (turmaExiste(dados.get(0), dados.get(1))) {
            System.out.println("Turma já existe ou Professor não está cadastrado");
        } else {
            Professor professor = pegarProfessor(dados.get(0));
            professor.setTurmas(dados.get(1));
        }

    }

    public boolean turmaExiste(String emailProfessor, String nomeTurma){
        boolean verificador = false;
        if(professorExiste(emailProfessor)){
           Professor professor = pegarProfessor(emailProfessor);
           verificador = professor.turmas.stream().anyMatch(t->t.getNome().equals(nomeTurma));
        }
        return verificador;
    }
    /*** params Email + Turma + NomeDoAluno ***/
//    public void cadastrarAluno(List<String> dados) {
//        String email = dados.get(0); // Email do prof
//        Aluno aluno = new Aluno(dados.get(2)); // Nome do aluno
//        for (Professor p : professores) {
//            if (email.equals(p.getEmail())) {
//               for (Turma t : p.turmas ) {
//                   if (t.alunos.contains(aluno) ) {
//                       System.out.println("Aluno já existe na turma");
//                   } else {
//                       t.alunos.add(aluno);
//                   }
//               }
//            } else {
//                System.out.println("Professor não correspondente");
//            }
//        }
//    }

}
