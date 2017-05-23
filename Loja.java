
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
    
    public void CadastroCliente (Cliente cliente){
        this.cadastrocliente.add(cliente);
    }    
}
