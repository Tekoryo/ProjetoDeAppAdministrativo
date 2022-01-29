package modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import modelo.entities.Chapa;
import modelo.entities.Insumo;

public class Estoque {
    private Scanner Sc=new Scanner(System.in);
    private List<Insumo>insumo=new ArrayList<>();
    private List<Chapa>chapa=new ArrayList<>();
    
    public void Indicador(){
        System.out.println("==== Estoque ====");
        System.out.print("Cadastrar, modificar ou Visualizar [1/2/3]: ");
        int N=Sc.nextInt();
        if(N==1){
            Cadastraitem();
        }else if(N==2){
            modificaritem();
        }else{
            ViewEstoque();
        }
    }
    protected void Cadastraitem(){
        System.out.println("==== Cadastro de Estoque ====");
        System.out.print("ID: ");
        int ID=Sc.nextInt();
        System.out.print("Nome: ");
        String Nome=Sc.next();
        System.out.print("Cadastra chapa ou Insumo [1/0]: ");
        int N=Sc.nextInt();
        if(N!=1){
            Insumo Novoinsumo=new Insumo(ID,Nome); 
            insumo.add(Novoinsumo);
        }else{
            System.out.print("Espessura: ");
            double Espessura=Sc.nextDouble();
            Chapa NovaChapa=new Chapa(ID,Nome,Espessura); 
            chapa.add(NovaChapa);
        }
    }
    protected void modificaritem(){
        System.out.println("==== Modificardor do Estoque ====");
        System.out.println("Irá adicionar ou remover item [1/0]: ");
        int N=Sc.nextInt();
        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        System.out.print("Estoque ou Chapa[1/0]: ");
        int y=Sc.nextInt();
        if(y==1){
            Insumo insumos=insumo.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            if(insumos!=null){
                if(N==1){
                    addInsumo(insumos);
                }else{
                    diminuirinsumo(insumos);
                }
            }
        }else{
            Chapa chapas=chapa.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            if(chapas!=null){
                if(N==1){
                    addChapa(chapas);
                }else{
                    diminuirChapa(chapas);
                }
            }
        } 
    } 
    protected void addInsumo(Insumo insumos){
        System.out.println("==== Adicionar Insumo ====");
        System.out.print("Local onde foi comprado: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        int quatidade=Sc.nextInt();
        System.out.print("preco unitario: ");
        double PrecoUnicario=Sc.nextInt();
        insumos.aumentarItem(LocalDaCompra,quatidade,PrecoUnicario);
    }
    protected void diminuirinsumo(Insumo insumos){
        System.out.println("==== Remove Insumo ====");
        System.out.print("Que item você deseja modificar: ");
        int quatidade=Sc.nextInt();
        insumos.diminuirItem(quatidade);
    }

    protected void addChapa(Chapa chapas){
        System.out.println("==== Adicionar Chapa ====");
        System.out.print("Local onde foi comprado: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        Double metroQuadrado=Sc.nextDouble();
        System.out.print("preco unitario: ");
        double ValorPorMetroQuadrado=Sc.nextInt();
        chapas.aumentarItem(LocalDaCompra, metroQuadrado, ValorPorMetroQuadrado);
    }
    protected void diminuirChapa(Chapa chapas){
        System.out.println("==== Remove Chapa ====");
        System.out.print("Que item você deseja modificar: ");
        double metroQuadrado=Sc.nextDouble();
        chapas.diminuirItem(metroQuadrado);
        
    }
    public void ViewEstoque(){
        System.out.println("==== Visualiza Estoque ====");
        int x=Sc.nextInt();
        if(x==1){
            ViewChapa();
        }else if(x==2){
            ViewInsumo();
        }else{
            ViewChapa();
            ViewInsumo();
        }
    }
    public void ViewChapa(){
        System.out.println("==== Visualiza Estoque de Chapa ====");
        for(Chapa c: chapa){
            System.out.println(c.toString());
            
            for(int x=0;x<c.toString().length();x++){
                System.out.print("_");
            }
            System.out.println("");
        }
    }
    public void ViewInsumo(){
        System.out.println("==== Visualiza Estoque de Insumo ====");
        for(Insumo i: insumo){
            System.out.println(i.toString());
            
            for(int x=0;x<i.toString().length();x++){
                System.out.print("_");
            }
            System.out.println("");
        }
    }
    
}
