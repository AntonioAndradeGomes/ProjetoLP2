package ProjetoLP2;
import java.text.ParseException;
import java.util.Scanner;

public class Fachada {
    Loja loja = new Loja();
    
    public void metodo1() throws ParseException{
        Scanner t = new Scanner (System.in);
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Menu de contole de estoque\n"
                    + "2: Menu de contole de vendas\n"
                    + "3: Menu de clientes\n"
                    + "4: Valores adiquiridos pela loja\n"
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
                System.out.printf("R$ %.2f\n", loja.getMontanteMensal());
                metodo1();
                break;
            }else if (var1.equals("0")){
                break;
            }else{
               System.out.println("Redigite a opção!");
            }
            }
        }



    private void Menu1() throws ParseException{
        Scanner t = new Scanner (System.in);
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Produto\n"
                    + "2: Buscar Produto\n"
                    + "3: Excluir Produto\n"
                    + "4: Listar Produtos\n"
                    + "5: Listar Compras do cliente\n" //Jonathas
                    + "0: Sair\n");


            String var2 = t.next();
            if (var2.equals("1")){
                adicionarProduto();
                Menu1();
                break;
            }else if (var2.equals("2")){
                buscarProduto();
                Menu1();
                break;
            }else if(var2.equals("3")){
                Excluirproduto();
                Menu1();
                break;
            }else if (var2.equals("4")){
                loja.getEstoque().ListarProdutos();
                Menu1();
                break;
            }else if(var2.equals("5")){
                ListarComprasCliente();
                Menu1();
                break;
            }else{
                metodo1();
                break;
            }    
        }
    }
    public void Excluirproduto(){
        if(loja.getEstoque().getProdutos().size() > 0){
            Scanner t = new Scanner(System.in);
            System.out.println("Digite o codigo do produto que deseja-se excluir do estoque");
            String code = t.nextLine();
            loja.getEstoque().ExcluirProduto(code);
        }else{
            System.out.println("Não existe produto no estoque");
        }
    }
    public void ListarComprasCliente(){
        if (loja.getCadastrocliente().size() > 0){
            Scanner t = new Scanner(System.in);
            System.out.println("Digite o CPF do cliente");
            String cpf = t.nextLine();
            loja.ListarVendasCliente(cpf);
        }else{
            System.out.println("Não existe cliente cadastrado");
        }    
    }

    private void Menu2() throws ParseException {
        //Contole de vendas: Classe vender e cliente 
        //Jonathas...
        Scanner t = new Scanner (System.in);
        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Vender Produtos à dinheiro\n"//jonathas
                    + "2: Vender Produtos á cadastro do cliente\n"//jonathas
                    + "0: Sair\n");
            String var3 = t.next();
            if (var3.equals("1")){
                vender();
                Menu2();
                break;
            }else if (var3.equals("2")){
                vendercliente();
                Menu2();
                break;
            }else if (var3.equals("0")){
                metodo1();
                break;
            }
        }
    }
    public void vender() throws ParseException{
        if (loja.getEstoque().getProdutos().size() > 0){
            loja.getEstoque().ListarProdutos();
            Scanner t = new Scanner(System.in);
            System.out.println("Digite o código do produto");
            String codigo = t.nextLine();
            try{
                System.out.println("Digite a quantidade desejada");
                long unidade = Long.parseLong(t.nextLine());
                loja.getVenda().vender(codigo, unidade, loja);
            }catch(NumberFormatException erro){
                System.out.println("Dado inválido, tente novamente");
                vender();
            }    
        }else{
            System.out.println("Não existe produtos no estoque para vender");
        }    
    }
    public void vendercliente() throws ParseException{
        if (loja.getEstoque().getProdutos().size() > 0){
            loja.getEstoque().ListarProdutos();
            Scanner t = new Scanner(System.in);
            System.out.println("Digite o CPF do cliente");
            String cpf = t.nextLine();
            System.out.println("Digite o código do produto");
            String codigo = t.nextLine();
            try{
                System.out.println("Digite a quantidade desejada");
                long unidade = Long.parseLong(t.nextLine());
                loja.getVenda().venderCliente(cpf, codigo, unidade, loja);
            }catch(NumberFormatException erro){
                System.out.println("Dado inválido, tente novamente");
                vendercliente();
            }
        }else{
            System.out.println("Não existe produtos no estoque para vender");
        }    
    }
    private void Menu3() throws ParseException{
        //menu de clientes
        Scanner t = new Scanner (System.in);

        while (true){
            System.out.println("Escolha a opcao!\n"
                    + "1: Adicionar Cliente\n"
                    + "2: Listar Clientes\n"
                    + "3: Excluir Clientes\n" 
                    + "4: Buscar Clientes\n"
                    + "5: Receber pagamento do Cliente\n" //Jonathas pagar a divida
                    + "0: Sair\n");


            String var4 = t.next();

            if (var4.equals("1")){

                adicionarCliente();
                Menu3();
                break;
            }else if (var4.equals("2")){
                loja.ListarCliente();
                Menu3();
                break;
            }else if(var4.equals("3")){
                System.out.println("Digite o cpf do cliente");
                String cpf = t.nextLine();
                loja.Excluircliente(cpf);
                Menu3();
                break;
            }else if (var4.equals("0")){
                metodo1();
                break;
            }else if (var4.equals("4")){
                buscarCliente();
                Menu3();
                break;
            }else if (var4.equals("5")){
                PagarDivida();
                Menu3();
                break;
            }else{
               System.out.println("Redigite a opção!");
            }
            
        }    
            
    }
    public void PagarDivida(){
        if(loja.getCadastrocliente().size() > 0){
            Scanner t = new Scanner(System.in);
            System.out.println("Digite o CPF do cliente");
            String cpf = t.nextLine();
            try{
                System.out.println("Digite o valor a pagar");
                double valor = Double.parseDouble(t.nextLine());
                loja.Pagardivida(cpf, valor, loja);
            }catch(NumberFormatException erro){
                System.out.println("Dado inválido, tente novamente");
                PagarDivida();
            }
        }else{
            System.out.println("Não existe clientes cadastrados");
        }
    }

    private void buscarProduto() throws ParseException {
        Scanner t = new Scanner (System.in);
        System.out.println("Digite a opção desejada!\n"
                + "1: Buscar pelo nome\n"
                + "2: Buscar pelo codigo do produto\n"
                + "0: Sair");
        String var = t.nextLine();
        if (var.equals("1")){
            if(loja.getEstoque().getProdutos().size() > 0){
                System.out.println("Digite o nome do produto!");
                String var2 = t.nextLine();
                loja.getEstoque().BuscarProdutoNome(var2);
            }else{
                System.out.println("Não existe produtos no estoque");
            }
        }else if (var.equals("2")){
            if(loja.getEstoque().getProdutos().size() > 0){
                System.out.println("Digite o codigo do produto!");
                String var2 = t.nextLine();
                loja.getEstoque().BuscarProdutoCodigo(var2);
            }else{
                System.out.println("Não existe produtos no estoque");
            }
        }else if(var.equals("0")){
            Menu1();
        }else{
            System.out.println("Opção invalida!");
            buscarProduto();
        }
    }
    private void buscarCliente() throws ParseException{
        if(loja.getCadastrocliente().size() > 0){
            Scanner t = new Scanner (System.in);
            System.out.println("Digite a opção desejada!\n"
                    + "1: Buscar pelo nome do cliente\n"
                    + "2: Buscar pelo cpf do cliente\n"
                    + "0: Sair");
            String var = t.nextLine();
            if (var.equals("1")){
                System.out.println("Digite o nome do cliente!");
                String var2 = t.nextLine();
                loja.BuscarClienteNome(var2);
                Menu3();
            }else if (var.equals("2")){
                System.out.println("Digite o CPF do cliente!");
                String var2 = t.nextLine();
                loja.BuscarClienteCpf(var2);
                Menu3();            
            }else if(var.equals("0")){
                Menu1();
            }else{
                System.out.println("Opção invalida!");
                buscarCliente();
            }
        }else{
            System.out.println("Não existe clientes cadastrados");
        }    
    }

    private void adicionarProduto() throws ParseException {
        try{
            Scanner t = new Scanner (System.in);
            System.out.println("Dê um codigo para o produto");
            String code = t.nextLine();
            boolean verifica = false; // verificar se existe produto.
            for (int i = 0; i<loja.getEstoque().getProdutos().size(); i++){
                if (loja.getEstoque().getProdutos().get(i).getCodigo().equals(code)){
                    verifica = true; // verificar se há produto no estoque para listar.
                    break; // Quando achar pelo menos um produto.
                }
            }
            if (verifica == false){
                System.out.println("Digite o nome do produto");
                String nome = t.nextLine();
                System.out.println("Digite o preço unitario do produto");
                double preco = Double.parseDouble(t.nextLine());
                System.out.println("Unidades do produto");
                long unidade = Long.parseLong(t.nextLine());
                System.out.println("Validade do produto (dia/mes/ano com as /)");
                String validade = t.nextLine();
                Produto p = new Produto (nome, preco, validade, code, unidade, loja);
            }else{
                System.out.println("Existe um produto com o mesmo código, tente novamente");
                adicionarProduto(); //Famosa recursão.
            }
        }catch(Throwable e){
            System.out.println("Erro de algum dado tente novamente");
            adicionarProduto();
        }
    }

    private void adicionarCliente() {
        Scanner t = new Scanner (System.in);    
        System.out.println("Digite nome do cliente");
        String nome = t.nextLine();
        System.out.println("Digite o cpf do cliente");
        String cpf = t.nextLine();
        boolean verifica = false;
        for (int i = 0; i < loja.getCadastrocliente().size(); i++){
            if (loja.getCadastrocliente().get(i).getCpf().equals(cpf)){
                verifica = true;
                break;
            }
        }    
        if (verifica == true){
            System.out.println("Existe um cliente cadastrado na loja com este CPF");
        }else{
            Cliente c = new Cliente (nome, cpf, loja);
            System.out.println("Cliente adicionado com sucesso");
        }
    }
    
}
 