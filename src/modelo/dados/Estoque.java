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
        System.out.println("Irá adicionar ou remover item [A/r]: ");
        char modificador=Sc.next().charAt(0);
        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        System.out.print("Estoque ou Chapa[1/0]: ");
        int y=Sc.nextInt();
        if(y==1){
            Insumo insumos=insumo.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            if(insumos!=null){
                if(modificador=='a'||modificador=='A'){
                    addInsumo(insumos);
                }else{
                    diminuirinsumo(insumos);
                }
            }
        }else{
            Chapa chapas=chapa.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            if(chapas!=null){
                if(modificador=='a'||modificador=='A'){
                    addChapa(chapas);
                }else{
                    diminuirChapa(chapas);
                }
            }
        } 
    } 
    public void addInsumo(Insumo insumos){
        System.out.print("Local onde foi comprado: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        int quatidade=Sc.nextInt();
        System.out.print("preco unitario: ");
        double PrecoUnicario=Sc.nextInt();
        insumos.aumentarItem(LocalDaCompra,quatidade,PrecoUnicario);
    }
    public void diminuirinsumo(Insumo insumos){
        System.out.print("Que item você deseja modificar: ");
        int quatidade=Sc.nextInt();
        insumos.diminuirItem(quatidade);
    }

    public void addChapa(Chapa chapas){
        System.out.print("Local onde foi comprado: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        Double metroQuadrado=Sc.nextDouble();
        System.out.print("preco unitario: ");
        double ValorPorMetroQuadrado=Sc.nextInt();
        chapas.aumentarItem(LocalDaCompra, metroQuadrado, ValorPorMetroQuadrado);
    }
    public void diminuirChapa(Chapa chapas){
        System.out.print("Que item você deseja modificar: ");
        double metroQuadrado=Sc.nextDouble();
        chapas.diminuirItem(metroQuadrado);
        
    }
}
