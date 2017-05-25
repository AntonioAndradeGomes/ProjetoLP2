//package ProjetoLP2;
import java.util.ArrayList;
class Estoque extends Loja{
    private ArrayList<Produto> produtos;
//    private Loja loja;
    //só pode ser criado um estoque para essa loja
    public Estoque(){
        produtos = new ArrayList<>();
        
    }
    public boolean BuscarProdutoCodigo(String codigo){
        for (int i = 0; i<produtos.size(); i++){
            if (produtos.get(i).getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    public boolean BuscarProdutoNome(String nome){
        for (int i = 0; i<produtos.size(); i++){
            if (produtos.get(i).getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
    public void ExcluirProduto(String codigo){
        for (int i = 0; i<produtos.size(); i++){
            if (produtos.get(i).getCodigo().equals(codigo)){
                produtos.remove(i);
            }
        }    
    }
}
