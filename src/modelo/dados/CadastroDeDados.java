package modelo.dados;

import java.util.ArrayList;
import java.util.List;

public abstract class CadastroDeDados{
    
    protected Integer ID;
    protected String Nome;

    public CadastroDeDados(){      
    }
    
    public CadastroDeDados(Integer iD, String nome) {
        ID = iD;
        Nome = nome;
    }

    public CadastroDeDados(int ID,String Nome){
        this.ID=ID;
        this.Nome=Nome;
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
       
}