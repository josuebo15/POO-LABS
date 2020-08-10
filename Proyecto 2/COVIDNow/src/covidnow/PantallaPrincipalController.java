/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidnow;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import modelado.Alerta;
import modelado.Registro;
import modelado.Usuario;

/**
 * FXML Controller class
 *
 * @author bryan
 */
public class PantallaPrincipalController implements Initializable {
    
    private Usuario usuario;
    private ArrayList<Registro> registroDeCasos;
    private Alerta alerta;
    int todosLosCasosPorDia;
    ArrayList<Registro> registroDeCasosCompleto;
    
    @FXML
    private CategoryAxis x;
    
    @FXML
    private NumberAxis y;
    
    @FXML
    private LineChart charCasos;
  
    @FXML
    private TextArea txtArea;
    @FXML
    private Button bttPrueba;
    
    @FXML
    private Label labelTMortalidad;

    @FXML
    private Label LabelTasaDeRecu;
    

    /**
     * Initializes the controller class.
     */
    
    public void recibeParametros(Usuario usuario, ArrayList<Registro> registroDeCasos, ArrayList<Registro> registroDeCasosCompleto, Alerta alerta,  int todosLosCasosPorDia){
        this.usuario=usuario;
        this.registroDeCasos=registroDeCasos;
        this.alerta=alerta;
        this.todosLosCasosPorDia=todosLosCasosPorDia;
        this.registroDeCasosCompleto=registroDeCasosCompleto;
        
    }
    public void generarLineChart(){    
        XYChart.Series casos= new XYChart.Series();
        XYChart.Series recuperados= new XYChart.Series();
        XYChart.Series muertos= new XYChart.Series();
        XYChart.Series activos= new XYChart.Series();
        ArrayList<String> dias= new ArrayList<>();
        Double recuperadosAcumulados=0.0;
        Double muertosAcumulados=0.0;
        Double casosAcumulados=0.0;
                
        
        for(int i=this.registroDeCasos.size()-1;i!=0;i--){
            String diaX= registroDeCasos.get(i).getDia();
            int casosY= registroDeCasos.get(i).getCasos();
            int recuperadosY=registroDeCasos.get(i).getRecuperados();
            int muertesY= registroDeCasos.get(i).getMuertes();
            int activosY= registroDeCasos.get(i).getActivos();
            casos.getData().add(new XYChart.Data(diaX, casosY));
            recuperados.getData().add(new XYChart.Data(diaX, recuperadosY));
            muertos.getData().add(new XYChart.Data(diaX, muertesY));
            activos.getData().add(new XYChart.Data(diaX, activosY));
            dias.add(diaX+" ");
        }
        casos.setName("Casos");
        recuperados.setName("Recuperados");
        muertos.setName("Muertes");
        activos.setName("Activos");
        int muertesY= registroDeCasosCompleto.get(0).getMuertes();
        int recuperadosY=registroDeCasosCompleto.get(0).getRecuperados();
        int casosY= registroDeCasosCompleto.get(0).getCasos();
        muertosAcumulados+=muertesY;
        recuperadosAcumulados+=recuperadosY;
        casosAcumulados+=casosY;
     
        this.charCasos.getData().addAll(casos, recuperados, muertos, activos);
        LabelTasaDeRecu.setText(Double.toString((recuperadosAcumulados*100/casosAcumulados))+"%");
        labelTMortalidad.setText(Double.toString((muertosAcumulados*100/casosAcumulados))+"%");
       
    }
    
    public void addAlerta(){
        this.txtArea.setText(this.alerta.toString());
    }
   
   @FXML 
   private void test(){
        generarLineChart();
        addAlerta();
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
