package modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entities.Funcionario;
import modelo.entities.enums.TipoDeContrato;

public class ContratoDeFuncionario {
    Scanner Sc=new Scanner(System.in);
    List<Funcionario>funcionarios=new ArrayList<>();
    protected char Sair;
    int s=1;
    public void Indicador(){
        do{
            System.out.println("==== Contrato de funcionario  ====");
            System.out.println("Cadastro, Modificar, Stataus, Atualizar ou Visualizar [1/2/3/4/5]:");
            int apontar=Sc.nextInt();

            switch (apontar) {
                case 1:
                        CadastroDeFuncionario();
                    break;
                case 2:
                        modificarSalario();
                    break;
                case 3:
                        status();
                    break;
                case 4:
                        atualizandodados();
                    break;
                case 5:
                        viewFuncionario();
                    break;
                default:
                        System.out.println("Opisao invalida! ");
                        s=0;
                        Sair='N';
                    break;
            }
            if(s==1){
                System.out.print("Sair [s/N]: ");
                Sair=Sc.next().charAt(0);
            }
        }while(Sair!='s'||Sair!='S');
    }

    public void CadastroDeFuncionario(){
        do{
            System.out.println("==== Menu de Cadastro de funcionario ====");
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

            System.out.print("Sair [s/N]: ");
            Sair=Sc.next().charAt(0);
        }while(Sair!='s'||Sair!='S');
            
    }
    public void modificarSalario(){
        System.out.println("==== Menu de Modificador de Salario ====");
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
        switch (StatusItem) {
            case 'D','d':
                    Idfuncionario.status(false); 
                break;
            case 'R','r':
                if(Idfuncionario.getStatusDoContrato()==true){
                    System.out.print("O funcionario: "+Idfuncionario+" se encontra contratado.");
                }else{
                    System.out.print("O funcionario: "+Idfuncionario+" se encontra demitido.");
                }
            break;
            default:
                    System.out.println("Opção Invalida!");
                    System.out.println("Voltando ao menu inicial....");
                break;
        }
    }
    public void atualizandodados(){
        do{
            System.out.println("==== Atualizar dados de funcionario ====");
            Funcionario Idfuncionario=VerificadorId();
            System.out.println("Quais dados pretende atualizar: ");
            System.out.print("Nome, Telefone, Função ou modelo de contrato ou todos[N/T/F/C/A]: ");
            //colocar um nome melhor
            char c=Sc.next().charAt(0);
            switch (c) {
                case 'N','n':
                        System.out.print("Novo Nome: ");
                        String nome=Sc.next();
                        Idfuncionario.setNome(nome);                    
                    break;
                case 'T','t':
                        System.out.print("Novo Telefone: ");
                        long telefone=Sc.nextLong();
                        Idfuncionario.setTelefone(telefone);
                case 'F','f':
                        System.out.print("Novo Função: ");
                        String FuncaoNaEmpresa=Sc.next();
                        Idfuncionario.setFuncaoNaEmpresa(FuncaoNaEmpresa);
                    break;
                case 'C','c': 
                        System.out.print("Novo Função: ");
                        String TipoContrato=Sc.next();
                        Idfuncionario.setTipoContrato(TipoDeContrato.valueOf(TipoContrato));
                    break;
                case 'A','a': 
                        System.out.print("Novo Nome: ");
                        nome=Sc.next();
                        System.out.print("Novo Telefone: ");
                        telefone=Sc.nextLong();
                        System.out.print("Novo Tipo de Contratação: ");
                        TipoContrato=Sc.next();
                        System.out.print("Nova Função na empresa: ");
                        FuncaoNaEmpresa=Sc.next();
                        Idfuncionario.AtualizandoTodosDados( nome, telefone, TipoDeContrato.valueOf(TipoContrato), FuncaoNaEmpresa);
                    break;
                default:
                        System.out.println("Alternativa invalida!");
                        s=0;
                        Sair='N';
                    break;
            }
            if(s==1){
                System.out.print("Sair [s/N]: ");
                Sair=Sc.next().charAt(0);
            }
        }while(Sair!='s'||Sair!='S');
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
    public boolean hasID(int ID){
        Funcionario idFuncionario=funcionarios.stream().filter(x ->x.getID()==ID).findFirst().orElse(null);
        return idFuncionario !=null;
    } 
}
