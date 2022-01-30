package modelo.entities;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.util.Date;

public class Obra extends CadastroDeDados {
    private Date Datainicio,DataFinal;
    private double ValorBruto;
    private double ValorLiquido;
    protected Boolean Status;
    
    public Obra() {
       super();
    }

    public Obra(Integer ID, String nome, double valorBruto,Date Datainicio) {
        super(ID, nome);
        this.ValorBruto = valorBruto;
        DataFinal=null;
    }
    public Date getDatainicio() {
        return Datainicio;
    }
    public Date getDataFinal() {
        return DataFinal;
    }
    public void setDataFinal(Date dataFinal) {
        DataFinal = dataFinal;
    }
    public void ValorLiquido(double x){
        this.ValorLiquido=this.ValorBruto-x;
    }
    public void FimdaObra(Date DataFinal){
        this.DataFinal=DataFinal;
        this.Status=false;
    }

    @Override
    public String toString() {
        return "ID da Obra: "+super.getID()
        +"Nome da Obra: "+super.getNome()
        +"Data de inicio: " + DataInicial() 
        + "Data de conclusão: "+DataFinal()
        + "Valor a receber: "+ ValorBruto 
        + "Valor do lucro: " + Lucro();
    }
    public String DataFinal(){
        if(DataFinal!=null){
            return String.format("dd/MM/yyyy",DataFinal);
        }else{
            return "Obra não concluida!";
        }
    }
    public String DataInicial(){
            return String.format("dd/MM/yyyy",Datainicio);
        
    }
    public String Lucro(){
        if(DataFinal!=null){
            return String.format("%.2f",ValorLiquido);
        }else{
            return "Obra não concluida, imposivel mostra dado!";
        }
    }
}
