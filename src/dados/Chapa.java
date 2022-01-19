package dados;

import java.util.ArrayList;
import java.util.List;

public class Chapa extends Dados {
    private double Sobra;
    private double Espessura;
    public Chapa(){
        super();
    }
    public Chapa(int ID,String Nome,String LocalDaCompra,int Quantidade,double Valor,double Espessura){
        super(ID,Nome,LocalDaCompra,Quantidade,Valor);
        this.Espessura=Espessura;
    }
    public double getSobra() {
        return Sobra;
    }
    public void setSobra(double sobra) {
        Sobra = sobra;
    }
    
}
