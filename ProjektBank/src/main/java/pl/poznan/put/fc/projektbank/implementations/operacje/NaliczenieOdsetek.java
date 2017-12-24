/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.operacje;

import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;

/**
 *
 * @author fenix
 */
public class NaliczenieOdsetek implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.NALICZENIE_ODSETEK;
    private final RachunekBankowy rachunek;
    private final double oprocentowanie;
    
    public NaliczenieOdsetek(RachunekBankowy rachunek, double oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
        this.rachunek = rachunek;
    }
    
    @Override
    public void wykonaj() {
        double stanAktualny = rachunek.getStanRachunku();
        rachunek.setStanRachunku(stanAktualny+stanAktualny*oprocentowanie/100.0);
    }
    
}
