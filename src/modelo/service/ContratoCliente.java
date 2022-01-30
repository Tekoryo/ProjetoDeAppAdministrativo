package modelo.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.Cliente;
import modelo.service.Estoque;

public class ContratoCliente{
    Scanner Sc=new Scanner(System.in);
    List<Cliente>clientes=new ArrayList<>();

    public void Indicador() throws ParseException{

        System.out.println("==== Estoque ====");
        System.out.print("Cadastrar, cadastrar obra, Gasto da obra, Visualizar cliente ou visualizar do cliente [1/2/3/4/5]: ");
        int N=Sc.nextInt();
        if(N==1){
            CadastraCliente();
        }else if(N==2){
            CadastraObra();
        }else if(N==3){
            GastoObra();
        }else if(N==4){
            VisualizarCliente();
        }else if(N==5){
            VisualizarObraDoCliente();
        }

    }

    public void CadastraCliente(){
        System.out.print("ID: ");
        int ID=Sc.nextInt();
        System.out.print("Nome: ");
        String Nome=Sc.next();
        System.out.print("CPF ou CNPJ [1/0]: ");
        int PFPJ=Sc.nextInt();
        if(PFPJ==1){
            System.out.print("Digite o CPF: ");
            int CPF=Sc.nextInt();
            clientes.add(new Cliente(ID,Nome,CPF));
        }else{
            System.out.print("Digite o CNPJ: ");
            int CNPJ=Sc.nextInt();
            clientes.add(new Cliente(ID,Nome,CNPJ));
        }
    }
    
    public void CadastraObra() throws ParseException{
        Cliente Idclientes=VerificadorId();
        ControleDeObra controleDeObra=Idclientes.Obra();
        controleDeObra.AdicionarObra();
    }
    public void GastoObra(){
        Cliente Idclientes=VerificadorId();
        ControleDeObra controleDeObra=Idclientes.Obra();
        controleDeObra.ControledeGasto();
    }
    
    public void VisualizarObraDoCliente(){
        Cliente Idclientes=VerificadorId();
        ControleDeObra controleDeObra=Idclientes.Obra();
        controleDeObra.VisualizarObra();
    }
    public void VisualizarCliente(){
        System.out.println("==== Visualiza Todos os cliente ====");
        for(Cliente c:clientes){
            System.out.println(c.toString());
            
            for(int x=0;x<c.toString().length();x++){
                System.out.print("_");
            }
            System.out.println("");
        }
    }
    
    public Cliente VerificadorId(){
        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        Cliente idCliente=clientes.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
        return idCliente;             

    }
}