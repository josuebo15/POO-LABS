/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidnow;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelado.Alerta;
import modelado.Direccion;
import modelado.JSONParse;
import modelado.Registro;
import modelado.Usuario;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class PantallaLoginController implements Initializable {
    
    private Usuario nuevoUsuario;
    ArrayList<Registro> registrosAlDia;
    private JSONParse parse;
    int todosLosCasosPorDia;
    ArrayList<Registro> registroDeCasosCompleto;
    
    @FXML
    private Button bttConsultar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtProvincia;
    @FXML
    private TextField txtCanton;
    @FXML
    private TextField txtDistrito;
    @FXML
    private TextField txtNumeroPlaca;
    
    @FXML
    private Label labError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.parse=new JSONParse();

    }    

    @FXML
    private void hacerConsulta(ActionEvent event) throws Exception {
        Alerta alerta;
        String nombre= this.txtNombre.getText();
        String provincia= this.txtProvincia.getText();
        String distrito= this.txtDistrito.getText();
        String canton= this.txtCanton.getText();
        String placaString=this.txtNumeroPlaca.getText();
        
        int placa;
        Direccion direccionARevisar= new Direccion(provincia, canton, distrito);
        try{
           char ultimoDigito= placaString.charAt(placaString.length()-1);
           placa=ultimoDigito-0x30;
        }catch(Exception e){
           placa=0;
        }
            
        this.nuevoUsuario= new  Usuario (nombre, direccionARevisar, placa);
      
        parse.makeTheJsonForAlertas();
        alerta= parse.generarAlerta(this.nuevoUsuario, provincia, canton, distrito, placa);
        if(alerta==null){
            labError.setText("El cantón no cuenta con casos, o se ingresó incorrectamente");
        }else{
            System.out.println(alerta.toString());
            iniciarPantallaPrincipal(alerta);
        }
     
    }
    public void recibirParametro(ArrayList<Registro> registrosAlDia,  int todosLosCasosPorDia, ArrayList<Registro> registroDeCasosCompleto){
        this.registrosAlDia= registrosAlDia;
        this.todosLosCasosPorDia=todosLosCasosPorDia;
        this.registroDeCasosCompleto=registroDeCasosCompleto;
    }
    
    @FXML private void iniciarPantallaPrincipal(Alerta alerta) throws Exception{
        Stage pantallaPrincipal= new Stage();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("pantallaPrincipal.fxml"));
        Parent root= loader.load();
        PantallaPrincipalController controller = loader.<PantallaPrincipalController>getController();
        controller.recibeParametros(this.nuevoUsuario, this.registrosAlDia, this.registroDeCasosCompleto,alerta, this.todosLosCasosPorDia);
        Scene scene = new Scene(root);
        pantallaPrincipal.setScene(scene);
   
       pantallaPrincipal.show();
    }

    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }
    
}
