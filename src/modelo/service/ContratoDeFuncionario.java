package modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.Funcionario;
import modelo.entities.enums.TipoDeContrato;

public class ContratoDeFuncionario {
    Scanner Sc=new Scanner(System.in);
    List<Funcionario>funcionarios=new ArrayList<>();

    public void Indicador(){
        System.out.println("==== Bem-Vindo ao Contrato de funcionario  ====");
        System.out.println("Cadastro, Modificar, Stataus, Atualizar ou Visualizar [1/2/3/4/5]:");
        int N=Sc.nextInt();
        if(N==1){
            CadastroDeFuncionario();
        }else if(N==2){
            modificarSalario();
        }else if(N==3){
            status();
        }else if(N==4){
            atualizandodados();
        }else if(N==5){
            viewFuncionario();
        }else{
            System.out.println("[Erro]");
        }
    }

    public void CadastroDeFuncionario(){
        System.out.println("==== Cadastro de funcionario ====");
        System.out.print("ID: ");
        int ID=Sc.nextInt();
        System.out.print("Nome: ");
        String Nome=Sc.next();
        System.out.print("telefone: ");
        Long telefone=Sc.nextLong();
        System.out.print("salario: ");
        double salario=Sc.nextDouble();
        System.out.print("Tipo de Contratação: ");
        String TipoContrato=Sc.next();
        System.out.print("Função na empresa: ");
        String FuncaoNaEmpresa=Sc.next();

        funcionarios.add(new modelo.entities.Funcionario(ID, Nome, telefone, salario, TipoDeContrato.valueOf(TipoContrato), FuncaoNaEmpresa));
    }
    public void modificarSalario(){
        System.out.println("==== Modificador de Salario ====");
        Funcionario Idfuncionario=VerificadorId();
        System.out.print("Valor do novo salario: ");
        double salario=Sc.nextDouble();
        Idfuncionario.MudancaSalario(salario);
    }
    public void status(){
        System.out.println("==== Status funcionario ====");
        Funcionario Idfuncionario=VerificadorId();
        System.out.print("Demitir, Recontratar ou Verificar[D/R/V]: ");
        char StatusItem=Sc.next().charAt(0);
        if(StatusItem=='D'||StatusItem=='d'){
            Idfuncionario.status(false);
        }else if(StatusItem=='R'||StatusItem=='r'){
            Idfuncionario.status(true);
        }else if(StatusItem=='V'||StatusItem=='v'){
            if(Idfuncionario.getStatusDoContrato()==true){
                System.out.print("O funcionario: "+Idfuncionario+" se encontra contratado.");
            }else{
                System.out.print("O funcionario: "+Idfuncionario+" se encontra demitido.");
            }
        }
    }
    public void atualizandodados(){
        System.out.println("==== Atualizar dados de funcionario ====");
        Funcionario Idfuncionario=VerificadorId();
        System.out.println("Quais dados pretende atualizar: ");
        System.out.print("Nome, Telefone, Função ou modelo de contrato ou todos[N/T/F/C/A]: ");
        //colocar um nome melhor
        char c=Sc.next().charAt(0);
            if(c=='N'||c=='n'){
                System.out.print("Novo Nome: ");
                String nome=Sc.next();
                Idfuncionario.setNome(nome);
            }else if(c=='T'||c=='t'){
                System.out.print("Novo Telefone: ");
                long telefone=Sc.nextLong();
                Idfuncionario.setTelefone(telefone);
            }else if(c=='F'||c=='f'){
                System.out.print("Novo Função: ");
                String funcaoNaEmpresa=Sc.next();
                Idfuncionario.setFuncaoNaEmpresa(funcaoNaEmpresa);
            }else if(c=='C'||c=='c'){
                System.out.print("Novo Função: ");
                String TipoContrato=Sc.next();
                Idfuncionario.setTipoContrato(TipoDeContrato.valueOf(TipoContrato));
            }else if(c=='A'||c=='a'){
                System.out.print("Novo Nome: ");
                String nome=Sc.next();
                System.out.print("Novo Telefone: ");
                Long telefone=Sc.nextLong();
                System.out.print("Novo Tipo de Contratação: ");
                String TipoContrato=Sc.next();
                System.out.print("Nova Função na empresa: ");
                String FuncaoNaEmpresa=Sc.next();
                Idfuncionario.AtualizandoTodosDados( nome, telefone, TipoDeContrato.valueOf(TipoContrato), FuncaoNaEmpresa);
            }else{
                System.out.println("Alternativa invalida!");
            }
        
    }

    public void viewFuncionario(){
        System.out.println("==== Visualiza Lista de funcionario ====");
        for(Funcionario f: funcionarios){
            System.out.println(f.toString());
            
            for(int x=0;x<f.toString().length();x++){
                System.out.print("_");
            }
            System.out.println("");
        }
    }

    public Funcionario VerificadorId(){

        System.out.print("ID que Deseja: ");
        int Buscar=Sc.nextInt();
        Funcionario Idfuncionario=funcionarios.stream().filter(x -> x.getID()==Buscar).findFirst().orElse(null);
        return Idfuncionario;             

    }

}
