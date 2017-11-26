/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.testy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.poznan.put.fc.projektbank.implementations.mechdebet.SystemOdsetekA;
import pl.poznan.put.fc.projektbank.implementations.operacje.Przelew;
import pl.poznan.put.fc.projektbank.implementations.operacje.Wplata;
import pl.poznan.put.fc.projektbank.implementations.operacje.Wyplata;
import pl.poznan.put.fc.projektbank.implementations.produkty.KontoDebetowe;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.IRachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author fenix
 */
public class TestyBank {
    private RachunekBankowy rachunekNad;
    private RachunekBankowy rachunekOdb;
    private SystemOdsetek sysOdsA;
    
    public TestyBank() {
    }

    
    @Before
    public void setUp() {
        rachunekNad = new RachunekBankowy(1, null); // id=1, SystemOdsetek=brak
        rachunekOdb = new RachunekBankowy(1, null); // id=2, SystemOdsetek=brak
        sysOdsA = new SystemOdsetekA(rachunekNad);
    }
    
    @Test
    public void testPrzelewu() {
        rachunekNad.setStanRachunku(100);
        rachunekOdb.setStanRachunku(0);
        OperacjaBankowa przelew = new Przelew(rachunekNad, rachunekOdb, 100);
        rachunekNad.wykonajOperacje(przelew);
        assertEquals(0, rachunekNad.getStanRachunku(), 0.00001);
        assertEquals(100, rachunekOdb.getStanRachunku(), 0.00001);
    }
    
    @Test
    public void testWplaty() {
        rachunekNad.wykonajOperacje(new Wplata(rachunekNad,100));
        assertEquals(100, rachunekNad.getStanRachunku(), 0.00001);
    }
    
    @Test
    public void testWyplaty() {
        rachunekNad.setStanRachunku(100);
        rachunekNad.wykonajOperacje(new Wyplata(rachunekNad,100));
        assertEquals(0, rachunekNad.getStanRachunku(), 0.00001);
    }
    
    @Test
    public void testOdsetek() {
        rachunekNad.setStanRachunku(10000);
        sysOdsA.naliczOdsetki();
        assertEquals(11000, rachunekNad.getStanRachunku(), 0.00001);
    }
    
    @Test
    public void testkontoDebetowe() {
        rachunekNad.setStanRachunku(100);
        IRachunekBankowy rachDeb = new KontoDebetowe(rachunekNad, 1000);
        assertEquals(1100, rachDeb.getStanRachunku(), 0.0001);
    }
    
    @After
    public void tearDown() {
        rachunekNad = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
