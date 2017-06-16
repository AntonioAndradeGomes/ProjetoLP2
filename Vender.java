package ProjetoLP2;
import java.text.ParseException;
public class Vender{
    private static Vender singleton;
    
    private Vender(){}
    public static synchronized Vender getInstance(){
        if (singleton == null){
            singleton = new Vender();
        }
        return singleton;
    }
    public int indexVenda(String codigo, Loja b){ //Utilizado para pegar o index do produto vendido
        for (int i = 0; i < b.getVendas().size(); i++){
            if (codigo.equals(b.getVendas().get(i).getCodigo())){
                return i;
            }    
        }
        return -1;
    }
    
    public void vender(String codigo, long quantidade, Loja b) throws ParseException{
        boolean verifica = false; // Variavel criada para verificar possibilidades.
        boolean verifica2 = false;
        for (int i = 0; i < b.getEstoque().getProdutos().size(); i++){
            if (b.getEstoque().getProdutos().get(i).getCodigo().equals(codigo)){
                long qtd = b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade; // Quantidade do estoque menos as unidades compradas
                verifica = true;
                if (qtd > 0){
                    b.getVendas().add(b.getEstoque().getProdutos().get(i)); //Adicionando produto as vendas.
                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(qtd); //Alterando a quantidade do produto.
                    int index = indexVenda(codigo, b); // Pegando posição do produto.
                    b.getVendas().get(index).setUnidadesAdiquiridas(quantidade); //Alterando para quantidades vendidas.
                    verifica2 = true;
                    double preco = b.getVendas().get(index).getPreco() * b.getVendas().get(index).getUnidadesAdiquiridas(); // Preço do produto.
                    b.setMontanteMensal(b.getMontanteMensal() + preco);
                }else if (qtd == 0){ // Se as unidades menos a quantidade forem igual a zero, ou seja, acabou o produto.
                    b.getVendas().add(b.getEstoque().getProdutos().get(i)); //Adicionando produto as vendas
                    int index = indexVenda(codigo, b); // Pegando posição do produto.
                    b.getVendas().get(index).setUnidadesAdiquiridas(quantidade); //Alterando a quantidade do produto.
                    b.getEstoque().getProdutos().remove(i); //Removendo o produto
                    verifica2 = true;
                    double preco = b.getVendas().get(index).getPreco() * b.getVendas().get(index).getUnidadesAdiquiridas(); // Preço do produto.
                    b.setMontanteMensal(b.getMontanteMensal() + preco);
                }
            }
        }
        //Central de Verificações.
        if (verifica == false){
            System.out.println("Código errado.");
        }else if(verifica == true && verifica2 == true){
            System.out.println("Compra realizada com Sucesso.");
        }else if(verifica == true && verifica2 == false){
            System.out.println("Não foi possivel realizar a compra.");
        }
    }
    public int indexVendaCliente(String cpf, Loja b){ //Pegar index certo do cliente
        for (int i = 0; i < b.getCadastrocliente().size(); i++){
            if (cpf.equals(b.getCadastrocliente().get(i).getCpf())){
                return i;
            }    
        }
        return -1;
    }
    public int indexVendadocliente(String cpf, String codigo, Loja b){ // Adicionado cpf para buscar cliente certo em compras
        for (int i = 0; i < b.getCadastrocliente().get(indexVendaCliente(cpf,b)).getCompras().size(); i++){
            if (codigo.equals(b.getCadastrocliente().get(indexVendaCliente(cpf,b)).getCompras().get(i).getCodigo())){
                return i;
            }    
        }
        return -1;
    }
    
    public void venderCliente(String cpf, String codigo, long quantidade, Loja b) throws ParseException{
        boolean verifica = false; // Variavel criada para verificar possibilidades.
        boolean verifica2 = false;
        for (int i = 0; i < b.getEstoque().getProdutos().size(); i++){
            if (b.getEstoque().getProdutos().get(i).getCodigo().equals(codigo)){
                long qtd = b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade; // Quantidade do estoque menos as unidades compradas
                verifica = true;
                if (qtd > 0){
                    int index = indexVendaCliente(cpf, b); // Pegando posição do cliente.
                    //System.out.println(index);
                    //System.out.println(b.getCadastrocliente().get(index).getNome());
                    b.getCadastrocliente().get(index).getCompras().add(b.getEstoque().getProdutos().get(i)); //Adicionando produto as vendas.
                    int index2 = indexVendadocliente(cpf, codigo, b); // Pegando a posição do produto.
                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(qtd); //Alterando a quantidade do produto.
                    b.getCadastrocliente().get(index).getCompras().get(index2).setUnidadesAdiquiridas(quantidade); //Alterando para quantidades vendidas.
                    verifica2 = true;
                    double preco = b.getCadastrocliente().get(index).getCompras().get(index2).getPreco() * b.getCadastrocliente().get(index).getCompras().get(index2).getUnidadesAdiquiridas(); // Preço do produto.
                    b.getCadastrocliente().get(index).setDivida(b.getCadastrocliente().get(index).getDivida() + preco); //Adicionando dívida ao cliente.
                }else if (qtd == 0){ // Se as unidades menos a quantidade forem igual a zero, ou seja, acabou o produto.
                    int index = indexVendaCliente(cpf, b); // Pegando posição do cliente.
                    b.getCadastrocliente().get(index).getCompras().add(b.getEstoque().getProdutos().get(i)); //Adicionando produto as vendas
                    int index2 = indexVendadocliente(cpf, codigo, b); // Pegando a posição do produto.
                    b.getCadastrocliente().get(index).getCompras().get(index2).setUnidadesAdiquiridas(quantidade); //Alterando a quantidade do produto.
                    b.getEstoque().getProdutos().remove(i); //Removendo o produto
                    verifica2 = true;
                    double preco = b.getCadastrocliente().get(index).getCompras().get(index2).getPreco() * b.getCadastrocliente().get(index).getCompras().get(index2).getUnidadesAdiquiridas(); // Preço do produto.
                    b.getCadastrocliente().get(index).setDivida(b.getCadastrocliente().get(index).getDivida() + preco); //Adicionando dívida ao cliente.
                }
            }
        }
        //Central de Verificações.
        if (verifica == false){
            System.out.println("Código ou CPF errado.");
        }else if(verifica == true && verifica2 == true){
            System.out.println("Compra realizada com Sucesso.");
        }else if(verifica == true && verifica2 == false){
            System.out.println("Não foi possivel realizar a compra.");
        }
    }
}