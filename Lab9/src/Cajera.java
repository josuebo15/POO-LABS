
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cajera {
    private String nombre;

    public Cajera(String nombre) {
        this.nombre = nombre;
    }
    
    public void procesarCompra(Cliente cliente, long timeStamp){
        
        long tiempo = System.currentTimeMillis() - timeStamp/1000;
        System.out.println("La cajera " + this.nombre + "comienza a procesar la compra de " + cliente.getNombre() + "en el tiempo " + tiempo);
        
        for(int i = 0; i < cliente.getCarroCompra().length; i++){
            this.esperarXsegundos(1);
            tiempo = (System.currentTimeMillis() - timeStamp)/1000;
            System.out.println("procesando el producto" + i + "código " + cliente.getCarroCompra()[i] + "en el timpo " + tiempo + "seg");
        }
        tiempo = (System.currentTimeMillis() - timeStamp)/1000;
        System.out.println("La cajera " + this.nombre + "comienza a procesar la compra de " + cliente.getNombre() + "en el tiempo " + tiempo);
        
    }
    
    private void esperarXsegundos(int segundos){
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cajera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
