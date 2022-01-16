package dados;

public abstract class Dados{
    
    protected Integer ID;
    protected String Nome;
    protected String LocalDaCompra;
    protected int Quantidade;
    protected double Valor;
    protected double Historico;

    public Dados(){
        
    }
    public Dados(int ID,String Nome,String LocalDaCompra,int Quantidade,double Valor){
        this.ID=ID;
        this.Nome=Nome;
        this.LocalDaCompra=LocalDaCompra;
        this.Quantidade=Quantidade;
        this.Valor=Valor;
    }
    public Integer getID() {
        return ID;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public int getQuantidade() {
        return Quantidade;
    }
    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }
    // Ainda estou pensando no que irei fazer
    public String getLocalDaCompra() {
        return LocalDaCompra;
    }
    public void setLocalDaCompra(String localDaCompra) {
        LocalDaCompra = localDaCompra;
    }
    public double getValor() {
        return Valor;
    }
    public void setValor(double valor) {
        Valor = valor;
    }
    public double getHistorico() {
        return Historico;
    }
       
}