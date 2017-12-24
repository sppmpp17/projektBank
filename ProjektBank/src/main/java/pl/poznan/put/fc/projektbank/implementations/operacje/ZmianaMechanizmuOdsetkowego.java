/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.operacje;

import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author fenix
 */
public class ZmianaMechanizmuOdsetkowego implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.ZMIANA_MECHANIZMU_ODSETKOWEGO;
    private final RachunekBankowy rachunek;
    private final SystemOdsetek systemOds;
    
    public ZmianaMechanizmuOdsetkowego(RachunekBankowy rachunek, SystemOdsetek systemOds) {
        this.rachunek = rachunek;
        this.systemOds = systemOds;
    }
    
    @Override
    public void wykonaj() {
        rachunek.setSystemOdsetek(systemOds);
    }
    
}
