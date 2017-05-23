package projeto;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Produto {
    private String nome;
    private double preco;
    private Date validade;
    private String codigo;
    private boolean verificavalidade;
    private long unidadesAdiquiridas;


    public Produto(String nome, double preco, Date validade, String codigo, long unidadesAdiquiridas) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.codigo = codigo;
        this.unidadesAdiquiridas = unidadesAdiquiridas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isVerificavalidade() {
        return verificavalidade;
    }

    public void setVerificavalidade(boolean verificavalidade) {
        this.verificavalidade = verificavalidade;
    }

    public long getUnidadesAdiquiridas() {
        return unidadesAdiquiridas;
    }

    public void setUnidadesAdiquiridas(long unidadesAdiquiridas) {
        this.unidadesAdiquiridas = unidadesAdiquiridas;
    }
    public boolean VerificaDisponibilidade(){
        if(this.getUnidadesAdiquiridas() > 0){
            return true;
        }else{
            return false;
        }
    }
    
   
}
