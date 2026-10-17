package recursividad_aerolinea;

public class Ticket {

    public String nombrePasajero;
    public int montoOriginal=100;
    public int montoPagado;
    public boolean palindromo;

    public Ticket(String nombrePasajero, double montoOriginal,
                  double montoPagado, boolean palindromo) {

        this.nombrePasajero=nombrePasajero;
        this.montoOriginal=(int)montoOriginal;
        this.montoPagado=(int)montoPagado;
        this.palindromo=palindromo;
    }

    public String getNombrePasajero(){
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero){
        this.nombrePasajero = nombrePasajero;
    }

    public int getMontoOriginal(){
        return montoOriginal;
    }

    public void setMontoOriginal(int montoOriginal){
        this.montoOriginal=montoOriginal;
    }

    public int getMontoPagado(){
        return montoPagado;
    }

    public void setMontoPagado(int montoPagado){
        this.montoPagado=montoPagado;
    }

    public boolean isPalindromo() {
        return palindromo;
    }

    public void setPalindromo(boolean palindromo){
        this.palindromo=palindromo;
    }
}
