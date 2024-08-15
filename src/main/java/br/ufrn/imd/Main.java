package br.ufrn.imd;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner teclado = new Scanner(System.in);

        Banco banco = new Banco();
        banco.inicializarBanco();

        sistema.mostraMenu();

        String opcao = "";
        do{
                opcao = teclado.nextLine();
                sistema.verificarOpcao(opcao);

        }while(!sistema.fecharSistema(opcao));
        teclado.close();
    }
}