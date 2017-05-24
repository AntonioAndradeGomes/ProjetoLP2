
package ProjetoLP2;
//import java.util.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.ArrayList;

public class Loja {

    private double montanteMensal;
    private ArrayList <Estoque> estoque;
    private ArrayList <Cliente> cadastrocliente;

    public Loja (){
        this.montanteMensal = 0.0;
        this.cadastrocliente = new ArrayList<Cliente>();
        this.estoque = new ArrayList<Estoque>();
    }
    public void CadastroCliente (Cliente cliente){
        this.getCadastrocliente().add(cliente);
    }
    
 
    public double getMontanteMensal() {
        return montanteMensal;
    }

    /**
     * @return the estoque
     */
    public ArrayList <Estoque> getEstoque() {
        return estoque;
    }

    /**
     * @return the cadastrocliente
     */
    public ArrayList <Cliente> getCadastrocliente() {
        return cadastrocliente;
    }
}
