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
public class Direccion {
    private String provincia;
    private String canton;
    private String distrito;

    public Direccion(String provincia, String canton, String distrito) {
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Provincia: " + provincia + " Canton: " + canton + " Distrito: " + distrito;
    }
    
    
}
