package ProjetoLP2;

import java.util.Scanner;

public class Fachada {
    Loja loja = new Loja();
    public void metodo1(){
        Scanner t = new Scanner (System.in);
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Menu de contole de estoque\n"
                    + "2: Menu de contole de vendas\n"
                    + "3: Menu de clientes\n" 
                    + "0: Sair\n");


            String var1 = t.next();
            if (var1.equals("1") == 0){
                Menu1();
                break;
            }else if (var1.equals("2") == 0){
                Menu2();
                break;
            }else if(var1.equals("3") == 0){
                Menu3();
                break;
            }else if (var1.equals("0") == 0)
                break;
            }else{
                System.out.println("Redigite a opção!")
            }
        }
    }

    private static void Menu1() {
        Scanner t = new Scanner (System.in);
        // boolean flag = true;
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Produto\n"
                    + "2: Buscar Produto\n"
                    + "3: Excluir Produto\n"
                    + "4: Listar Produtos\n"
                    + "0: Sair\n");


            String var2 = t.next();
            if (var2.equals("1") == 0){
                break;
            }else if (var2.equals("2") == 0){
                break;
            }else if(var2.equals("3") == 0){
                break;
            }else if (var2.equals("0") == 0)
                break;
            }else if (var2.equals("4") == 0){
                break;
            }else{
                System.out.println("Redigite a opção!")
            }
            
        }    
    }

    private static void Menu2() {
        //Contole de vendas: Classe vender e cliente 
        Scanner t = new Scanner (System.in);
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Produto\n"
                    + "2: Buscar Produto\n"
                    + "3: Excluir Produto\n"
                    + "4: Listar Produtos\n"
                    + "0: Sair\n");
            String var3 = t.next();
            if (var3.equals("1") == 0){
                break;
            }else if (var3.equals("2") == 0){
                break;
            }else if(var3.equals("3") == 0){
                break;
            }else if (var3.equals("0") == 0)
                break;
            }else if (var3.equals("4") == 0){
                break;
            }else{
                System.out.println("Redigite a opção!")
            }
            
        }
    }

    private static void Menu3(){
        //menu de clientes
        Scanner t = new Scanner (System.in);

        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Cliente\n"
                    + "2: Listar Clientes\n"
                    + "3: Excluir Clientes\n"
                    + "4: Buscar Clientes/n"
                    + "5: Receber Valores do Cliente"
                    + "0: Sair\n");


            String var4 = t.next();
            if (var3.equals("1") == 0){
                break;
            }else if (var3.equals("2") == 0){
                break;
            }else if(var3.equals("3") == 0){
                break;
            }else if (var3.equals("0") == 0)
                break;
            }else if (var3.equals("4") == 0){
                break;
            }else{
                System.out.println("Redigite a opção!")
            }
            
        }    
            
    }
    
}
