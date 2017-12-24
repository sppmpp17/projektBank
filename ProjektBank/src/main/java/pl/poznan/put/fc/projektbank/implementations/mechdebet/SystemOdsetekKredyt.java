/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.mechdebet;

import pl.poznan.put.fc.projektbank.implementations.operacje.NaliczenieOdsetek;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author fenix
 */
public class SystemOdsetekKredyt implements SystemOdsetek {
    private final RachunekBankowy rachunek;
    
    public SystemOdsetekKredyt(RachunekBankowy rachunek) {
        this.rachunek = rachunek;
    }

    @Override
    public void naliczOdsetki() {
        double stan = rachunek.getStanRachunku();
        OperacjaBankowa nalOds;
        if(stan < 100) {
            nalOds = new NaliczenieOdsetek(rachunek, 5);
        } else if(stan >= 100 && stan < 10000) {
            nalOds = new NaliczenieOdsetek(rachunek, 7);
        } else {
            nalOds = new NaliczenieOdsetek(rachunek, 10);
        }
        rachunek.wykonajOperacje(nalOds);
    }
}
