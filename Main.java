package ProjetoLP2;


import java.text.ParseException;

public class Main {
    public static void main (String[] args) throws ParseException{
//        Fachada fachada = new Fachada();
//        fachada.metodo1();
//        
          Loja l = new Loja();
//          Estoque b = new Estoque();
          Produto d = new Produto("d", 123, "10/10/2015", "1234", 5,l.getEstoque());
//          Produto c = new Produto("w", 123, "10/10/2018", "1233", 0, b);
//          
          l.getEstoque();
          l.getEstoque().ListarProdutos();
//        

    }
}