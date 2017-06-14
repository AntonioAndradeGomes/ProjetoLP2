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
    
    public void BuscarProdutoCodigo(String codigo){
        if (produtos.size() > 0){
            boolean verifica = false; // verificar se existe produto.
            for (int i = 0; i<produtos.size(); i++){
                if (produtos.get(i).getCodigo().equals(codigo)){
                    verifica = true; // verificar se há produto no estoque para listar.
                    break; // Quando achar pelo menos um produto.
                }
            }
            if (verifica == true){
                System.out.println("Codigo\t\t\tNome\t\tQuantidade\t\tPreço\t\tValidade");
                System.out.println("==========================================================================================");
                for (int i = 0; i<produtos.size(); i++){
                    if (produtos.get(i).getCodigo().equals(codigo)){
                        System.out.printf("%s", produtos.get(i).getCodigo());
                        System.out.printf("\t\t\t%s", produtos.get(i).getNome());
                        System.out.printf("\t\t%d", produtos.get(i).getUnidadesAdiquiridas());
                        System.out.printf("\t\t\t%.2f", produtos.get(i).getPreco());
                        System.out.printf("\t\t%s\n", produtos.get(i).getValidade2());
                    }
                }
                System.out.println("==========================================================================================");
            }else{
                System.out.println("Não foi encontrado o produto com o código especificado");
            }
        }else{
            System.out.println("Não Possui nenhum produto no estoque");
        }
    }
    public void BuscarProdutoNome(String nome){
        if (produtos.size() > 0){
            boolean verifica = false; // verificar se existe produto.
            for (int i = 0; i<produtos.size(); i++){
                if (produtos.get(i).getNome().equals(nome)){
                    verifica = true; // verificar se há produto no estoque para listar.
                    break; // Quando achar pelo menos um produto.
                }
            }
            if (verifica == true){
                System.out.println("Codigo\t\t\tNome\t\tQuantidade\t\tPreço\t\tValidade");
                System.out.println("==========================================================================================");
                for (int i = 0; i<produtos.size(); i++){
                    if (produtos.get(i).getNome().equals(nome)){
                        System.out.printf("%s", produtos.get(i).getCodigo());
                        System.out.printf("\t\t\t%s", produtos.get(i).getNome());
                        System.out.printf("\t\t%d", produtos.get(i).getUnidadesAdiquiridas());
                        System.out.printf("\t\t\t%.2f", produtos.get(i).getPreco());
                        System.out.printf("\t\t%s\n", produtos.get(i).getValidade2());
                    }
                }
                System.out.println("==========================================================================================");
            }else{
                System.out.println("Não foi encontrado o produto com o nome especificado");
            }
        }else{
            System.out.println("Não Possui nenhum produto no estoque");
        }
    }

    public void ExcluirProduto(String codigo){
        for (int i = 0; i<produtos.size(); i++){
            if (produtos.get(i).getCodigo().equals(codigo)){
                produtos.remove(i);
            }
        }    
    }
    public void ListarProdutos(){
        if (produtos.size() > 0){
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
        }else{
            System.out.println("Não existe produtos no estoque");
        }
    }
}
