package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dados.Chapa;
import dados.Dados;
import dados.Insumo;
import dados.enums.TipoDeContrato;


public class App {
    static Scanner Sc=new Scanner(System.in);
    static List<Dados>dados=new ArrayList<>();
    public static void main(String[] args) throws Exception {
        try{
            System.out.print("Cadastra Obra ou outros? (O/A):");
            //Altera a varivel y
            char y=Sc.next().charAt(0);
            if(y=='o'||y=='O'){
                char x;
                do{
                    Cadastrodados();
                    System.out.print("Continuar (Sim=S/Não=n)?");
                    x=Sc.next().charAt(0);
                }while(x=='S'||x=='s'); 
            }else if(y=='a'||y=='A'){
                Cadastrodados();
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

    public static void Cadastrodados(){
        System.out.print("ID: ");
        int ID=Sc.nextInt();
        System.out.print("Nome: ");
        String Nome=Sc.next();

        System.out.print("Funcionraio=1/Insumo=2/Chapa=3/Obras=4: "); 
        int info=Sc.nextInt();

        if(info==2||info==3){
            CadastroDeMateriais(info, ID,Nome);
        }else if(info==1){
            CadastroDeFuncionario(ID,Nome);
        }else if(info==4){
            CadastrodadoDeObras(ID,Nome);
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

        dados.add(new dados.Funcionario(ID, Nome, telefone, salario, TipoDeContrato.valueOf(TipoContrato), FuncaoNaEmpresa));
    } 
    public static void CadastrodadoDeObras(int ID,String Nome){

        System.out.print("Nome da Empresa: ");
        String NomeEmpresa=Sc.next();
        System.out.print("Valor Bruto a receber: ");
        double ValorBruto=Sc.nextDouble();
        /*
        System.out.print("Data inicial: ");
        String TipoContrato=Sc.next();
        System.out.print("Data Final: ");
        String FuncaoNaEmpresa=Sc.next();
        */
        dados.add(new dados.Obra(ID, Nome, NomeEmpresa, ValorBruto));
    }
}
 