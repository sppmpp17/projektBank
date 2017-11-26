/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.ProduktBankowy;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author inf83973
 */
public abstract class AbstraktRachunekBankowyDekorator extends RachunekBankowy {
    protected ProduktBankowy produktBankowy;

    public AbstraktRachunekBankowyDekorator(long id, SystemOdsetek systemOdsetek) {
        super(id, systemOdsetek);
    }
    
    public void setProduktBankowy(ProduktBankowy produktBankowy) {
        this.produktBankowy = produktBankowy;
    }
    
    @Override
    public void wykonajOperacje(OperacjaBankowa opracjaBankowa) {
        if(produktBankowy != null) {
            produktBankowy.wykonajOperacje(opracjaBankowa);
        }
    }
}
