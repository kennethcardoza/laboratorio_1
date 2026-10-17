package recursividad_aerolinea;

import javax.swing.JOptionPane;

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
    
    
    //Recursividad
    
    public int firstAvailable(int i){
        
        if(i>=30){
            return -1;
        }
        if(asientos[i]==null){
            return i;
        }
                
        return firstAvailable(i+1);
    }
    
    public int searchPassenger(String nombre, int i){
        
        if(i>=30){
            return -1;
        }
        
        if(asientos[i]!=null){
            if(asientos[i].nombrePasajero.equalsIgnoreCase(nombre)){
                return i;
            }
        }
   
        return searchPassenger(nombre,i+1);
    }
    
    public boolean isPalindromo(String nombre, int ini, int fin){
        if(nombre==null || nombre.trim().isEmpty()){
            return false;
        }
        
        if(ini>=fin){
            return true;
        }
        
        if(nombre.charAt(ini)!=nombre.charAt(fin)){
            return false;
        }
    
        return isPalindromo(nombre,ini+1,fin-1);
    }
    
    
    
    public int printPassengers(int i){
        
        if(i>=30){
            return -1;
        }
        
        if(asientos[i]==null){
            
            return -1;
        }
        
       
        
        
        
        return printPassengers(i+1);
    }
    
    
    public void reset(int i){
        if(i>=30){
            return;
        }
        
        asientos[i]=null;
        
        reset(i+1);
        
    }
    
    public double income(int i){
        if(i>=30){
            return 0;
        }
        
        if(asientos[i]!=null){
            return asientos[i].montoPagado + income(i+1);
        }
        
        
        return income(i+1);
    }
    
    
    //Operacion
    
    public void dispatch(){
        int confirmacion = JOptionPane.showConfirmDialog(null, "Desea realizar el vuelo?", "Confirmar despacho", JOptionPane.YES_NO_OPTION);
        
        if(confirmacion == JOptionPane.YES_OPTION){
        double totalIngresos = income(0);
        JOptionPane.showMessageDialog(null, "Despacho realizado");

        reset(0);

        }
        
        
    }
    
    
    public boolean cancelTicket(String nombre){
        
        
        
       int i = searchPassenger(nombre,0);
       
       
       if(i==-1){
           JOptionPane.showMessageDialog(null, "No se encontro a ningun pasajero que se llame así");
           return false;
       }
       
       
       double reembolso = asientos[i].montoPagado;
       
       
       asientos[i]=null;
       
       JOptionPane.showMessageDialog(null, "Boleto Cancelado, monto reembolsado: "+reembolso);
       
       
       return true;
    }
    
    
    
   
    
}
