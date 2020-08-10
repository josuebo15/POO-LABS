/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class Alerta {
    private String tipo;
    private ArrayList<String> espaciosAbiertos;
    private String noCirculan;
    private String horaDeCirculacion;
    private String lugarDeConsulta;
    private Usuario usuario;
    private int numeroDePlaca;

    public Alerta(Usuario usuario, String tipo, ArrayList<String> espaciosAbiertos, String noCirculan, String horaDeCirculacion, String lugarDeConsulta) {
        this.tipo = tipo;
        this.espaciosAbiertos = espaciosAbiertos;
        this.noCirculan = noCirculan;
        this.horaDeCirculacion = horaDeCirculacion;
        this.lugarDeConsulta = lugarDeConsulta;
        this.usuario=usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getEspaciosAbiertos() {
        return espaciosAbiertos;
    }

    public void setEspaciosAbiertos(ArrayList<String> espaciosAbiertos) {
        this.espaciosAbiertos = espaciosAbiertos;
    }

    public String getNoCirculan() {
        return noCirculan;
    }

    public void setNoCirculan(String noCirculan) {
        this.noCirculan = noCirculan;
    }

    public String getHoraDeCirculacion() {
        return horaDeCirculacion;
    }

    public void setHoraDeCirculacion(String horaDeCirculacion) {
        this.horaDeCirculacion = horaDeCirculacion;
    }

    public String getLugarDeConsulta() {
        return lugarDeConsulta;
    }

    public void setLugarDeConsulta(String lugarDeConsulta) {
        this.lugarDeConsulta = lugarDeConsulta;
    }

    public int getNumeroDePlaca() {
        return numeroDePlaca;
    }

    public void setNumeroDePlaca(int numeroDePlaca) {
        this.numeroDePlaca = numeroDePlaca;
    }
   
    public String impresionLugares(){
        String mensaje="";
        for(int i=0; i<this.espaciosAbiertos.size();i++){
            mensaje=mensaje+"-"+this.espaciosAbiertos.get(i)+"\n";
        }
        return mensaje;
    }

    @Override
    public String toString() {
        return "Consulta:\n"+this.usuario.getNombre()+"\n"+
                "\n"+"Tu consulta está en alerta:\n"+this.tipo+"\n"+"\n"+
                "Puedes ir a los siguientes lugares: "+"\n"+impresionLugares()+"\n"+"\n"+
                "Con tu placa NO puedes transitar:\n"+this.noCirculan+"\n"+"Los demás días puedes transitar de: \n"+this.horaDeCirculacion;
    }
    
    

    
}
