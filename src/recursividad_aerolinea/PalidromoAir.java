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

    //Cambios Kendrick, impresion de los nombres de los psajeros y vender tickets



    //imprimir pasajeros
    public int printPassengers(int i) {

    if (i>=capacidad) {
        return 0;
    }

    if (i==0){
        System.out.println("Lista de pasajeros: ");
    }

    if (asientos[i]!=null) {
        System.out.println("Asiento: " + (i + 1));
        System.out.println("Nombre: " + asientos[i].nombrePasajero);
        System.out.println("Monto pagado: " + asientos[i].montoPagado);
        System.out.println("Monto original: " + precioBase);
        System.out.println("Es palindromo: "+isPalindromo(asientos[i].nombrePasajero,0,asientos[i].nombrePasajero.length() - 1));
        System.out.println("---");
        return 1 + printPassengers(i + 1);
    }
    return printPassengers(i + 1);
}




    //vender lso tickes 
    public boolean sellTicket(String nombre) {

    if (nombre==null || nombre.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "ingrese un nombre valido");
        return false;
    }
    int asiento=firstAvailable(0);
    if (asiento==-1) {
        JOptionPane.showMessageDialog(null, "No hay asientos libres");
        return false;
    }
    if (searchPassenger(nombre, 0) !=-1) {
        JOptionPane.showMessageDialog(null, "Pasajero ya registrado");
        return false;
    }

    boolean palindromo=isPalindromo(nombre, 0, nombre.length()-1);
    double monto=precioBase;

    if (palindromo) {
        monto=precioBase-(precioBase*descuento);
    }

    asientos[asiento]=new Ticket(nombre, precioBase, monto, palindromo);

    JOptionPane.showMessageDialog(null,"Boleto vendido correctamente\n"+"Asiento: "+(asiento+1)+"\n"+"Pasajero: "+nombre+"\n"+"Monto original: $"+precioBase+"\n"+"Monto pagado: $"+monto+"\n"+"Es palindromo: "+palindromo);
    return true;
}
    
    
   
    
}
