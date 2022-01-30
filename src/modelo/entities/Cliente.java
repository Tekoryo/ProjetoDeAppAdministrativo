package modelo.entities;

import java.util.ArrayList;
import java.util.List;

import modelo.service.ControleDeObra;

public class Cliente extends CadastroDeDados{
    
    private Integer CNPJ,CPF;

    public Cliente() {
       super();
    }
    public Cliente(Integer ID, String nome,int CPF) {
        super(ID, nome);
        this.CPF = CPF;
    }
    public Cliente(int ID, String Nome, int CNPJ) {
        super(ID, Nome);
        this.CNPJ = CNPJ;    
    }

    public int getCNPJ() {
        return CNPJ;
    }
    public int getCPF() {
        return CPF;
    } 
    
    // Criar um metodo para fazer as alteracao do dados caso seja nessesario

    public ControleDeObra Obra() {
       return new ControleDeObra();
    }
    @Override
    public String toString() {
        return "Id da cliente: "+super.getID()
                +"Nome da cliente: "+super.getNome()
                +Certificado();
    }
    public String Certificado(){
        if(CPF!=null||CNPJ==null){
            return "CPF: "+String.valueOf(getCPF());
        }else{
            return "CNPJ: "+String.valueOf(getCNPJ());            
        }
    }
    
}
