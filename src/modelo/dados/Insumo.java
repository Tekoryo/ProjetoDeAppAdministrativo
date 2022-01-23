package modelo.dados;

public class Insumo extends CadastroDeDados {

    private String LocalDaCompra;
    private int Quantidade;
    private Double Valor;

    public Insumo() {
        super();
    }
    public Insumo(int ID, String Nome){
        super(ID, Nome);
    }
    public Insumo(int ID, String Nome, String LocalDaCompra, int Quantidade, double Valor) {
        super(ID, Nome);
        this.LocalDaCompra=LocalDaCompra;
        this.Quantidade=Quantidade;
        this.Valor=Valor;
    }

    public String getLocalDaCompra() {
        return LocalDaCompra;
    }

    public void setLocalDaCompra(String localDaCompra) {
        LocalDaCompra = localDaCompra;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }
    
}
