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
    }
    
    public void diminuirItem(Double metroQuadrado){
        this.metroQuadrado=this.metroQuadrado-metroQuadrado;
        
    }
    @Override
    public String toString() {
        return  " | ID da Chapa: "+super.getID()
                + "\n | Nome da Chapa: "+super.getNome() 
                + "\n | Local da Compra: "+super.getLocalDaCompra()
                + "\n | Espessura: " + String.format("%.1f",Espessura) 
                + "\n | Metro Quadrado" + String.format("%.2f",metroQuadrado);
    }
    
}
