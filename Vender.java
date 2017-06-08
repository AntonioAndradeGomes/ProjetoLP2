package ProjetoLP2;
import java.text.ParseException;
public class Vender{
    Cliente cliente;
    
    public int indexVenda(String codigo, Loja b){
        for (int i = 0; i < b.getVendas().size(); i++){
            if (codigo.equals(b.getVendas().get(i).getCodigo())){
                return i;
            }    
        }
        return -1;
    }
    
    public void vender(String codigo, long quantidade, Loja b) throws ParseException{
        int verifica = 0; // Variavel criada para verificar possibilidades.
        for (int i = 0; i < b.getEstoque().getProdutos().size(); i++){
            if (b.getEstoque().getProdutos().get(i).getCodigo().equals(codigo)){
                long qtd = b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade; // Quantidade do estoque menos as unidades compradas
     
                if (qtd > 0){
                    b.getVendas().add(b.getEstoque().getProdutos().get(i));
                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(qtd);
                    int index = indexVenda(codigo, b); // Pegando posição do produto.
                    b.getVendas().get(index).setUnidadesAdiquiridas(quantidade);
                    
                    
                    
//                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(qtd); // Atualizando unidades vendidas.
//                    //===========Construindo Objeto para compra===========
//                    String nome = b.getEstoque().getProdutos().get(i).getNome();
//                    double preco = b.getEstoque().getProdutos().get(i).getPreco();
//                    String validade = b.getEstoque().getProdutos().get(i).getValidade2();
//                    Produto produto = new Produto(nome, preco, validade, codigo, quantidade); // Testes no sistema de vendas, finalmente consegui
//                    if (produto.isVerificavalidade() == true){
//                        b.getVendas().add(produto); // adiciona as unidades vendidas.
//                        verifica = 1;
//                    }else{
//                        verifica = 2;
                }else if (qtd == 0){ // Se as unidades menos a quantidade forem igual a zero, ou seja, acabou o produto.
                    
                    b.getVendas().add(b.getEstoque().getProdutos().get(i));
                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(qtd);
                    int index = indexVenda(codigo, b); // Pegando posição do produto.
                    b.getVendas().get(index).setUnidadesAdiquiridas(quantidade);

//                    //===========Construindo Objeto para compra===========
//                    String nome = b.getEstoque().getProdutos().get(i).getNome();
//                    double preco = b.getEstoque().getProdutos().get(i).getPreco();
//                    String validade = b.getEstoque().getProdutos().get(i).getValidade2();
//                    Produto produto = new Produto(nome, preco, validade, codigo, quantidade); // Testes no sistema de vendas, finalmente consegui
//                    if (produto.isVerificavalidade() == true){
//                        b.getVendas().add(produto); // adiciona as unidades vendidas.
//                        b.getEstoque().getProdutos().remove(i); //Remove o produto por a quantidade ser zero.
//                        verifica = 1;
//                    }else{
//                        verifica = 2;
//                    }
                }
            }
        }    
        //Central de Verificações.
        if (verifica == 0){
            System.out.println("Código errado.");
        }else if(verifica == 1){
            System.out.println("Compra realizada com Sucesso.");
        }else if(verifica == 2){
            System.out.println("Não foi possivel realizar a compra, produto está vencido.");
        }
    }
}