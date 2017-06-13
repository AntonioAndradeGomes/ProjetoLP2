package ProjetoLP2;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
      // Fachada fachada = new Fachada();
      // fachada.metodo1();
//        
        Loja l = new Loja();
        Cliente c = new Cliente("Antonio", "12", l);
       // Cliente r = new Cliente("antonio", "123", l);
//        c.setDivida(c.getDivida()+190);
//        System.out.println(c.getDivida());
//        c.PagarDivida(200);
//        System.out.println(c.getDivida());
        //System.out.println(l.getCadastrocliente().get(0).getNome());
        Produto d = new Produto("d", 123, "10/10/2018", "1234", 5, l);
        Produto e = new Produto("w", 123, "10/10/2018", "1233", 1, l);
        //System.out.println(l.getVenda().indexVendaCliente("123", l));
        l.getVenda().venderCliente("12", "1234", 5, l);
        
        l.ListarVendasCliente("12"); // cpf
        l.Pagardivida("12", 600);
        l.ListarVendasCliente("12");
        //System.out.println(l.getCadastrocliente().get(0).getDivida());
//        l.getVenda().vender("1234", 5, l);
//        l.getVenda().vender("1233", 1, l);
//        l.ListarVendas();
        //System.out.println("Valor vendido: " + l.getMontanteMensal());
        //l.getEstoque().ListarProdutos();
        

    }
}
