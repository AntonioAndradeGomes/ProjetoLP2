
import java.text.ParseException;

public class Main {
    public static void main (String[] args) throws ParseException{
        //Fachada fachada = new Fachada();
        //fachada.metodo1();
        
        Estoque b = new Estoque();
        Produto a = new Produto("a", 123, "10/10/2018", "1234", 5, b);
        Produto d = new Produto("d", 123, "10/10/2015", "1234", 5, b);
        Produto c = new Produto("w", 123, "10/10/2018", "1233", 0, b);
        
        b.ListarProdutos();
    }
}