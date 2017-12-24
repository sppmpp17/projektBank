/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.operacje;

import pl.poznan.put.fc.projektbank.implementations.produkty.KontoDebetowe;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;

/**
 *
 * @author fenix
 */
public class StworzenieDebetu implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.STWORZENIE_DEBETU;
    private RachunekBankowy rachunek;
    private KontoDebetowe debet;
    private double wielkosc;
    
    public StworzenieDebetu(RachunekBankowy rachunek, KontoDebetowe debet, double wielkosc) {
        this.rachunek = rachunek;
        this.debet = debet;
        this.wielkosc = wielkosc;
    }
    
    @Override
    public void wykonaj() {
        debet = new KontoDebetowe(rachunek, wielkosc);
    }
    
}
