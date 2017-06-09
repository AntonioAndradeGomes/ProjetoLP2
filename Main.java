package ProjetoLP2;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
      // Fachada fachada = new Fachada();
      // fachada.metodo1();
//        
        Loja l = new Loja();
        Cliente c = new Cliente("Antonio", "12131496", l);
        c.setDivida(c.getDivida()+190);
        System.out.println(c.getDivida());
        c.PagarDivida(200);
        System.out.println(c.getDivida());
        //Vender a = new Vender();
//        //Estoque b = new Estoque();
//        Produto d = new Produto("d", 123, "10/10/2018", "1234", 5, l);
//        Produto c = new Produto("w", 123, "10/10/2018", "1233", 1, l);
//        
//        l.getVenda().vender("1234", 5, l);
//        l.getVenda().vender("1233", 1, l);
//        l.ListarVendas();
//        System.out.println("Valor vendido: " + l.getMontanteMensal());
        //l.getEstoque().ListarProdutos();
//        

    }
}
