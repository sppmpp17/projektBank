/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import java.time.LocalDate;
import pl.poznan.put.fc.projektbank.implementations.operacje.Przelew;
import pl.poznan.put.fc.projektbank.implementations.operacje.Wplata;
import pl.poznan.put.fc.projektbank.implementations.operacje.Wyplata;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.ProduktBankowy;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author fenix
 */
public class RachunekBankowy implements ProduktBankowy {
    private final long idRachunku;
    private final LocalDate dataZalozenia;
    private double stanRachunku;
    private SystemOdsetek systemOdsetek;
    
    public RachunekBankowy(long id, SystemOdsetek systemOdsetek) {
        idRachunku = id;
        stanRachunku = 0.0;
        dataZalozenia = LocalDate.now();
        this.systemOdsetek = systemOdsetek;
    }
    
    //@Override
    public double getStanRachunku() {
        return stanRachunku;
    }

    //@Override
    public void setStanRachunku(double stanRachunku) {
        this.stanRachunku = stanRachunku;
    }

    // Do przemyslenia ?????
    @Override
    public void wykonajOperacje(OperacjaBankowa operacja) {
        operacja.wykonaj();
    }
    
    public void setSystemOdsetek(SystemOdsetek systemOdsetek) {
        this.systemOdsetek = systemOdsetek;
    }

    public SystemOdsetek getSystemOdsetek() {
        return systemOdsetek;
    }
}
