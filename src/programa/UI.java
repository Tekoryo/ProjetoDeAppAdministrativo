package programa;

import java.util.Scanner;

import modelo.entities.Cliente;
import modelo.service.ContratoCliente;
import modelo.service.ContratoDeFuncionario;
import modelo.service.ControleDeObra;
import modelo.service.Estoque;

public class Logica {
    Scanner Sc=new Scanner(System.in);
    protected Estoque estoque=new Estoque();
    protected ContratoDeFuncionario contratoDeFuncionario=new ContratoDeFuncionario();
    protected ContratoCliente contratoCliente=new ContratoCliente();

    public void LogicaIndicador(){
        
        System.out.println("==== Bem-Vindo ====");
        System.out.print("Estoque, Clinete ou Funcionario [1/2/3]:");
        int x=Sc.nextInt();

        if(x==1){
            estoque.Indicador();
        }else if(x==2){
            contratoCliente.Indicador();
        }else if(x==3){
            contratoDeFuncionario.Indicador();
        }
    }
}
