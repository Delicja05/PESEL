package lab01a;

/**
 * Klasa odpowiadająca za wyswietlenie informacji o bledzie
 * @author Alicja Dewicka
 * @version 1.0
 */
public class PESELException extends ArithmeticException{
	
	/**
	 * Konstruktor
	 * @param msg wiadomosc dotycząca wyjatku
	 */
    public PESELException(String msg){
    	super(msg);
    }
}