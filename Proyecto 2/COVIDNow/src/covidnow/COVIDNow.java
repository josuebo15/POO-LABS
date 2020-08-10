
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidnow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelado.JSONParse;
import modelado.Registro;
import modelado.Usuario;

/**
 *
 * @author bryan
 */
public class COVIDNow extends Application {

    /**
     * @param args the command line arguments
     */
       @Override
    public void start(Stage primaryStage) throws Exception {
        JSONParse parse= new JSONParse ();
        
        String url= "https://covid19-api.org/api/timeline/CR";
        parse.makeTheJsonForCovid(url);
        
        ArrayList<Registro> registrosCompletos= parse.casosPorDia();
        ArrayList<Registro> registroAcortado=new ArrayList();
        int cantidadAMostrar= registrosCompletos.size()/25;
        for(int i=0; i<registrosCompletos.size();i=i+cantidadAMostrar){
            registroAcortado.add(registrosCompletos.get(i));
        }
        
       
        int todosLosCasosPorDia= registrosCompletos.size();
        Stage pantallaPrincipal= new Stage();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("pantallaLogin.fxml"));
        Parent root= loader.load();
        PantallaLoginController controller = loader.<PantallaLoginController>getController();
        controller.recibirParametro(registroAcortado,todosLosCasosPorDia, registrosCompletos);
        Scene scene = new Scene(root);
        pantallaPrincipal.setScene(scene);
   
        pantallaPrincipal.show();
          
        
       
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    
    
}
