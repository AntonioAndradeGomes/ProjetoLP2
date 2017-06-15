package ProjetoLP2;
import java.util.ArrayList;

public class Loja {
    
    private double montanteMensal;
    private Estoque estoque;
    private ArrayList <Cliente> cadastrocliente;
    private ArrayList <Produto> vendas;
    private Vender venda;

    public Loja (){

        this.montanteMensal = 0.0;
        this.cadastrocliente = new ArrayList<Cliente>();
        this.vendas = new ArrayList<>();
        this.estoque = new Estoque();
        this.venda = new Vender();

    }

    public Vender getVenda() {
        return venda;
    }

    public void setVenda(Vender venda) {
        this.venda = venda;
    }
    public void addProduto(Produto c){ // Comando experto para add produtos no Estoque
        this.estoque.addProd(c);
    }

    public Estoque getEstoque() {
        return estoque; 
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    public void AddCliente (Cliente c){
        this.cadastrocliente.add(c);
    }
    public void ListarCliente (){
        if(this.cadastrocliente.size() > 0){
            System.out.println("cpf\t\t\tNome\t\t\tDivida");
            System.out.println("==========================================================================================");
            for (int i=0; i < cadastrocliente.size(); i++){
                //Dá pra fazer tudo em uma linha, mas não fica elegante.
                System.out.printf("%s", cadastrocliente.get(i).getCpf()); System.out.printf("\t\t\t%s", cadastrocliente.get(i).getNome()); 
                System.out.printf("\t\t\t%.2f\n", cadastrocliente.get(i).getDivida());
            }
            System.out.println("==========================================================================================");
        }else{
            System.out.println("Nao ha clientes cadastrados!!!");
        }
    }
    public boolean BuscarClienteCpf(String cpf){
        for (int i = 0; i < this.cadastrocliente.size(); i++){
            if (this.cadastrocliente.get(i).getCpf().equals(cpf)){
                System.out.println("cpf\t\t\tNome\t\tDivida");
                System.out.println("==========================================================================================");
                System.out.printf("%s", cadastrocliente.get(i).getCpf());
                System.out.printf("\t\t\t%s", cadastrocliente.get(i).getNome());
                System.out.printf("\t\t%d", cadastrocliente.get(i).getDivida());
                System.out.println("==========================================================================================");
                return true;
                }
        }
        return false;
    }
    public void BuscarClienteNome(String nome){
        int ver = 0;
        for (int i = 0; i < this.cadastrocliente.size(); i++){
            if (this.cadastrocliente.get(i).getNome().equals(nome)){
                ver += 1;
                System.out.println("cpf\t\t\tNome\t\tDivida");
                System.out.println("==========================================================================================");
                System.out.printf("%s", cadastrocliente.get(i).getCpf());
                System.out.printf("\t\t\t%s", cadastrocliente.get(i).getNome());
                System.out.printf("\t\t%d", cadastrocliente.get(i).getDivida());
                System.out.println("==========================================================================================");
            }
        }
        if (ver == 0){
            System.out.println("Nao há clientes com tal nome");
        }
    }
    
    public void ListarVendas(){
        System.out.println("Codigo\t\t\tNome\t\tQuantidade\t\tPreço\t\tValidade");
        System.out.println("==========================================================================================");
        for (int i=0; i < vendas.size(); i++){
            //Dá pra fazer tudo em uma linha, mas não fica elegante.
            System.out.printf("%s", vendas.get(i).getCodigo());
            System.out.printf("\t\t\t%s", vendas.get(i).getNome());
            System.out.printf("\t\t%d", vendas.get(i).getUnidadesAdiquiridas());
            System.out.printf("\t\t\t%.2f", vendas.get(i).getPreco());
            System.out.printf("\t\t%s\n", vendas.get(i).getValidade2());
            
            
        }
        System.out.println("==========================================================================================");
    }
    public void Pagardivida(String cpf, double valor){
        for (int i = 0; i < this.getCadastrocliente().size(); i++){
            if (this.getCadastrocliente().get(i).getCpf().equals(cpf)){
                this.getCadastrocliente().get(i).PagarDivida(valor);
            }
        }
    }
    public void ListarVendasCliente(String cpf){
        boolean verifica = false;
        for (int i=0; i < this.getCadastrocliente().size(); i++){
            if (this.getCadastrocliente().get(i).getCpf().equals(cpf)){
                this.getCadastrocliente().get(i).ListarVendas();
                verifica = true;
                break; //Já que só ira possuir um CPF não é necessário verificar mais quando achar
            }  
        }
        if (verifica == false){
            System.out.println("Cliente não foi encontrado");
        }
    }
    public void Excluircliente(String cpf){
        boolean verifica = false;
        for (int i = 0; i < this.getCadastrocliente().size(); i++){
            if (this.getCadastrocliente().get(i).getCpf().equals(cpf)){
                this.getCadastrocliente().remove(i);
                System.out.println("Cliente excluido.");
                verifica = true;
            }
        }
        if (verifica == false){
            System.out.println("Não foi possível excluir o cliente.");
        }
    }
    public double getMontanteMensal() {
        return montanteMensal;
    }

    public ArrayList<Cliente> getCadastrocliente() {
        return cadastrocliente;
    }

    public void setCadastrocliente(ArrayList<Cliente> cadastrocliente) {
        this.cadastrocliente = cadastrocliente;
    }

    public ArrayList<Produto> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Produto> vendas) {
        this.vendas = vendas;
    }

    public void setMontanteMensal(double montanteMensal) {
        this.montanteMensal = montanteMensal;
    }
}
