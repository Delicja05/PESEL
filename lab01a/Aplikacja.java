package lab01a;

import java.util.Scanner;

/**
 * Klasa odpowiada za pobranie numeru PESEL od uzytkownika oraz wyswietlenia go
 * @author Alicja Dewicka
 * @version 1.0
 */
public class Aplikacja{
	
	/**
	 * Pole przechowuje podany numer PESEL
	 */
	private static String NumerPesel = "";
	
	/**
	 * Pole przechowuje informacje o poprawnosci numeru PESEL
	 */
	private static boolean poprawnosc = false;
	
	/**
	 * Konstruktor
	 */
	public Aplikacja(){};	
    
	/**
     * Metoda, ktora pobiera numer PESEL od uzytkownika
     */
    public static void pobierzNumer(){
    	
    	System.out.println("Podaj numer PESEL: ");
        Scanner pobierz = new Scanner(System.in);
        NumerPesel = pobierz.nextLine();
        
        try{
        	poprawnosc = Kalkulator.sprawdzNumerPESEL(NumerPesel);    	
    	}
    	catch (PESELException e){
    		System.out.printf("Blad: " + e);
    	}
        finally{
        	if(poprawnosc)
        		wyswietlDane();        	
        	else
        		System.out.println("\nTaki numer PESEL nie mo¿e istniec\n");
        }                
    }
    
    /**
     * Metoda, ktora wyswietla dane na podstawie numeru PESEL
     */
    public static void wyswietlDane(){
    	
    	try{
    		System.out.println("Data urodzenia: "+ Kalkulator.dataUrodzenia());
        	System.out.println("Plec: "+ Kalkulator.Plec());  
    	}
    	catch (PESELException e){
    		System.out.printf("Blad: " + e);
    	}  	    	
    }
}