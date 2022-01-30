package modelo.entities;

import javax.swing.text.StyledEditorKit.BoldAction;

//import java.util.Date;

public class Obra extends CadastroDeDados {
    //private Date Datainicio,DataFinal;
    private double ValorBruto;
    private double ValorLiquido;
    protected Boolean Status;
    
    public Obra() {
       super();
    }

    public Obra(Integer ID, String nome, double valorBruto) {
        super(ID, nome);
        this.ValorBruto = valorBruto;
        this.Status=true;
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
    public void t(double x){
        this.ValorLiquido=this.ValorBruto-x;
    }
}
