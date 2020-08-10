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
public class Registro {
    private String dia;
    private int casos;
    private int recuperados;
    private int muertes;
    private int activos;

    public Registro(String dia, int casos, int recuperados, int muertes) {
        this.dia = dia;
        this.casos = casos;
        this.recuperados = recuperados;
        this.muertes = muertes;
        this.activos= casos-recuperados;
    }
    
    

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getCasos() {
        return casos;
    }

    public void setCasos(int casos) {
        this.casos = casos;
    }

    public int getRecuperados() {
        return recuperados;
    }

    public void setRecuperados(int recuperados) {
        this.recuperados = recuperados;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public int getActivos() {
        return activos;
    }

    public void setActivos(int activos) {
        this.activos = activos;
    }

   
  
    

    @Override
    public String toString() {
        return "Registro:  "+"Día "+dia+" Cantidad de casos: "+casos+ " Cantidad De Muertes: "+muertes+ " Cantidad De Recuperados: "+ recuperados+ " Casos ACTIVOS: "+activos;
    }

    
    
    
    
    
}
