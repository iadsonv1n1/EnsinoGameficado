import controladores.AlunoControlador;
import controladores.ProfessorControlador;
import controladores.TurmaControlador;

import java.util.*;

public class Sistema{

    ProfessorControlador controlProf = new ProfessorControlador();
    AlunoControlador controlAluno = new AlunoControlador();

    TurmaControlador controlTurma = new TurmaControlador();

    public void mostraMenu(){
        System.out.println( "1- Cadastrar Professor \n"+
                            "2- Cadastrar Aluno \n"+
                            "3- Adicionar Turma \n"+
                            "4- Adicionar Tarefa \n"+
                            "5- Adicionar Aluno \n"+
                            "6- Adicionar Premio \n" +
                            "7- BuscarTodos");
    }

    public void executar(String opcao){
        if (opcao.equals("1")) {
            controlProf.cadastrar(separarDados(lerLinha()));
        } else if(opcao.equals("2")) {
            controlAluno.cadastrar(separarDados(lerLinha()));
        } else if(opcao.equals("3")) {
            controlTurma.cadastrar(separarDados(lerLinha()));
        } else if(opcao.equals("7")) {
            controlProf.listar();
            controlAluno.listar();
            controlTurma.listar();
        }
        else if(opcao.equals("sair")){
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

    public boolean fecharSistema(String sair){
        if(sair.equalsIgnoreCase("sair")){
            return true;
        } else {

            return false;
        }
    }

}
