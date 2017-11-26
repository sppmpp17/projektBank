/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import pl.poznan.put.fc.projektbank.implementations.operacje.SplataKredytu;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author fenix
 */
public class Kredyt extends RachunekBankowy {
    private final RachunekBankowy rachunek;
    
    public Kredyt(long id, SystemOdsetek systemOdsetek, RachunekBankowy rachunek) {
        super(id, systemOdsetek);
        this.rachunek = rachunek;
    }
    
    public RachunekBankowy getRachunekBankowy() { 
        return rachunek;
    }
    
    public void zerwijLokate() {
        OperacjaBankowa zerwanieLokaty = new SplataKredytu(this);
        zerwanieLokaty.wykonaj();
    }
}
