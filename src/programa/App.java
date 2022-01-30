package programa;

import java.util.Scanner;




public class App {
    static Scanner Sc=new Scanner(System.in);
    static UI Ui=new UI();
    
    public static void main(String[] args) throws Exception {
        try{
            Ui.LogicaIndicador();
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        finally{
            System.out.print("Fim do Programa!");
            Sc.close();
        }
        
    }
}
 