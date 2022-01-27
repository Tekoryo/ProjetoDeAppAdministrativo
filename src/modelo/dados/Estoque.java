package modelo.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    private Scanner Sc=new Scanner(System.in);
    private List<Insumo>insumo=new ArrayList<>();
    private List<Chapa>chapa=new ArrayList<>();
    
    public Estoque(){

    }

    public void Cadastraitem(){

        System.out.print("ID: ");
        int ID=Sc.nextInt();
        System.out.print("Nome: ");
        String Nome=Sc.next();
        System.out.print("Cadastra chapa ou Insumo [C/i]: ");
        char X=Sc.next().charAt(0);
        if(X=='i'||X=='I'){
            Insumo Novoinsumo=new Insumo(ID,Nome); 
            insumo.add(Novoinsumo);
        }else{
            System.out.print("Espessura: ");
            double Espessura=Sc.nextDouble();
            Chapa NovaChapa=new Chapa(ID,Nome,Espessura); 
            chapa.add(NovaChapa);
        }
    }
    public void modificaritem(){
        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        System.out.print("Estoque ou Chapa[1/0]: ");
        int y=Sc.nextInt();
        if(y==1){
            Insumo insumos=insumo.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            if(insumos!=null){
                System.out.print("Que item você deseja modificar: ");
                int quatidade=Sc.nextInt();
                insumos.setQuantidade(quatidade);
                
            }
        }else{
            Chapa chapas=chapa.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            if(chapas!=null){
                System.out.print("Que item você deseja modificar: ");
                int quatidade=Sc.nextInt();
                chapas.setQuantidade(quatidade);
            }
        } 
    }
}
