package modelo.entities;

public class Chapa extends Insumo {
    protected Double metroQuadrado;
    protected Double Espessura;
//a quantidade é em m²
    public Chapa(){
        super();
    }
    public Chapa(int ID, String Nome,double Espessura){
        super(ID, Nome);
        this.Espessura=Espessura;
    }
    public Chapa(int ID,String Nome,String LocalDaCompra,double Valor,double Espessura){
        super(ID,Nome,LocalDaCompra,Valor);
        this.Espessura=Espessura;
    }
    
    public Double getmetroQuadrado() {
        return metroQuadrado;
    }
    public Double getEspessura() {
        return Espessura;
    }

    public void aumentarItem(String LocalDaCompra, double metroQuadrado, double ValorPorMetroQuadrado){
        this.LocalDaCompra=LocalDaCompra;
        this.metroQuadrado=metroQuadrado;
        this.ValorUnitario=ValorPorMetroQuadrado;
        this.ValorTotal=metroQuadrado*ValorUnitario;
    }
    
    public void diminuirItem(Double metroQuadrado){
        this.metroQuadrado=this.metroQuadrado-metroQuadrado;
        
    }
}
