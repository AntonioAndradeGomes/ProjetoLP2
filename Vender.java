import java.util.ArrayList;
public class Vender{
    Cliente cliente;
    Produto produto;
    ArrayList<Produto> vendas;
    
    public void vender(String codigo, long quantidade, Estoque b){
        boolean verifica = false; //Verifica os limites do estoque
        boolean verifica2 = false; //Se o código do produto está certo.
        for (int i = 0; i < b.getProdutos().size(); i++){
            if (b.getProdutos().get(i).getCodigo().equals(codigo)){
                verifica2 = true;
                if (b.getProdutos().get(i).getUnidadesAdiquiridas() - quantidade > 0){ //Se as unidades menos a qunatidade disponiveis forem maior que 0
                    final long qtd = b.getProdutos().get(i).getUnidadesAdiquiridas() - quantidade; // No estoque
                    b.getProdutos().get(i).setUnidadesAdiquiridas(quantidade); // unidade vendidas
                    vendas.add(b.getProdutos().get(i)); // adiciona as unidades vendidas.
                    b.getProdutos().get(i).setUnidadesAdiquiridas(qtd);
                    verifica = true;
                }else if (b.getProdutos().get(i).getUnidadesAdiquiridas() - quantidade > 0){ // Se as unidades menos a quantidade forem igual a zero, ou seja, acabou o produto.
                    final long qtd = b.getProdutos().get(i).getUnidadesAdiquiridas() - quantidade; // No estoque
                    b.getProdutos().get(i).setUnidadesAdiquiridas(quantidade); // unidade vendidas
                    vendas.add(b.getProdutos().get(i)); // adiciona as unidades vendidas.
                    b.getProdutos().remove(i); //Remove o produto.
                    verifica = true;
                }
                //b.getProdutos().get(i).setUnidadesAdiquiridas(quantidade);
            }
        }
        if (verifica2 == false){
            System.out.println("Código errado");
        }else if(verifica2 == true && verifica == true){
            System.out.println("Compra realizada com Sucesso");
        }else if(verifica2 == true && verifica == false){
            System.out.println("Não temos essa quantidade em estoque");
        }
    }
}