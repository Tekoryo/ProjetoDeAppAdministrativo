package modelo.dados;

import java.util.ArrayList;
import java.util.List;

public abstract class Dados{
    
    protected Integer ID;
    protected String Nome;
    protected String LocalDaCompra;
    protected int Quantidade;
    protected double Valor;
    protected double Historico;

    List<Double> HistoricoDePreco=new ArrayList<>();

    public Dados(){      
    }
    
    public Dados(Integer iD, String nome) {
        ID = iD;
        Nome = nome;
    }

    public Dados(int ID,String Nome,String LocalDaCompra,int Quantidade,double Valor){
        this.ID=ID;
        this.Nome=Nome;
        this.LocalDaCompra=LocalDaCompra;
        this.Quantidade=Quantidade;
        this.Valor=Valor;
    }
    public Integer getID() {
        return ID;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public int getQuantidade() {
        return Quantidade;
    }
    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }
    // Ainda estou pensando no que irei fazer
    public String getLocalDaCompra() {
        return LocalDaCompra;
    }
    public void setLocalDaCompra(String localDaCompra) {
        LocalDaCompra = localDaCompra;
    }
    public double getValor() {
        return Valor;
    }
    public void setValor(double valor) {
        Valor = valor;
    }
    public double getHistorico() {
        return Historico;
    }
    // Criar um object para Historico
    public void addHistorico(){
        double preco=this.Valor;
        HistoricoDePreco.add(preco);
    }
    public double ViewHistorico(){
        for(double H:HistoricoDePreco){
            return H;
        }
        return 0;
    }
       
}