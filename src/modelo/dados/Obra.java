package modelo.dados;

//import java.util.Date;

public class Obra extends CadastroDeDados {
    //private Date Datainicio,DataFinal;
    private double ValorBruto;
    
    public Obra() {
       super();
    }

    public Obra(Integer ID, String nome, double valorBruto) {
        super(ID, nome);
        ValorBruto = valorBruto;
    }

    public Obra(int ID, String Nome, double valorBruto) {
        super(ID, Nome);
        ValorBruto = valorBruto;
    }
/*
    public Date getDatainicio() {
        return Datainicio;
    }
    public void setDatainicio(Date datainicio) {
        Datainicio = datainicio;
    }
    public Date getDataFinal() {
        return DataFinal;
    }
    public void setDataFinal(Date dataFinal) {
        DataFinal = dataFinal;
    }
    public double getValorBruto() {
        return ValorBruto;
    }
    public void setValorBruto(double valorBruto) {
        ValorBruto = valorBruto;
    }
*/
    
}
