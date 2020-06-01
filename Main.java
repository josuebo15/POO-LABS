/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante
 */
public class Main {    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cuenta Nueva = new Cuenta(12, 10000);
        System.out.println(Nueva.getBalance());
        
        Nueva.DepositarDinero(150000);
        System.out.println(Nueva.getBalance());
        
        Nueva.RetirarDinero(200000);
        System.out.println(Nueva.getBalance());
        
         // TODO code application logic here
    }
    
}
