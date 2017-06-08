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
}