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
public class Wplata implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.WPLATA;
    private final RachunekBankowy rachunekBankowy;
    private final double wielkoscWlpaty;
    
    public Wplata(RachunekBankowy rachunekBankowy, double wielkoscWplaty) {
        this.rachunekBankowy = rachunekBankowy;
        this.wielkoscWlpaty = wielkoscWplaty;
    }
    
    @Override
    public void wykonaj() {
        rachunekBankowy.setStanRachunku(rachunekBankowy.getStanRachunku() + wielkoscWlpaty);
    }
    
}
