/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.operacje;

import pl.poznan.put.fc.projektbank.implementations.produkty.Kredyt;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;

/**
 *
 * @author fenix
 */
public class ZaciagniecieKredytu implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.ZACIAGNIECIE_KREDYTU;
    private final Kredyt kredyt;
    private final double wielkosc;
    
    public ZaciagniecieKredytu(Kredyt kredyt, double wielkosc) {
        this.kredyt = kredyt;
        this.wielkosc = wielkosc;
    }
    
    @Override
    public void wykonaj() {
        OperacjaBankowa wyplata = new Wyplata(kredyt, wielkosc);
        OperacjaBankowa wplata = new Wplata(kredyt.getRachunekBankowy(), wielkosc);
        kredyt.wykonajOperacje(wyplata);
        kredyt.getRachunekBankowy().wykonajOperacje(wplata);
    }
    
}
