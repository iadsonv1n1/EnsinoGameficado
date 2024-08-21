import java.util.*;

public class Sistema{

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

}
