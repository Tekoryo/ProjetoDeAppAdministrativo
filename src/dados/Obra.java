package dados;

//import java.util.Date;

import javax.management.loading.PrivateClassLoader;

public class Obra extends Dados {
    private String NomeEmpresa;
    //private Date Datainicio,DataFinal;
    private double ValorBruto;
    
    public Obra() {
        super();
    }
    public Obra(Integer iD, String nome, String nomeEmpresa, double valorBruto) {
        super(iD, nome);
        NomeEmpresa = nomeEmpresa;
        //Datainicio = datainicio;
        //DataFinal = dataFinal;
        ValorBruto = valorBruto;
    }
    public String getNomeEmpresa() {
        return NomeEmpresa;
    }
    public void setNomeEmpresa(String nomeEmpresa) {
        NomeEmpresa = nomeEmpresa;
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
