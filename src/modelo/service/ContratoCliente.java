package modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.Cliente;
import modelo.service.Estoque;

public class ContratoCliente{
    Scanner Sc=new Scanner(System.in);
    List<Cliente>clientes=new ArrayList<>();

    public void Indicador(){
        CadastraCliente();
        CadastraObra();
        GastoObra();
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
    
    public void CadastraObra(){
        Cliente Idclientes=VerificadorId();
        ControleDeObra controleDeObra=Idclientes.Obra();
        controleDeObra.AdicionarObra();

    }
    public void VisualizarEstoque(Estoque e){
        
    }
    public void GastoObra(){
        Cliente Idclientes=VerificadorId();
        ControleDeObra controleDeObra=Idclientes.Obra();
        controleDeObra.EstO();
    }
    public Cliente VerificadorId(){
        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        Cliente Idfuncionario=clientes.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
        return Idfuncionario;             

    }
}