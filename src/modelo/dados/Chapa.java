package modelo.dados;

public class Chapa extends Insumo {
    private Double Sobra;
    private Double Espessura;

    public Chapa(){
        super();
    }
    public Chapa(int ID, String Nome){
        super(ID, Nome);
    }
    public Chapa(int ID,String Nome,String LocalDaCompra,int Quantidade,double Valor,double Espessura){
        super(ID,Nome,LocalDaCompra,Quantidade,Valor);
        this.Espessura=Espessura;
    }
    
    public Double getSobra() {
        return Sobra;
    }
    public void setSobra(Double sobra) {
        this.Sobra = sobra;
    }
    public Double getEspessura() {
        return Espessura;
    }
    public void setEspessura(Double espessura) {
        this.Espessura = espessura;
    }
        
}
