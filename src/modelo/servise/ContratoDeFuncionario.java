package modelo.servise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.Funcionario;
import modelo.entities.enums.TipoDeContrato;

public class ContratoDeFuncionario {
    Scanner Sc=new Scanner(System.in);
    List<Funcionario>funcionario=new ArrayList<>();

    public void CadastroDeFuncionario(int ID,String Nome){

        System.out.print("telefone: ");
        Long telefone=Sc.nextLong();
        System.out.print("salario: ");
        double salario=Sc.nextDouble();
        System.out.print("Tipo de Contratação: ");
        String TipoContrato=Sc.next();
        System.out.print("Função na empresa: ");
        String FuncaoNaEmpresa=Sc.next();

        funcionario.add(new modelo.entities.Funcionario(ID, Nome, telefone, salario, TipoDeContrato.valueOf(TipoContrato), FuncaoNaEmpresa));
    }


}
