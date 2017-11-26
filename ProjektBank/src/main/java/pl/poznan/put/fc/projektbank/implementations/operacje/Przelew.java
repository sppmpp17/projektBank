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
public class Przelew implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.PRZELEW;
    
    private final RachunekBankowy rachunekBankowyNadawcy;
    private final RachunekBankowy rachunekBankowyOdbiorcy;
            
    private final double wielkoscPrzelewu;
    
    public Przelew(RachunekBankowy rachunekNadawcy, RachunekBankowy rachunekOdbiorcy, double wielkoscPrzelewu) {
        this.rachunekBankowyNadawcy = rachunekNadawcy;
        this.rachunekBankowyOdbiorcy = rachunekOdbiorcy;
        this.wielkoscPrzelewu = wielkoscPrzelewu;
    }
    
    @Override
    public void wykonaj() {
        OperacjaBankowa wyplata = new Wyplata(rachunekBankowyNadawcy, wielkoscPrzelewu);
        OperacjaBankowa wplata = new Wplata(rachunekBankowyOdbiorcy, wielkoscPrzelewu);
        rachunekBankowyNadawcy.wykonajOperacje(wyplata);
        rachunekBankowyOdbiorcy.wykonajOperacje(wplata);
    }
    
}
