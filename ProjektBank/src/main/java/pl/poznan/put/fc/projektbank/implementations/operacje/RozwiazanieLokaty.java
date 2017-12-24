/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.operacje;

import java.time.LocalDate;
import pl.poznan.put.fc.projektbank.implementations.produkty.Lokata;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author fenix
 */
public class RozwiazanieLokaty implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.ROZWIAZANIE_LOKATY;
    private final Lokata lokata;
    
    public RozwiazanieLokaty(Lokata lokata) {
        this.lokata = lokata;
    }
    
    @Override
    public void wykonaj() {
        if(lokata.getTerminDo().isBefore(LocalDate.now())) {
            SystemOdsetek system = lokata.getSystemOdsetek();
            system.naliczOdsetki();
        }
    }
    
}
