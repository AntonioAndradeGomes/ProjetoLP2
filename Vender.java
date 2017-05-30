import java.util.ArrayList;
public class Vender{
    Cliente cliente;
    Produto produto;
    ArrayList<Produto> vendas;
    
    public void vender(String codigo, int quantidade, Estoque b){
        boolean verifica = true;
        for (int i = 0; i < b.getProdutos().size(); i++){
            if (b.getProdutos().get(i).getCodigo().equals(codigo)){
                if (b.getProdutos().get(i).getUnidadesAdiquiridas() - quantidade > 0){
                    vendas.add(b.getProdutos().get(i));
                }else if (b.getProdutos().get(i).getUnidadesAdiquiridas() - quantidade > 0){
                    
                }
                //b.getProdutos().get(i).setUnidadesAdiquiridas(quantidade);
            }
        }
    }
}