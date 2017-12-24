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
    private RachunekBankowy rachunek;
    private Lokata lokata;
    private double wielkosc;
    
    @Override
    public void wykonaj() {
        
    }
    
}
