/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.operacje;

import pl.poznan.put.fc.projektbank.implementations.produkty.Lokata;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;

/**
 *
 * @author fenix
 */
public class ZalozenieLokaty implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.ZALOZENIE_LOKATY;
    private final Lokata lokata;
    private final double wielkosc;
    
    public ZalozenieLokaty(Lokata lokata, double wielkosc) {
        this.lokata = lokata;
        this.wielkosc = wielkosc;
    }
    
    @Override
    public void wykonaj() {
        OperacjaBankowa wplata = new Wplata(lokata, wielkosc);
        OperacjaBankowa wyplata = new Wyplata(lokata.getRachunekBankowy(), wielkosc);
        lokata.wykonajOperacje(wplata);
        lokata.getRachunekBankowy().wykonajOperacje(wyplata);
    }
    
}
