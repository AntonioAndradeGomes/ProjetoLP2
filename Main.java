package ProjetoLP2;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
      // Fachada fachada = new Fachada();
      // fachada.metodo1();
//        
        Loja l = new Loja();
        //Vender a = new Vender();
        //Estoque b = new Estoque();
        Produto d = new Produto("d", 123, "10/10/2018", "1234", 5, l);
        Produto c = new Produto("w", 123, "10/10/2018", "1233", 1, l);
          
        l.getEstoque();
        
        l.getVenda().vender("1234", 8, l);
        
        l.ListarVendas();
        l.getEstoque().ListarProdutos();
//        

    }
}
