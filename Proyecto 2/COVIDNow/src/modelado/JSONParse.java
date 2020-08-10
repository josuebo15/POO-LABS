package modelado;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bryan
 */
public class JSONParse {
    
    private File file;
    private ObjectMapper mapper;
    private JsonNode nodo;
    private ArrayList toRead;
    private String json;
    
    private int tipoDeAlerta; //1.Alerta Amarilla
    
    
    public JSONParse(){
    }
    
    public void makeTheJsonForCovid(String urlParaVisitar) throws Exception{
        this.json= getHTMLORJSonString(urlParaVisitar);
        generatedJson();    
        
    }
    
    public void makeTheJsonForAlertas() throws Exception{
        this.tipoDeAlerta=3;
        file=new File("Recursos/alertas.json");
        generatedJsoni(file);
        
    }
    
    public static String getHTMLORJSonString(String urlParaVisitar) throws Exception {
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL(urlParaVisitar);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
     
        return resultado.toString();
}
    public void generatedJson(){

        mapper=new ObjectMapper();
        try {
            nodo= mapper.readTree(this.json);
        } catch (IOException ex) {
            Logger.getLogger(JSONParse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Registro> casosPorDia(){
        ArrayList<Registro> registrosAlDia= new ArrayList<>();
        int diaFinal=0;
        for(int i=0; i<nodo.size();i++){
            diaFinal= diaFinal+1;
        }
        
        for(int dia=0; dia<nodo.size();dia++){
            int cantidadDeCasos= nodo.get(dia).get("cases").asInt();
            int cantidadDeMuertes= nodo.get(dia).get("deaths").asInt();
            int cantidadDeRecuperados= nodo.get(dia).get("recovered").asInt();
            Registro registro= new Registro(Integer.toString(diaFinal), cantidadDeCasos,cantidadDeRecuperados, cantidadDeMuertes);
            registrosAlDia.add(registro);
            diaFinal=diaFinal-1;
        }
  
        return registrosAlDia;
    }

    private void generatedJsoni(File file) {
        mapper=new ObjectMapper();
        try {
            nodo= mapper.readTree(file);
        } catch (IOException ex) {
            Logger.getLogger(JSONParse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Alerta generarAlerta(Usuario usuario, String provinciaABuscar, String cantonABuscar, String distritoABuscar, int numeroDePlaca){
        
        Alerta alerta= null;
        
        JsonNode alertaAmarilla= (JsonNode) this.nodo.get("Amarilla");
        JsonNode enAlertaAmarilla= alertaAmarilla.get("En alerta");
        JsonNode enAlertaAmarillaTransita= alertaAmarilla.get("Circulan");
        JsonNode enAlertaAmarillaEstablecimientos= alertaAmarilla.get("Establecimientos Autorizados");
        JsonNode enAlertaAmarillaNoTransita= alertaAmarilla.get("Restricción en circulación");
        String noTransita= enAlertaAmarillaNoTransita.get(numeroDePlaca).asText();
        String transita= enAlertaAmarillaTransita.get(0).asText();
        
        ArrayList<String> lugaresAcceciblesA= new ArrayList();
        for(int i=0; i<enAlertaAmarillaEstablecimientos.size();i++){
            lugaresAcceciblesA.add(enAlertaAmarillaEstablecimientos.get(i).asText());
        }
        
       
        JsonNode alertaNaranja= (JsonNode) this.nodo.get("Naranja");
        JsonNode enAlertaNaranja= alertaNaranja.get("En alerta");
        JsonNode enAlertaNaranjaTransita= alertaNaranja.get("Circulan");
        JsonNode enAlertanaranjaNoTransita= alertaNaranja.get("Restricción en circulación");
        JsonNode enAlertaNaranjaEstablecimientos= alertaNaranja.get("Establecimientos Autorizados");

        String noTransitaN= enAlertanaranjaNoTransita.get(numeroDePlaca).asText();
        String transitaN= enAlertaNaranjaTransita.get(0).asText();
        
        ArrayList<String> lugaresAcceciblesN= new ArrayList();
        for(int i=0; i<enAlertaNaranjaEstablecimientos.size();i++){
            lugaresAcceciblesN.add(enAlertaNaranjaEstablecimientos.get(i).asText());
        }
        
        try{
            JsonNode provincia= (JsonNode) enAlertaAmarilla.get(provinciaABuscar);
            try{
                JsonNode canton= (JsonNode) provincia.get(cantonABuscar);
                try{
                    for(int i=0;i<canton.size();i++){
                        String distrito= canton.get(i).asText();
                        if(distrito.equals(distritoABuscar)){
                            this.tipoDeAlerta=1;
                        }
                    }
                }catch(Exception e){
                }
            }catch(Exception e){
            }
        }catch(Exception e){
        }    
        
        try{
            JsonNode provincia= (JsonNode) enAlertaNaranja.get(provinciaABuscar);
            try{
                JsonNode canton= (JsonNode) provincia.get(cantonABuscar);
                try{
                    for(int i=0;i<canton.size();i++){
                        String distrito= canton.get(i).asText();
                        if(distrito.equals(distritoABuscar)){
                            this.tipoDeAlerta=2;
                        }
                    }
                }catch(Exception e){
                }
            }catch(Exception e){
            }
        }catch(Exception e){
        }   
        
        switch(this.tipoDeAlerta){
            case 1:
      
                Alerta alertaAma= new Alerta(usuario,"Amarilla", lugaresAcceciblesA, noTransita, transita, provinciaABuscar+" "+cantonABuscar+" "+distritoABuscar);
                alerta=alertaAma;
               break;
            case 2:
          
                Alerta alertaNaj= new Alerta(usuario, "Naranja", lugaresAcceciblesN, noTransitaN, transitaN, provinciaABuscar+" "+cantonABuscar+" "+distritoABuscar);
                alerta=alertaNaj;
               break;
            case 3:
                System.out.println("Su ingreso no está en ninguna alerta. O lo ingresó incorrectamente");
                alerta= null;
               break;
    }
        return alerta;
    }

}
