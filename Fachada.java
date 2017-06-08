package ProjetoLP2;
import java.util.Scanner;

//import java.text.ParseException;
//
//
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Fachada {
    Loja loja = new Loja();
    
    public void metodo1(){
        Scanner t = new Scanner (System.in);
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Menu de contole de estoque\n"
                    + "2: Menu de contole de vendas\n"
                    + "3: Menu de clientes\n"
                    + "4: Valores adiquiridos pela loja"
                    + "0: Sair\n");


            String var1 = t.next();
            if (var1.equals("1")){
                Menu1();
                break;
            }else if(var1.equals("2")){
                Menu2();
                break;
            }else if (var1.equals("2")){
                Menu2();
                break;
            }else if(var1.equals("3")){
                Menu3();
                break;
            }else if (var1.equals("4")){
                System.out.println(loja.getMontanteMensal());
                break;
            }else if (var1.equals("0")){
                break;
            }else{
               System.out.println("Redigite a opção!");
            }
            }
        }



    private void Menu1(){
        Scanner t = new Scanner (System.in);
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Produto\n"
                    + "2: Buscar Produto\n"
                    + "3: Excluir Produto\n"
                    + "4: Listar Produtos\n"
                    + "0: Sair\n");


            String var2 = t.next();
            if (var2.equals("1")){
                System.out.println("Digite nome do produto, preço, data de validade, codigo e suas unidades adiquidridas");
                String nome = t.nextLine(); double preco = t.nextDouble(); 
                String validade = t.nextLine(); String code = t.nextLine(); long unidade = t.nextLong();
//                try {
//                    Produto p = new Produto(nome, preco, validade, code, unidade);
//                } catch (ParseException ex) {
//                    Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }else if (var2.equals("2")){
                buscarProduto();
                break;
            }else if(var2.equals("3")){
                System.out.println("Digite o codigo do produto que deseja-se excluir do estoque");
                String code = t.nextLine();
                loja.getEstoque().ExcluirProduto(code);
                break;
            }else if (var2.equals("4")){
                loja.getEstoque().ListarProdutos();
                break;
            }else{
                metodo1();
                break;
            }    
        }
    }
    

    private void Menu2() {
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
            if (var3.equals("1")){
                break;
            }else if (var3.equals("2")){
                break;
            }else if(var3.equals("3")){
                break;
            }else if (var3.equals("0")){
                metodo1();
                break;
        
            }else if (var3.equals("4")){
                break;
            }
        }
    }

    private void Menu3(){
        //menu de clientes
        Scanner t = new Scanner (System.in);

        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Cliente\n"
                    + "2: Listar Clientes\n"
                    + "3: Excluir Clientes\n" //falta fazer o codigo que exclui o cliente
                    + "4: Buscar Clientes/n"
                    + "5: Receber Valores do Cliente\n"
                    + "0: Sair\n");


            String var4 = t.next();

            if (var4.equals("1")){
                break;
            }else if (var4.equals("2")){
                loja.ListarCliente();
                break;
            }else if(var4.equals("3")){
                break;
            }else if (var4.equals("0")){
                metodo1();
                break;
            }else if (var4.equals("4")){
                buscarCliente();
                break;
            }else if (var4.equals("5")){
//                System.out.println("Digite o valor!");
//                try{
//                    double valor = t.nextDouble();
//                    
//                    break;
//                }catch(Throwable e){
//                    System.out.println("Valor Digitado Errado!");
//                    Menu3();
//                }
                break;
            }else{
               System.out.println("Redigite a opção!");
            }
            
        }    
            
    }

    private void buscarProduto() {
        Scanner t = new Scanner (System.in);
        System.out.println("Digite a opção desejada!\n"
                + "1: Buscar pelo nome\n"
                + "2: Buscar pelo codigo do produto\n"
                + "0: Sair");
        String var = t.next();
        if (var.equals("1")){
            System.out.println("Digite o nome do produto!");
            String var2 = t.nextLine();
            loja.getEstoque().BuscarProdutoNome(var2);
            Menu1();
        }else if (var.equals("2")){
            System.out.println("Digite o codigo do produto!");
            String var2 = t.nextLine();
            loja.getEstoque().BuscarProdutoCodigo(var2);
            Menu1();            
        }else if(var.equals("0")){
            Menu1();
        }else{
            System.out.println("Opção invalida!");
            buscarProduto();
        }
    }
    private void buscarCliente(){
        
    }
    
}
 