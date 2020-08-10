/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

/**
 *
 * @author bryan
 */
public class Usuario {
    private String nombre;
    private Direccion direccion;
    private int numeroDePlaca;

    public Usuario(String nombre, Direccion direccion, int numeroDePlaca) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroDePlaca = numeroDePlaca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getNumeroDePlaca() {
        return numeroDePlaca;
    }

    public void setNumeroDePlaca(int numeroDePlaca) {
        this.numeroDePlaca = numeroDePlaca;
    }

    @Override
    public String toString() {
        return "Usuario:"+" "+nombre+" "+ "Vivo en "+direccion+" Y mi placa es: "+numeroDePlaca;
    }
    
    
}
