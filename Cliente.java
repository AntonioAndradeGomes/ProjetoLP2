package ProjetoLP2;

import java.util.ArrayList;

public class Cliente{
    private String nome;
    private String cpf;
    private double divida = 0;
    private Loja dados;
    private ArrayList <Produto> compras; //Compras do cliente

    public Cliente(String nome, String cpf, Loja a){
        this.nome = nome;
        this.cpf = cpf;
        this.dados = a;
        compras = new ArrayList<>(); //Compras do cliente
        dados.AddCliente(this); //a loja é um dos parametros da classe pois assim que chamamos o contrutor adicionamos a lista de Clientes
    }
    
    public ArrayList<Produto> getCompras() {
        return compras;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        if (divida >= 0){ //Já que quando paga fica 0 a dívida, então tem de ter igual a 0
            this.divida = divida;
        }else{
            System.out.println("Valor incorreto.");
        }
    }
    public void PagarDivida(double valor, Loja b){ //Criado referência para alterar montante mensal da loja com o que pagar.
        if (valor >= 0){ //Verifica se valor não é negativo
            if (valor > getDivida()){ //Dinheiro maior que divida, então possui troco.
                b.setMontanteMensal(b.getMontanteMensal() + getDivida()); //Adicionando dinheiro pago ao motante mensal.
                double troco = valor - getDivida();
                setDivida(0); //Se valor é maior que divida, logo sempre vai ser zero a divida
                System.out.printf("O troco é de %.2f\n"
                        +"Divida paga com sucesso\n", troco);
            }else if (valor <= getDivida()){ //Verifica se valor é menor que a dívida
                b.setMontanteMensal(b.getMontanteMensal() + valor); //Adicionando dinheiro pago ao motante mensal.
                setDivida(getDivida() - valor);
                System.out.printf("Sua divida continua em %.2f\n", getDivida());
            }
        }else{ //Valor negativo, errado.
            System.out.println("Valor incorreto.");
        }
    }
    public void ListarVendas(){ //lista o historico de compras do cliente
        if (this.compras.size() > 0){
            System.out.println("Codigo\t\t\tNome\t\tQuantidade\t\tPreço\t\tValidade");
            System.out.println("==========================================================================================");
            for (int i=0; i < this.compras.size(); i++){
                //Dá pra fazer tudo em uma linha, mas não fica elegante.
                System.out.printf("%s", this.compras.get(i).getCodigo());
                System.out.printf("\t\t\t%s", this.compras.get(i).getNome());
                System.out.printf("\t\t%d", this.compras.get(i).getUnidadesAdiquiridas());
                System.out.printf("\t\t\t%.2f", this.compras.get(i).getPreco());
                System.out.printf("\t\t%s\n", this.compras.get(i).getValidade2());
            }
            System.out.println("==========================================================================================");
            System.out.printf("Dívida: R$ %.2f\n", getDivida());
        }else{
            System.out.println("Não foi realizada nenhuma compra");
        }
    }

    
}
