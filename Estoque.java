package ProjetoLP2;
import java.util.ArrayList;
class Estoque{
    private ArrayList<Produto> produtos;

    //só pode ser criado um estoque para essa loja
    public Estoque(){

        produtos = new ArrayList<>();
    }
    
    public void addProd(Produto c){
        this.produtos.add(c);
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
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
   // public void addProduto(Produto c){ // Comando experto para add produtos no Estoque
    //    this.produtos.add(c);
        //if (produtos.size() == 0)
         //   this.produtos.add(c);
        //else if (produtos.size() > 0){
            //for (int i = 0; i < produtos.size(); i++){
                //if (produtos.get(i).getNome().indexOf(c.getNome()) != -1){
              //      produtos.get(i).setUnidadesAdiquiridas(produtos.get(i).getUnidadesAdiquiridas() + c.getUnidadesAdiquiridas());
            //    }
          //  }
        //}else{
         //   this.produtos.add(c);
        //}    
    //}
    public void ExcluirProduto(String codigo){
        for (int i = 0; i<produtos.size(); i++){
            if (produtos.get(i).getCodigo().equals(codigo)){
                produtos.remove(i);
            }
        }    
    }
    public void ListarProdutos(){
        System.out.println("Codigo\t\t\tNome\t\tQuantidade\t\tPreço\t\tValidade");
        System.out.println("==========================================================================================");
        for (int i=0; i < produtos.size(); i++){
            //Dá pra fazer tudo em uma linha, mas não fica elegante.
            System.out.printf("%s", produtos.get(i).getCodigo());
            System.out.printf("\t\t\t%s", produtos.get(i).getNome());
            System.out.printf("\t\t%d", produtos.get(i).getUnidadesAdiquiridas());
            System.out.printf("\t\t\t%.2f", produtos.get(i).getPreco());
            System.out.printf("\t\t%s\n", produtos.get(i).getValidade2());
            
            
        }
        System.out.println("==========================================================================================");
    }
}
