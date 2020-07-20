
public class Main {

    public static void main(String[] args) {
        /*
        Cliente cliente = new Cliente("Josue");
        Cajera cajera = new Cajera("Marta");
        long tiempoinicial = System.currentTimeMillis();
        cajera.procesarCompra(cliente, tiempoinicial);
        Cliente cliente2 = new Cliente("Pedro");
        Cajera cajero = new Cajera("Daniel");
        cajera.procesarCompra(cliente, tiempoinicial);
        */
        
        
        Cliente cliente = new Cliente("Josue");
        Cliente cliente2 = new Cliente("Pedro");
        long tiempoInicial = System.currentTimeMillis();
        
        CajeraThread cajera = new CajeraThread("Marta", cliente, tiempoInicial);
        CajeraThread cajero = new CajeraThread("Daniel", cliente2, tiempoInicial);
        
        cajera.start();
        cajero.start();
    }
    
}