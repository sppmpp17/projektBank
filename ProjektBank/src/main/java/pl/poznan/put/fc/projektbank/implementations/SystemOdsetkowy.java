/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations;

import pl.poznan.put.fc.projektbank.interfaces.Odsetki;

/**
 *
 * @author fenix
 */
public class SystemOdsetkowy {
    private Odsetki odsetki;
    
    public void setSystem(Odsetki odsetki) {
        this.odsetki = odsetki;
    }
    
    public Odsetki getSystem() {
        return odsetki;
    }
    
    public double obliczOdsetki(double kwota) {
        return odsetki.oblicz(kwota);
    }
}
