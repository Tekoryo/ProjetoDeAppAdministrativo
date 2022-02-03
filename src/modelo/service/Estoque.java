package modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import modelo.entities.Chapa;
import modelo.entities.DomanException;
import modelo.entities.Insumo;

public class Estoque {
    private Scanner Sc=new Scanner(System.in);
    private List<Insumo>insumo=new ArrayList<>();
    private List<Chapa>chapa=new ArrayList<>();
    protected char Sair;
    int s=1;// Isso garante que ira haver o loop;
    
    public void Indicador() {
        do {
            System.out.println("==== Menu do Estoque ====");
            System.out.println("cadastrar, modificar ou visualizar [1/2/3]: ");

            int apontar=Sc.nextInt();
            switch(apontar){
                case 1:
                    Cadastraitem();
                    break;
                case 2:
                    modificaritem();
                    break;
                case 3:
                    ViewEstoque();
                    break;
                    default:
                    System.out.println("Opisao invalida! ");
                    s=0;
                    Sair='N';
                    break;

                }
                if(s == 1){
                    System.out.print("Sair [s/N]: ");
                    Sair=Sc.next().charAt(0);               
                }
            } while (Sair!='S'||Sair!='s');
       
        }
        protected void Cadastraitem(){
            do{
                System.out.println("==== Menu de Cadastro ====");
                System.out.print("Cadastra chapa ou Insumo [1/0]: ");
                int apontar=Sc.nextInt();
                System.out.print("ID: ");
                int ID=Sc.nextInt();
                while(hasID(apontar,ID)){
                    System.out.print("DIgite um ID não utilizado: ");
                    ID=Sc.nextInt();
                }
                System.out.print("Nome: ");
                String Nome=Sc.next();
                switch(apontar){
                    case 1:
                            Insumo Novoinsumo=new Insumo(ID,Nome); 
                            insumo.add(Novoinsumo);
                        break;
                    case 2:
                            System.out.print("Espessura: ");
                            double Espessura=Sc.nextDouble();
                            Chapa NovaChapa=new Chapa(ID,Nome,Espessura); 
                            chapa.add(NovaChapa);
                        break;
                    default:
                            System.out.println("Opisao invalida! ");
                            Sair='N';
                            s=0;
                        break;
                }
                if(s == 1){
                    System.out.print("Sair [s/N]: ");
                    Sair=Sc.next().charAt(0);               
                }
        }while(Sair!='S'||Sair!='s');
    }
    protected void modificaritem(){
        int N=0,apontar;
        do{
            System.out.println("==== menu de Modifição ====");
            System.out.print("Estoque ou Chapa[1/0]: ");
            apontar=Sc.nextInt();

            if(apontar == 1||apontar == 0){
                System.out.println("Irá adicionar ou remover item [1/0]: ");
                N=Sc.nextInt();
            }
            switch(apontar){
                case 1:
                        Insumo IdInsumos=VerificarId(1);
                        if(IdInsumos!=null){
                            if(N==1){
                                addInsumo(IdInsumos);
                            }else{
                                diminuirinsumo(IdInsumos);
                            }
                        }
                    break;
                case 2:
                        Chapa IdChapa=VerificarId(2);
                        if(IdChapa!=null){
                            if(N==1){
                                addChapa(IdChapa);
                            }else{
                                diminuirChapa(IdChapa);
                            }
                        }
                    break;
                default:
                        System.out.println("Opção invalida! ");
                        Sair='N';
                        s=0;
                    break;
            }
            if(s == 1){
                System.out.print("Sair [s/N]: ");
                Sair=Sc.next().charAt(0);               
            }
        }while(Sair!='S'||Sair!='s');
    } 
    protected void addInsumo(Insumo IdInsumos){
        System.out.println("==== Adicionar Insumo ====");
        System.out.print("Local onde foi comprado: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        int quatidade=Sc.nextInt();
        System.out.print("preco unitario: ");
        double PrecoUnicario=Sc.nextInt();
        IdInsumos.aumentarItem(LocalDaCompra,quatidade,PrecoUnicario);
    }
    protected void diminuirinsumo(Insumo IdInsumos){
        System.out.println("==== Remove Insumo ====");
        System.out.print("Que item você deseja modificar: ");
        int quatidade=Sc.nextInt();
        IdInsumos.diminuirItem(quatidade);
    }

    protected void addChapa(Chapa IdChapa){
        System.out.println("==== Adicionar Chapa ====");
        System.out.print("Local onde foi comprado: ");
        String LocalDaCompra=Sc.next();
        System.out.print("Quantidade: ");
        Double metroQuadrado=Sc.nextDouble();
        System.out.print("preco unitario: ");
        double ValorPorMetroQuadrado=Sc.nextInt();
        IdChapa.aumentarItem(LocalDaCompra, metroQuadrado, ValorPorMetroQuadrado);
    }
    protected void diminuirChapa(Chapa IdChapa){
        System.out.println("==== Remove Chapa ====");
        System.out.print("Que item você deseja modificar: ");
        double metroQuadrado=Sc.nextDouble();
        IdChapa.diminuirItem(metroQuadrado);
        
    }
    public void ViewEstoque(){
        System.out.println("==== Visualiza Estoque ====");
        System.out.println("Chapa, Insumo ou Todos[1/2/3]: ");
        int apontar=Sc.nextInt();
        switch(apontar){
            case 1:
                    ViewChapa();
                break;
            case 2:
                    ViewInsumo ();   
                break;
            case 3:
            default:
                    ViewChapa();
                    ViewInsumo();
                break;
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
    public <T> T VerificarId(int tipo){
        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        if(tipo!=2){
            Insumo IdInsumos=insumo.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            return (T) IdInsumos;
        }else{
            Chapa IdChapa=chapa.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
            return (T) IdChapa;
        }
    } 
    public boolean hasID(int tipo,int ID){
        if(tipo!=2){
            Insumo IdInsumos=insumo.stream().filter(x -> x.getID()==ID).findFirst().orElse(null);
            return IdInsumos !=null;
        }else{
            Chapa IdChapa=chapa.stream().filter(x -> x.getID()==ID).findFirst().orElse(null);
            return IdChapa !=null;
        }
    } 
}
