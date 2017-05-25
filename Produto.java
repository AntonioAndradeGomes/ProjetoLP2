//package ProjetoLP2;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Produto extends Estoque{
    private String nome;
    private double preco;
    private String validade2;
    private Date validade;
    private String codigo;
    private boolean verificavalidade;
    private long unidadesAdiquiridas;


    public Produto(String nome, double preco, String validade, 
            String codigo, long unidadesAdiquiridas) throws ParseException {
        
        this.nome = nome;
        this.preco = preco;
        setVal(validade);
        this.codigo = codigo;
        this.unidadesAdiquiridas = unidadesAdiquiridas;
        
    }
    public void setVal(String validade) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date verifica = sdf.parse(validade);
        this.validade = verifica;
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
    public boolean Validade(){
        Calendar validadeproduto = Calendar.getInstance();
        validadeproduto.setTime(this.getValidade());
        //Criando um objeto calendar com a data atual.
        Calendar hoje = Calendar.getInstance();
        //Calculo da idade
        if (validadeproduto.get(Calendar.YEAR) > hoje.get(Calendar.YEAR)){
            return true;
        }else if (validadeproduto.get(Calendar.YEAR) == hoje.get(Calendar.YEAR) && validadeproduto.get(Calendar.MONTH) >= hoje.get(Calendar.MONTH) && validadeproduto.get(Calendar.DAY_OF_WEEK) > hoje.get(Calendar.DAY_OF_WEEK)){
                return true;
        }else{
            return false;
        }
    }
   
}
