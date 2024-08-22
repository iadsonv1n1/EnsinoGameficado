import controladores.AlunoControlador;
import controladores.ProfessorControlador;
import controladores.TarefaControlador;
import controladores.TurmaControlador;

import java.util.*;

public class Sistema{

    ProfessorControlador professorControl = new ProfessorControlador();
    AlunoControlador alunoControl = new AlunoControlador();
    TurmaControlador turmaControl = new TurmaControlador();
    TarefaControlador tarefaControl = new TarefaControlador();

    public void mostraMenu(){
        System.out.println( "1- Cadastrar Professor \n"+
                            "2- Cadastrar Aluno \n"+
                            "3- Adicionar Turma \n"+
                            "4- Adicionar Tarefa \n"+
                            "5- Adicionar Aluno \n"+
                            "6- Adicionar Premio \n" +
                            "7- BuscarTodos");
    }

    /**
     * Recebe a opção que o usuario escolhe e a executa;
     * @param opcao
     */

    public void executar(String opcao){
        if (opcao.equals("1")) {
            professorControl.cadastrar(separarDados(lerLinha()));
        } else if(opcao.equals("2")) {
            alunoControl.cadastrar(separarDados(lerLinha()));
        } else if(opcao.equals("3")) {
            turmaControl.cadastrar(separarDados(lerLinha()));
        } else if(opcao.equals("4")){
            tarefaControl.cadastrar(separarDados(lerLinha()));
        }else if(opcao.equals("7")) {
            System.out.println(tarefaControl.buscar(lerLinha()));
            //testes
//            professorControl.listar();
//            alunoControl.listar();
//            turmaControl.listar();
//            tarefaControl.listar();
        }
        else if(opcao.equals("sair")){
            fecharSistema(opcao);
        }
    }

    /**
     * Faz a leitura de linha contendo os dados para executar
     * a ação escolhida pelo usuario
     * ex:1(opcao escolhida)
     * andre; silva1235
     *
     * @return a linha com todos os dados do usuario;
     */
    public String lerLinha(){
        Scanner ler = new Scanner(System.in);
        String linha = ler.nextLine();

        return linha;
    }

    /**
     * Separa os dados informados pelo usuario
     * @param linha
     * @return lista com os dados separados
     */
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
