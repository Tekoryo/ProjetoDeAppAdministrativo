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
}
