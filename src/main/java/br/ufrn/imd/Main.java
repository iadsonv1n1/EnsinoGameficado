package br.ufrn.imd;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner teclado = new Scanner(System.in);

        sistema.mostraMenu();

        String opcao = "";
        do{
            try {
                opcao = teclado.nextLine();
                sistema.verificarOpcao(opcao);

            }catch (Exception e){
                System.out.println("DEU ERROOOOOOO!");
            }

        }while(!sistema.fecharSistema(opcao));
        teclado.close();
    }
}