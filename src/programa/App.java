package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.CadastroDeDados;
import modelo.entities.Cliente;
import modelo.entities.Obra;
import modelo.service.ContratoCliente;
import modelo.service.ContratoDeFuncionario;
import modelo.service.ControleDeObra;
import modelo.service.Estoque;


public class App {
    static Scanner Sc=new Scanner(System.in);
    static Logica logica=new Logica();
    
    public static void main(String[] args) throws Exception {
        try{
            logica.LogicaIndicador();
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        finally{
            System.out.print("Fim do Programa!");
            Sc.close();
        }
        
    }
}
 