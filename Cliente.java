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
        if (divida > 0){
        this.divida = divida;
        }else{
            System.out.println("Valor incorretos.");
        }
    }
    public void PagarDivida(double valor){
        if (valor > 0){
            this.divida = this.divida - valor;
            if (this.divida > 0){
                this.troco = this.divida;
                this.divida = 0;
            }
        }else{
            System.out.println("Valor incorreto.");
        }
    }
    //public void ListarCompras(){//Listar todas as compras feitas por esse comprador cadastrado
        
    //}

//    }
//    public void Comprar(int codigo){
//        if (estoque.indexOf(codigo) != -1){
//            int indice = estoque.indexOf(codigo);
//            //estoque.set(estoque.indexOf(codigo), estoque.get(indice).quantidade - 1);
//            estoque.remove(codigo);
//        }
//    }
}
