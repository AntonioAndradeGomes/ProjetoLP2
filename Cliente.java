//package ProjetoLP2;

import java.util.ArrayList;

public class Cliente{
    private String nome;
    private String cpf;
    private double divida = 0;
    private double troco;
    
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
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
        this.divida = divida;
    }
    public void PagarDivida(double valor){
        if (valor > 0){
            this.divida = this.divida - valor;
            if (this.divida > 0){
                this.troco = this.divida;
                this.divida = 0;
            }
        }
    }
//    public void Comprar(int codigo){
//        if (estoque.indexOf(codigo) != -1){
//            int indice = estoque.indexOf(codigo);
//            //estoque.set(estoque.indexOf(codigo), estoque.get(indice).quantidade - 1);
//            estoque.remove(codigo);
//        }
//    }
}