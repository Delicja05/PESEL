package lab01a;

import java.util.Scanner;
/**
 * Klasa, kt�ra na podstawie podanego numeru PESEL sprawdza jego poprawno��, przelicza na dat� urodzenia oraz okre�la p�e�
 * @author Alicja Dewicka
 * @version 1.0
 *
 */
class Kalkulator{
	
    /**
     * Pole przechowuje numer PESEL w tablicy
     */
    private static int PESEL[];
    /**
     * Pole przechowuje p�e� 
     */
    public static int plec; 
    /**
     * Pole przechowuje dzie�  urodzenia 
     */
    public static int dzien;
    /**
     * Pole przechowuje miesi�c  urodzenia 
     */
    public static int miesiac;
    /**
     * Pole przechowuje rok urodzenia 
     */
    public static int rok;
    
    /**
     * Metoda, kt�ra sprawdza poprawno�� numeru PESEL
     * @param pesel numer PESEL
     * @return prawda lub fa�sz
     * @throws PESELException informacja o b��dzie
     */    
    static boolean sprawdzNumerPESEL(String pesel) throws PESELException{
    	
    	int dlugosc = pesel.length();
    	if(dlugosc !=11)
    		throw new PESELException("Dlugosc numeru PESEL niepoprawna");
    	PESEL = new int[11];
    	   	
    	try{
             for(int i=0;i<11;i++){
            	 String c=pesel.substring(i,i+1);
            	 PESEL[i] = Integer.parseInt(c);         
             }
             
             int suma = 1 * PESEL[0] + 
            		 3 * PESEL[1] + 
            		 7 * PESEL[2] + 
            		 9 * PESEL[3] + 
            		 1 * PESEL[4] + 
            		 3 * PESEL[5] + 
            		 7 * PESEL[6] + 
            		 9 * PESEL[7] + 
            		 1 * PESEL[8] + 
            		 3 * PESEL[9] + 
            		 1 * PESEL[10];
             
             if(suma%10!=0) {
            	 return false;
             }
             else {
            	 dzien = PESEL[4]*10+PESEL[5];
            	 miesiac = PESEL[2]*10+PESEL[3];
            	 rok = PESEL[0]*10+PESEL[1];
            	 plec = PESEL[9];
             }
         }
         catch (IndexOutOfBoundsException e){
             throw new PESELException("Dlugosc numeru PESEL niepoprawna");                
         }
         catch (NumberFormatException e){
             throw new PESELException("Numer PESEL powinien zawiera� tylko cyfry");
         }
    	return true;
    }
    
    /**
     * Metoda, kt�ra zwraca dat� urodzenia
     * @return data - data urodzenia
     * @throws  PESELException informacja o b��dzie
     */    
    static String dataUrodzenia() {
    	     	
         if (miesiac > 0 && miesiac < 13) {
         	rok += 1900;
         }
         else if (miesiac > 20 && miesiac < 33) {
         	miesiac -= 20;
         	rok += 2000;
         }
         else if (miesiac > 40 && miesiac < 53) {
         	miesiac -= 40;
         	rok += 2100;
         }
         else if (miesiac > 60 && miesiac < 73) {
         	miesiac -= 60;
         	rok += 2200;
         }
         else if (miesiac > 80 && miesiac < 93) {
        	 miesiac -= 80;
         	rok += 1800;
         } 
         
         if (miesiac > 0 && miesiac < 13) {
        	 if ((dzien >0 && dzien < 32) && (miesiac == 1 || miesiac == 3 || miesiac == 5 || miesiac == 7 || miesiac == 8 || miesiac == 10 || miesiac == 12)) {
        		 return ((dzien < 10) ? "0" : "") + dzien + "-" + ((miesiac < 10) ? "0" : "") + miesiac + "-" + rok;
        	 }
             else if ((dzien >0 && dzien < 31) && (miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11)) {
            	 return ((dzien < 10) ? "0" : "") + dzien + "-" + ((miesiac < 10) ? "0" : "") + miesiac + "-" + rok;
             }
             else if ((dzien >0 && dzien < 30 && miesiac == 2 && rok % 4 == 0) || (dzien >0 && dzien < 29 && miesiac == 2 && rok % 4 != 0)) {
            	 return ((dzien < 10) ? "0" : "") + dzien + "-" + ((miesiac < 10) ? "0" : "") + miesiac + "-" + rok;
             }
             else {
            	 throw new PESELException("Numer PESEL niepoprawny");
             }
         }
         else
        	 throw new PESELException("Niepoprawny miesiac");
         
    }
    
    /**
     * Metoda, kt�ra zwraca p�e�
     * @return p�e� - Kobieta lub M�czyzna
     */    
    static String Plec(){
    	    	
    	if(plec%2==0)
    		return "Kobieta";
    	else
    		return "Mezczyzna";
    }    
}
/**
 * Klasa odpowiada za pobranie numeru PESEL od u�ytkownika oraz wy�wietlenia go
 * @author Alicja Dewicka
 * @version 1.0
 *
 */
class Aplikacja{
	
	/**
	 * Pole przechowuje podany numer PESEL
	 */
	private static String NumerPesel="";
	/**
	 * Pole przechowuje informacje o poprawno�ci numeru PESEL
	 */
	private static boolean poprawnosc = false;
	
	/**
	 * Konstruktor
	 */
	public Aplikacja() {};	
    
	/**
     * Metoda, kt�ra pobiera numer PESEL od u�ytkownika
     */
    public static void pobierzNumer() {
    	
    	System.out.println("Podaj numer PESEL: ");
        Scanner pobierz = new Scanner(System.in);
        NumerPesel = pobierz.nextLine();
        
        try {
        	poprawnosc=Kalkulator.sprawdzNumerPESEL(NumerPesel);    	
    	}
    	catch (PESELException e) {
    		System.out.printf("Blad: " + e);
    	}
        finally {
        	if(poprawnosc) {
        		wyswietlDane();
        	}
        	else
        		System.out.println("\nTaki numer PESEL nie mo�e istniec\n");
        }                
    }
    
    /**
     * Metoda, kt�ra wy�wietla dane na podstawie numeru PESEL
     */
    public static void wyswietlDane() {
    	
    	System.out.println("Data urodzenia: "+ Kalkulator.dataUrodzenia());
    	System.out.println("Plec: "+ Kalkulator.Plec());    	    	
    }
}
/**
 * Klasa odpowiadaj�ca za wy�wietlenie informacji o b��dzie
 * @author Alicja Dewicka
 * @version 1.0
 *
 */
class PESELException extends ArithmeticException{
	/**
	 * Konstruktor
	 * @param msg wiadomo�� dotycz�ca wyj�tku
	 */
    public PESELException(String msg){
    	super(msg);
    }
}
/**
 * Klasa zawieraj�ca g��wn� funkcj� main, uruchomienie aplikacji
 * @author Alicja Dewicka
 * @version 1.0
 *
 */
public class Start {
    /**
     * @param args the command line arguments, nie s� wymagane
     */
    public static void main(String[] args) {
             
    	Aplikacja.pobierzNumer();
    }           
}