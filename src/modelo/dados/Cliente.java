package modelo.dados;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends CadastroDeDados{
    
    private Integer CNPJ,CPF;

    static List<Obra>Obras=new ArrayList<>();

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

    public static void AddObra(Obra obra) {
        Obras.add(obra);
    }
}
