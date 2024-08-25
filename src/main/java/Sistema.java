import controladores.*;
import dominio.Premio;

import java.util.*;

public class Sistema{

    ProfessorControlador professorControl = new ProfessorControlador();
    AlunoControlador alunoControl = new AlunoControlador();
    TurmaControlador turmaControl = new TurmaControlador();
    TarefaControlador tarefaControl = new TarefaControlador();
    PremioControlador premioControl = new PremioControlador();


    public void mostraMenu() {
        System.out.println( "1- Cadastrar Professor \n"+
                            "Para cadastrar digite: NomeDoProfessor; Senha \n" +
                            "2- Cadastrar Aluno \n"+
                            "Para cadastrar digite: NomedoAluno; Senha \n" +
                            "3- Adicionar Turma \n"+
                            "Para cadastrar digite: NomeDoProfessor; NomeDaTurma \n" +
                            "4- Adicionar Tarefa \n"+
                            "Para cadastrar digite: TituloDaTarefa; Descricao; Pontos \n" +
                            "5- Adicionar Aluno à Turma \n"+
                            "Para cadastrar digite: NomeDaTurma; NomeDoAluno \n" +
                            "6- Adicionar Tarefa à Turma \n"+
                            "Para cadastrar digite: NomedaTurma; NomeDaTarefa \n" +
                            "7- Adicionar Premio \n" +
                            "Para cadastrar digite: Titulo; Pontos \n" +
                            "menu- Apresenta essa mensagem novamente \n" +
                            "sair- Fecha o sistema \n");

    }

    /**
     * Recebe a opção que o usuario escolhe e a executa;
     * @param opcao
     */

    public void executar(String opcao){
        try {
            if (opcao.equals("1")) {
                professorControl.cadastrar(separarDados(lerLinha()));
            } else if(opcao.equals("2")) {
                alunoControl.cadastrar(separarDados(lerLinha()));
            } else if(opcao.equals("3")) {
                turmaControl.cadastrar(separarDados(lerLinha()));
            } else if(opcao.equals("4")) {
                tarefaControl.cadastrar(separarDados(lerLinha()));
            } else if (opcao.equals("5")) {
                turmaControl.adicionarAluno(separarDados(lerLinha()));
            } else if (opcao.equals("6")) {
                turmaControl.adicionarTarefa(separarDados(lerLinha()));
            } else if (opcao.equals("7")) {
                turmaControl.adicionarPremio(separarDados(lerLinha()));
            } else if(opcao.equals("9")) {
                // Opção de teste
                professorControl.listar();
                alunoControl.listar();
                turmaControl.listar();
                tarefaControl.listar();
                premioControl.listar();
            } else if(opcao.equals("sair")){
                fecharSistema(opcao);
            } else if (opcao.equals("menu")) {
                mostraMenu();
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Comando Inválido!");
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
