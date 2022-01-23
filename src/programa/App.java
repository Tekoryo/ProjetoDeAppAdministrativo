package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.dados.Chapa;
import modelo.dados.Empresa;
import modelo.dados.CadastroDeDados;
import modelo.dados.Insumo;
import modelo.dados.Obra;
import modelo.dados.enums.TipoDeContrato;


public class App {
    static Scanner Sc=new Scanner(System.in);
    static List<CadastroDeDados>dados=new ArrayList<>();
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

        System.out.print("ID: ");
        int ID=Sc.nextInt();
        System.out.print("Nome: ");
        String Nome=Sc.next();

        if(info==2||info==3){
            CadastroDeMateriais(info, ID,Nome);
        }else if(info==1){
            CadastroDeFuncionario(ID,Nome);
        }else if(info==4){
            CadastroDeEmpresa(ID,Nome);
        }
    }
    public static void CadastroDeMateriais(int info,int ID,String Nome){
        System.out.print("Local da compra: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        int Quantidade=Sc.nextInt();
        System.out.print("Valor: ");
        double Preco=Sc.nextDouble();

        if(info==2){
            CadastroDeInsumo(ID,Nome,LocalDaCompra, Quantidade, Preco);
        }else if(info==3){
            CadastroDeChapa(ID, Nome, LocalDaCompra, Quantidade, Preco);
        }
    }
    public static void CadastroDeInsumo(int ID,String Nome,String LocalDaCompra,int Quantidade,double Preco) {
        dados.add(new Insumo(ID, Nome, LocalDaCompra, Quantidade, Preco));
    }
    public static void CadastroDeChapa(int ID,String Nome,String    LocalDaCompra,int Quantidade,double Preco) {
        System.out.print("Espessura: ");
        double Espessura=Sc.nextDouble();
        dados.add(new Chapa(ID, Nome, LocalDaCompra, Quantidade, Preco,Espessura));        
    }
    public static void CadastroDeFuncionario(int ID,String Nome){

        System.out.print("telefone: ");
        Long telefone=Sc.nextLong();
        System.out.print("salario: ");
        double salario=Sc.nextDouble();
        System.out.print("Tipo de Contratação: ");
        String TipoContrato=Sc.next();
        System.out.print("Função na empresa: ");
        String FuncaoNaEmpresa=Sc.next();

        dados.add(new modelo.dados.Funcionario(ID, Nome, telefone, salario, TipoDeContrato.valueOf(TipoContrato), FuncaoNaEmpresa));
    } 
    public static void CadastroDeEmpresa(int ID,String Nome){
        System.out.print("CPF ou CNPJ [1/0]: ");
        int PFPJ=Sc.nextInt();
        if(PFPJ==1){
            System.out.print("Digite o CPF: ");
            int CPF=Sc.nextInt();
            dados.add(new Empresa(ID,Nome,CPF));
        }else{
            System.out.print("Digite o CNPJ: ");
            int CNPJ=Sc.nextInt();
            dados.add(new Empresa(ID,Nome,CNPJ));
        }
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
            Empresa.AddObra(NovaObra);
    }
}
 