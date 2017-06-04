//package ProjetoLP2;
import java.text.ParseException;
import java.util.ArrayList;
public class Vender{
    Cliente cliente;
    Produto produto;
    //ArrayList<Produto> vendas;
    
    public void vender(String codigo, long quantidade, Loja b) throws ParseException{
        //b.getEstoque().getProdutos().size();
        boolean verifica = false; //Verifica os limites do estoque
        boolean verifica2 = false; //Se o código do produto está certo.
        for (int i = 0; i < b.getEstoque().getProdutos().size(); i++){
            if (b.getEstoque().getProdutos().get(i).getCodigo().equals(codigo)){
                verifica2 = true;
                long quantidade2 = b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade;
                //if (b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade > 0){ //Se as unidades menos a qunatidade disponiveis forem maior que 0
                
                if (quantidade2 > 0){
                    //System.out.println(quantidade2);
                    final long qtd = b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade; // No estoque
                    System.out.println(qtd);
                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(2); // unidade vendidas
                    this.produto = new Produto(b.getEstoque().getProdutos().get(i).getNome(), 123, "10/10/2018", "1234", quantidade); // Testes no sistema de vendas, finalmente consegui
                    System.out.println(this.produto);
                    b.vendas.add(this.produto); // adiciona as unidades vendidas.
                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(qtd);
                    System.out.println(b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas());
                    verifica = true;
                }else if (b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade > 0){ // Se as unidades menos a quantidade forem igual a zero, ou seja, acabou o produto.
                    final long qtd = b.getEstoque().getProdutos().get(i).getUnidadesAdiquiridas() - quantidade; // No estoque
                    b.getEstoque().getProdutos().get(i).setUnidadesAdiquiridas(quantidade); // unidade vendidas
                    //vendas.add(b.getEstoque().getProdutos().get(i)); // adiciona as unidades vendidas.
                    b.getEstoque().getProdutos().remove(i); //Remove o produto.
                    verifica = true;
                }
                //b.getProdutos().get(i).setUnidadesAdiquiridas(quantidade);
            }
        }
        //System.out.println(b.getEstoque().getProdutos().get(0).getUnidadesAdiquiridas() - 1);
        if (verifica2 == false){
            System.out.println("Código errado");
        }else if(verifica2 == true && verifica == true){
            System.out.println("Compra realizada com Sucesso");
        }else if(verifica2 == true && verifica == false){
            System.out.println("Não temos essa quantidade em estoque");
        }
    }
}