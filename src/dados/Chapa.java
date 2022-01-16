package dados;

import java.util.ArrayList;
import java.util.List;

public class Chapa extends Dados {
    private double Sobra;
    
    List<Dados> DadosChapa=new ArrayList<>();

    public Chapa(){
        super();
    }
    public Chapa(int ID,String Nome,String LocalDaCompra,int Quantidade,double Valor,double Sobra){
        super(ID,Nome,LocalDaCompra,Quantidade,Valor);
        this.Sobra=Sobra;
    }

}
