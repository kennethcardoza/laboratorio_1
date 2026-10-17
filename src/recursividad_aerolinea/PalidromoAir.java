package recursividad_aerolinea;

/**
 *
 * @author kendr
 */
public class PalidromoAir {
    
    public Ticket[]asientos;
    public int capacidad=30;
    public double precioBase=100.00f;
    public double descuento=0.20;
    
    public PalidromoAir(){
        asientos= new Ticket[capacidad];
    }
    
}
