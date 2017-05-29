
//package ProjetoLP2;

import java.util.Scanner;

public class Fachada {
    public void metodo1(){
        Scanner t = new Scanner (System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Escolha a opcao!\n"
                    + "1: Menu de contole de estoque\n"
                    + "2: Menu de contole de vendas\n"
                    + "3: Menu de clientes\n" 
                    + "0: Sair\n");


            byte var1 = t.nextByte();
            switch (var1){
                case 1:
                    Menu1();
                    flag = false;
                    break;
                case 2:
                   Menu2();
                   flag = false;
                   break;
                case 3:
                    Menu3();
                    flag = false;
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Redigite a opcao!");
            }
        }
    }

    private static void Menu1() {
        Scanner t = new Scanner (System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Produto\n"
                    + "2: Buscar Produto\n"
                    + "3: Excluir Produto\n"
                    + "4: Listar Produtos\n"
                    + "0: Sair\n");


            byte var2 = t.nextByte();
            switch (var2){
                case 1:
                    
                    
            }
            
        }    
    }

    private static void Menu2() {
        //Contole de vendas: Classe vender e cliente 
        Scanner t = new Scanner (System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Produto\n"
                    + "2: Buscar Produto\n"
                    + "3: Excluir Produto\n"
                    + "4: Listar Produtos\n"
                    + "0: Sair\n");


            byte var2 = t.nextByte();
            switch (var2){
                case 1:
                    
                    
            }
            
        }
    }

    private static void Menu3(){
        //menu de clientes
        Scanner t = new Scanner (System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Cliente\n"
                    + "2: Listar Clientes\n"
                    + "3: Excluir Clientes\n"
                    + "4: Buscar Clientes/n"
                    + "5: Receber Valores do Cliente"
                    + "0: Sair\n");


            byte var2 = t.nextByte();
            switch (var2){
                case 1:
                    
                    
            }
            
        }    
            
    }
    
}
