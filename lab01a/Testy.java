package lab01a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class Testy{
	
	@Before
    public void setUp(){
    	Kalkulator kalkulator = new Kalkulator();
}
	
	@Test(expected = PESELException.class)
	    public void sprawdzNumerPESEL() throws PESELException{
	        
			Kalkulator.sprawdzNumerPESEL("9708as07727");
	        assertEquals(true, Kalkulator.sprawdzNumerPESEL("01240306080"));
	        assertEquals(false, Kalkulator.sprawdzNumerPESEL("00002145001"));
	} 
	 
	@Test
    public void dataUrodzenia(){
		
        Kalkulator.dzien = 24;
        Kalkulator.miesiac = 12;
        Kalkulator.rok = 97;
        
        assertEquals("24-12-1997", Kalkulator.dataUrodzenia());
	}
	
	@Test
    public void Plec(){
		
        Kalkulator.plec = 4;
        assertEquals("Kobieta", Kalkulator.Plec());

        Kalkulator.plec = 5;
        assertEquals("Mezczyzna", Kalkulator.Plec());
	}	
}