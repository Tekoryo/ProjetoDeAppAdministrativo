package modelo.entities;

public class Insumo extends CadastroDeDados {

    protected String LocalDaCompra;
    protected int Quantidade;
    protected Double ValorUnitario;

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
        this.ValorUnitario=Valor;
    }
    public Insumo(int ID, String Nome, String LocalDaCompra, double Valor) {
        super(ID, Nome);
        this.LocalDaCompra=LocalDaCompra;
        this.ValorUnitario=Valor;
    }

    public String getLocalDaCompra() {
        return LocalDaCompra;
    }
    public int getQuantidade() {
        return Quantidade;
    }
    public Double getValor() {
        return ValorUnitario;
    }

    public void aumentarItem(String LocalDaCompra, int Quantidade, double ValorUnitario){
        this.LocalDaCompra=LocalDaCompra;
        this.Quantidade=this.Quantidade+Quantidade;
        this.ValorUnitario=ValorUnitario;
    }
    public void diminuirItem(int Quantidade){
        this.Quantidade=this.Quantidade-Quantidade;
        
    }
    @Override
    public String toString() {
        return " | ID do Insumo"+super.getID()
                +"\n | Nome do Insumo"+super.getNome()
                +"\n | Local Da Compra: " + LocalDaCompra 
                +"\n | Quantidade: " + Quantidade 
                +"\n | Valor Unitario=" + getValor();
    }
    
}
