package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dados.Dados;
import dados.Insumo;
import dados.enums.TipoDeContrato;


public class App {
    static Scanner Sc=new Scanner(System.in);
    static List<Dados>dados=new ArrayList<>();
    public static void main(String[] args) throws Exception {
        try{
            int x;
            do{
                Cadastrodados();
                System.out.print("Continuar (Sim=1/Não=0)?");
                x=Sc.nextInt();
            }while(x==1);  
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
        System.out.print("Funcionraio = 1/Insumo=2: "); 
        int info=Sc.nextInt();

        if(info==2){
            CadastroDeInsumo(ID,Nome);
        }else if(info==1){
            CadastroDeFuncionario(ID,Nome);
        }
    }
    public static void CadastroDeInsumo(int ID,String Nome){
        System.out.print("Local da compra: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        int Quantidade=Sc.nextInt();
        System.out.print("Valor: ");
        double Preco=Sc.nextDouble();
        dados.add(new Insumo(ID, Nome, LocalDaCompra, Quantidade, Preco));
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
}
 