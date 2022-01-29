package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.CadastroDeDados;
import modelo.entities.Cliente;
import modelo.entities.Obra;
import modelo.service.ContratoCliente;
import modelo.service.ContratoDeFuncionario;
import modelo.service.Estoque;


public class App {
    static Scanner Sc=new Scanner(System.in);
    static List<CadastroDeDados>dados=new ArrayList<>();
    static Estoque estoque=new Estoque();
    static Cliente empresa=new Cliente();
    static ContratoDeFuncionario contratoDeFuncionario=new ContratoDeFuncionario();
    static ContratoCliente contratoCliente=new ContratoCliente();
    
    public static void main(String[] args) throws Exception {
        try{
            System.out.print("Cadastra Obra ou outros? (1/0):");
            //Altera a varivel y
            int y=Sc.nextInt();
            if(y==0){
                char x;
                do{
                    TipodeCadastro(1);
                    System.out.print("Continuar (Sim=S/Não=n)?");
                    x=Sc.next().charAt(0);
                }while(x=='S'||x=='s'); 
            }else if(y==1){
                TipodeCadastro(2);
            }
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        finally{
            System.out.print("Fim do Programa!");
            Sc.close();
        }
        
    }
    public static void TipodeCadastro(int da){
        int info;
        if(da==2){
            info=4;
            Cadastrodados(info);
        }else{
            boolean liberar;
            do{
                System.out.print("Funcionraio=1/Insumo=2/Chapa=3: "); 
                info=Sc.nextInt();
                if(info==1||info==2||info==3){
                    Cadastrodados(info);
                    liberar=false;
                }else{
                    liberar=true;
                }
            }while(liberar);
        }
        
    }
    public static void Cadastrodados(int info){
        if(info==2||info==3){
            estoque.Cadastraitem();
        }else if(info==1){
            contratoDeFuncionario.CadastroDeFuncionario();
        }else if(info==4){
           contratoCliente.CadastraCliente();
        }
    }
    public static void CadastroDeEmpresa(int ID,String Nome){
        /*
        System.out.print("Data inicial: ");
        String TipoContrato=Sc.next();
        System.out.print("Data Final: ");
        String FuncaoNaEmpresa=Sc.next();
        */
        System.out.print("Deseja adicionar uma obra [S/n]?  ");
        char addObras=Sc.next().charAt(0);
        if(addObras=='S'||addObras=='s'){
            AddObras();
        }
    }
    public static void AddObras(){
        System.out.print("ID:");
            int IDObra=Sc.nextInt();
            System.out.print("Nome:");
            String NomeObra=Sc.next();
            System.out.print("Valor Bruto a receber: ");
            double ValorObra=Sc.nextDouble();

            Obra NovaObra=new Obra(IDObra, NomeObra, ValorObra);
            Cliente.AddObra(NovaObra);
            
    }
}
 