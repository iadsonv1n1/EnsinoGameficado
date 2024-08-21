import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner teclado = new Scanner(System.in);

        sistema.mostraMenu();

        String opcao = "";
        do{
                opcao = teclado.nextLine();
                sistema.executar(opcao);

        }while(!sistema.fecharSistema(opcao));
        teclado.close();
    }
}