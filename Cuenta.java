/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
/**
 *
 * @author estudiante
 */
public class Cuenta {
    private int id;
    private double Balance;
    private double TasaDeInteresAnual;
    private Date FechaDeCreacion;
    
    public Cuenta(){
        
    }

    public Cuenta(int id, double Balance) {
        this.id = id;
        this.Balance = Balance;
    }


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public Double getTasaDeInteresAnual() {
        return TasaDeInteresAnual;
    }

    public void setTasaDeInteresAnual(Double TasaDeInteres) {
        this.TasaDeInteresAnual = TasaDeInteres;
    }

    public Date getFechaDeCreacion() {
        return FechaDeCreacion;
    }

    public Double CalcularInteresAual(){
        Double Temp;
        Temp = this.Balance * this.TasaDeInteresAnual;
        return Temp;
    }
    
    public void DepositarDinero(double Dinero){
        this.Balance = this.Balance + Dinero;
      
    }
    public void RetirarDinero(double Dinero){
        this.Balance = this.Balance - Dinero;
        
    }

    
}