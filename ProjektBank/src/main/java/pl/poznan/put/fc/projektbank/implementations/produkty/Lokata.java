/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import java.time.LocalDate;
import pl.poznan.put.fc.projektbank.implementations.operacje.RozwiazanieLokaty;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author fenix
 */
public class Lokata extends RachunekBankowy {
    private LocalDate terminDo;
    private final RachunekBankowy rachunek;
    
    public Lokata(long id, SystemOdsetek systemOdsetek, RachunekBankowy rachunek, LocalDate terminDo) {
        super(id, systemOdsetek);
        this.rachunek = rachunek;
        this.terminDo = terminDo;
    }
    
    public RachunekBankowy getRachunekBankowy() { 
        return rachunek;
    }

    public LocalDate getTerminDo() {
        return terminDo;
    }

    public void setTerminDo(LocalDate terminDo) {
        this.terminDo = terminDo;
    }

    public void zerwijLokate() {
        OperacjaBankowa zerwanieLokaty = new RozwiazanieLokaty(this);
        zerwanieLokaty.wykonaj();
    }
}
