package modelo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelo.entities.Obra;

public class ControleDeObra {
    Scanner Sc=new Scanner(System.in);
    SimpleDateFormat Sdf=new SimpleDateFormat("dd/MM/yyyy");
    List<Obra>obras=new ArrayList<>();
    protected char Sair;
    public void AdicionarObra() throws ParseException{
        do{
            System.out.print("ID: ");
            int ID=Sc.nextInt();
            while(hasID(ID)){
                System.out.print("Digite um ID não utilizado: ");
                ID=Sc.nextInt();
            }
            System.out.print("Nome:");
            String NomeObra=Sc.next();
            System.out.print("Valor Bruto a receber: ");
            double ValorObra=Sc.nextDouble();
            System.out.print("Valor Bruto a receber: ");
            Date Datainicio=Sdf.parse(Sc.next());
            Obra NovaObra=new Obra(ID, NomeObra, ValorObra,Datainicio);
            obras.add(NovaObra);
            System.out.print("Sair [s/N]: ");
            Sair=Sc.next().charAt(0);
        }while(Sair!='s'||Sair!='S');
    }
    public void ControledeGasto(){
        Obra idObra=VerificadorId();
        System.out.println("==== Controle de Gasto ====");
        System.out.print("Valor do Gastos que ira informa: ");
        double valordogasto=Sc.nextDouble();
        idObra.ValorLiquido(valordogasto);
        
    }
    public Obra VerificadorId(){
        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        Obra IdObra=obras.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
        return IdObra;             

    }
    public void VisualizarObra(){
        System.out.println("==== Visualiza Todas as Obras do cliente ====");
        for(Obra o: obras){
            System.out.println(o.toString());
            
            for(int x=0;x<o.toString().length();x++){
                System.out.print("_");
            }
            System.out.println("");
        }
    }
    public boolean hasID(int ID){
        Obra IdObra=obras.stream().filter(x ->x.getID()==ID).findFirst().orElse(null);
        return IdObra !=null;
    } 
}
