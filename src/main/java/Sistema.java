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

    public void mostraMenu() {
        System.out.println( "1- Cadastrar Professor \n"+
                            "2- Cadastrar Aluno \n"+
                            "3- Adicionar Turma \n"+
                            "4- Adicionar Tarefa \n"+
                            "5- Adicionar Aluno à Turma \n"+
                            "6- Adicionar Tarefa à Turma \n"+
                            "7- Adicionar Premio \n" +
                            "8- Adicionar Premio à Tarefa \n"+
                            "9- BuscarTodos");
    }

    /**
     * Recebe a opção que o usuario escolhe e a executa;
     * @param opcao
     */

    public void executar(String opcao) {
        try {
            if (opcao.equals("1")) {
                professorControl.cadastrar(separarDados(lerLinha()));
            } else if (opcao.equals("2")) {
                alunoControl.cadastrar(separarDados(lerLinha()));
            } else if (opcao.equals("3")) {
                turmaControl.cadastrar(separarDados(lerLinha()));
            } else if (opcao.equals("4")) {
                tarefaControl.cadastrar(separarDados(lerLinha()));
            } else if (opcao.equals("5")) {
                turmaControl.adicionarAluno(separarDados(lerLinha()));
            } else if (opcao.equals("6")) {
                turmaControl.adicionarTarefa(separarDados(lerLinha()));
            } else if (opcao.equals("9")) {
                turmaControl.adicionarPremio(separarDados(lerLinha()));
            } else if (opcao.equals("sair")) {
                fecharSistema(opcao);
            }
        }catch (IndexOutOfBoundsException  | NumberFormatException e){
            System.out.println("FORMATO DE DADOS INVÁLIDO!");
        }
    }

    /**
     * Faz a leitura da linha contendo os dados para executar
     * a ação escolhida pelo usuario
     * @return a linha com todos os dados do usuario;
     */
    public String lerLinha(){
        Scanner ler = new Scanner(System.in);
        String linha = ler.nextLine();

        return linha;
    }

    /**
     * Separa os dados informados pelo usuario por usando como
     * referencia para separar ';' e um espaço.
     *
     * @param linha (String)
     * exemplo: <blockquote><pre>
     * "iadson; silva"
     * </pre></blockquote>
     *
     * @return List

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
