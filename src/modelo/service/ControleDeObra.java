package modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.Obra;

public class ControleDeObra {
    Scanner Sc=new Scanner(System.in);
    List<Obra>obras=new ArrayList<>();

    public void AdicionarObra(){
        System.out.print("ID:");
        int IDObra=Sc.nextInt();
        System.out.print("Nome:");
        String NomeObra=Sc.next();
        System.out.print("Valor Bruto a receber: ");
        double ValorObra=Sc.nextDouble();

        Obra NovaObra=new Obra(IDObra, NomeObra, ValorObra);
    }
    public void GastoObra(){

    }
    public void EstO(){

    }

}
