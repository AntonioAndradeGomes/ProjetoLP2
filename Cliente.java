package ProjetoLP2;

import java.util.ArrayList;

public class Cliente{
    private String nome;
    private String cpf;
    private double divida = 0;
    private double troco;
    private Loja dados;
   // private ArrayList <Produto> compras;
    
    
    public Cliente(String nome, String cpf, Loja a){
        this.nome = nome;
        this.cpf = cpf;
        this.dados = a;
        dados.AddCliente(this);
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
        if (divida >= 0){
        this.divida = divida;
        }else{
            System.out.println("Valor incorretos.");
        }
    }
    //seu pagar divida estava errado, quando pagava qualquer coisa a divida ficava zerada]
    // concertado 9/jun 
    public void PagarDivida(double valor){
        if (valor >= 0){
            if (valor > getDivida()){
                valor -= getDivida();
                setDivida(getDivida() -getDivida());
                System.out.printf("O troco é de %.2f\n"
                        +"Divida paga com sucesso\n", valor);
            }else if (valor <= getDivida()){
                setDivida(getDivida() - valor);
                System.out.printf("Sua divida continua em %.2f\n", getDivida());
            }
        }else{
            System.out.println("Valor incorreto.");
        }
    }
    //public void ListarCompras(){//Listar todas as compras feitas por esse comprador cadastrado
        
    //}
    
}
