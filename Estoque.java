package ProjetoLP2;
import java.util.ArrayList;
class Estoque{
    private ArrayList<Produto> produtos;
    private static Estoque singleton;
    
    private Estoque(){}
    
    public static synchronized Estoque getInstance(){
        if (singleton == null){
            singleton = new Estoque();
            singleton.produtos = new ArrayList<>();
        }
        return singleton;
    }
    
    public void addProd(Produto c){ //Adiciona produto ao estoque, e esse produto vai ser adicionado na loja.
        this.produtos.add(c); //Pegando referência do produto.
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public void BuscarProdutoCodigo(String codigo){
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
    }
    public void BuscarProdutoNome(String nome){
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
    }

    public void ExcluirProduto(String codigo){
        boolean verifica = false;
        for (int i = 0; i<produtos.size(); i++){
            if (produtos.get(i).getCodigo().equals(codigo)){
                produtos.remove(i);
                System.out.println("Produto removido com sucesso");
                verifica = true;
                break; //Já que só existe um único código de produto, pode parar quando achar.
            }
        }
        if(verifica == false){
            System.out.println("Produto não encontrado para remoção");
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
            System.out.println("Não existe produto no estoque");
        }
    }
}
