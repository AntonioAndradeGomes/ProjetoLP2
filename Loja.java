package ProjetoLP2;
//import java.util.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.ArrayList;

public class Loja {

    private double montanteMensal;
    private Estoque estoque;
    private ArrayList <Cliente> cadastrocliente;

    public Loja (){
        this.montanteMensal = 0.0;
        this.cadastrocliente = new ArrayList<Cliente>();
        estoque = new Estoque();

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
            System.out.println("cpf\t\t\tNome\t\tDivida");
            System.out.println("==========================================================================================");
            for (int i=0; i < cadastrocliente.size(); i++){
                //Dá pra fazer tudo em uma linha, mas não fica elegante.
                System.out.printf("%s", cadastrocliente.get(i).getCpf());
                System.out.printf("\t\t\t%s", cadastrocliente.get(i).getNome());
                System.out.printf("\t\t%d", cadastrocliente.get(i).getDivida());
            }
            System.out.println("==========================================================================================");
        }else{
            System.out.println("Nao ha clientes cadastrados!!!");
        }
    }
    public boolean BuscarClienteCpf(String cpf){
        for (int i = 0; i < this.cadastrocliente.size(); i++){
            if (this.cadastrocliente.get(i).getCpf().equals(cpf)){
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
    
    public void ListarVendas(){ //listar todas as vendas realizadas
        
    }
    public double getMontanteMensal() {
        return montanteMensal;
    }

    public void setMontanteMensal(double montanteMensal) {
        this.montanteMensal = montanteMensal;
    }
}
