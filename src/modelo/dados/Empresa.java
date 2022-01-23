package modelo.dados;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends CadastroDeDados{
    //Mudar o nome assim que pensar em um melhor (Empresa esta responçavel tanto pelos dados da pessoaJuridica ou pessoafisica)
    private Integer CNPJ,CPF;

    static List<Obra>Obras=new ArrayList<>();

    public Empresa() {
       super();
        
    }
    public Empresa(Integer iD, String nome,int CPF) {
        super(iD, nome);
        this.CPF = CPF;
    }
    public Empresa(int ID, String Nome, int CNPJ) {
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
