/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author estudiante
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Cuenta Nueva = new Cuenta(1, 500000);
        
        Cuenta Nueva1 = new Cuenta(2, 50000);
        
        Cuenta Nueva2 = new Cuenta(3, 50000);
        
        Cuenta Nueva3 = new Cuenta(4, 50000);
        
        Cuenta Nueva4 = new Cuenta(5, 50000);
        
        Cuenta Nueva5 = new Cuenta(6, 50000);
        
        Cuenta Nueva6 = new Cuenta(7, 50000);
        
        Cuenta Nueva7 = new Cuenta(8, 50000);        
        
        Cuenta Nueva8 = new Cuenta(9, 50000);        
        
        Cuenta Nueva9 = new Cuenta(10, 50000);        
        
        ArrayList<Cuenta> cuentas = new ArrayList();
        cuentas.add(Nueva);
        cuentas.add(Nueva1);
        cuentas.add(Nueva2);
        cuentas.add(Nueva3);
        cuentas.add(Nueva4);
        cuentas.add(Nueva5);
        cuentas.add(Nueva6);
        cuentas.add(Nueva7);
        cuentas.add(Nueva8);
        cuentas.add(Nueva9);
        
            
        Scanner ID = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        double retirar;
        double depositar;
        System.out.println("Digite el ID: ");
        
        

        while(!salir ){
            System.out.println("1- Ver el Balance Actual");
            System.out.println("2- Retirar Dinero");
            System.out.println("3- Depositar Dinero");
            System.out.println("4- Salir");
            
            opcion = ID.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println(Nueva.getBalance());
                    System.out.println(Nueva1.getBalance());
                    System.out.println(Nueva2.getBalance());
                    System.out.println(Nueva3.getBalance());
                    System.out.println(Nueva4.getBalance());
                    System.out.println(Nueva5.getBalance());
                    System.out.println(Nueva6.getBalance());
                    System.out.println(Nueva7.getBalance());
                    System.out.println(Nueva8.getBalance());
                    System.out.println(Nueva9.getBalance());
                    break;
                
                case 2:
                    System.out.println("digite cuanto desea retirar: ");
                    Scanner retiro = new Scanner(System.in);
                    retirar = retiro.nextInt();
                    Nueva.RetirarDinero(retirar);
                    Nueva1.RetirarDinero(retirar);
                    Nueva2.RetirarDinero(retirar);
                    Nueva3.RetirarDinero(retirar);
                    Nueva4.RetirarDinero(retirar);
                    Nueva5.RetirarDinero(retirar);
                    Nueva6.RetirarDinero(retirar);
                    Nueva7.RetirarDinero(retirar);
                    Nueva8.RetirarDinero(retirar);
                    Nueva9.RetirarDinero(retirar);
                    break;
                
                case 3:
                    System.out.println("digite cuanto desea depositar: ");
                    Scanner deposito = new Scanner(System.in);
                    depositar = deposito.nextInt();
                    Nueva.DepositarDinero(depositar);
                    Nueva1.DepositarDinero(depositar);
                    Nueva2.DepositarDinero(depositar);
                    Nueva3.DepositarDinero(depositar);
                    Nueva4.DepositarDinero(depositar);
                    Nueva5.DepositarDinero(depositar);
                    Nueva6.DepositarDinero(depositar);
                    Nueva7.DepositarDinero(depositar);
                    Nueva8.DepositarDinero(depositar);
                    Nueva9.DepositarDinero(depositar);
                    break;
                    
                case 4:
                    salir = true;
                    break;
                    
                default:
                    System.out.println("Digite una opcion valida");
                    
            }
        }
                
    }

    
}