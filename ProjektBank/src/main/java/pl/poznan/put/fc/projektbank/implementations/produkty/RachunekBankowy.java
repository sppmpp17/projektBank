/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import java.time.LocalDate;
import pl.poznan.put.fc.projektbank.interfaces.IRachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.ProduktBankowy;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;
import pl.poznan.put.fc.projektbank.interfaces.Visitable;

/**
 *
 * @author fenix
 */
public class RachunekBankowy implements ProduktBankowy, IRachunekBankowy, Visitable {
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

    public long GetNumerRachunku()
    {
    	return idRachunku;
    }

    @Override
    public double getStanRachunku() {
        return stanRachunku;
    }

    @Override
    public void setStanRachunku(double stanRachunku) {
        this.stanRachunku = stanRachunku;
    }

    @Override
    public void wykonajOperacje(OperacjaBankowa operacja) {
        operacja.wykonaj();
    }

    @Override
    public void wykonajWplate(double wielkosc) {
        stanRachunku += wielkosc;
    }

    @Override
    public void wykonajWyplate(double wielkosc) {
        stanRachunku -= wielkosc;
    }

    @Override
    public void setSystemOdsetek(SystemOdsetek systemOdsetek) {
        this.systemOdsetek = systemOdsetek;
    }

    @Override
    public SystemOdsetek getSystemOdsetek() {
        return systemOdsetek;
    }

    @Override
    public void Accept(Raport InVisitor)
    {
            InVisitor.Visit(this);

    }
}
