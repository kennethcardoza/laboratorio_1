package recursividad_aerolinea;

/**
 *
 * @author kendr
 */
public class Ticket {
    public static String nombrePasajero;
    public static int montoOriginal=100;
    public static int montoPagado;
    public static boolean palindromo;

    public static String getNombrePasajero() {
        return nombrePasajero;
    }

    public static void setNombrePasajero(String nombrePasajero) {
        Ticket.nombrePasajero = nombrePasajero;
    }

    public static int getMontoOriginal() {
        return montoOriginal;
    }

    public static void setMontoOriginal(int montoOriginal) {
        Ticket.montoOriginal = montoOriginal;
    }

    public static int getMontoPagado() {
        return montoPagado;
    }

    public static void setMontoPagado(int montoPagado) {
        Ticket.montoPagado = montoPagado;
    }

    public static boolean isPalindromo() {
        return palindromo;
    }

    public static void setPalindromo(boolean palindromo) {
        Ticket.palindromo = palindromo;
    }
    
    
}
