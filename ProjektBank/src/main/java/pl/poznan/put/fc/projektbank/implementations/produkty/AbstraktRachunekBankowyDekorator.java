/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import pl.poznan.put.fc.projektbank.implementations.operacje.Wplata;
import pl.poznan.put.fc.projektbank.implementations.operacje.Wyplata;
import pl.poznan.put.fc.projektbank.interfaces.IRachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.MechanizmDebetowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author inf83973
 */
public abstract class AbstraktRachunekBankowyDekorator implements IRachunekBankowy {
    protected RachunekBankowy rachunek;
    private final double maksymalnyDebet;
    private double stanDebetu;
    private MechanizmDebetowy mechanizmDebetowy;

    public AbstraktRachunekBankowyDekorator(RachunekBankowy rachunek, double limit) {
        this.rachunek = rachunek;
        this.maksymalnyDebet = limit;
        this.stanDebetu = 0.0;
    }
    
    
    public MechanizmDebetowy getMechanizmDebetowy() {
        return mechanizmDebetowy;
    }

    public void setMechanizmDebetowy(MechanizmDebetowy mechanizmDebetowy) {
        this.mechanizmDebetowy = mechanizmDebetowy;
    }

    public double getMaksyalnyDebet() {
        return maksymalnyDebet;
    }
    
    @Override
    public void wykonajOperacje(OperacjaBankowa operacja) {
        operacja.wykonaj();
    }
    
    @Override
    public void setStanRachunku(double stanRachunku) {
        rachunek.setStanRachunku(stanRachunku);
    }
    
    @Override
    public double getStanRachunku() {
        return rachunek.getStanRachunku() + maksymalnyDebet;
    }
    
    @Override
    public void wykonajWplate(double wielkosc) {
        stanDebetu -= wielkosc;
        if(stanDebetu < 0.0) {
            double nadmiar = -1.0 * stanDebetu;
            stanDebetu = 0.0;
            OperacjaBankowa wplata = new Wplata(rachunek, nadmiar);
            rachunek.wykonajOperacje(wplata);
        }
    }
    
    @Override
    public void wykonajWyplate(double wielkosc) {
        double stanRach = rachunek.getStanRachunku();
        double roznica = stanRach - wielkosc;
        OperacjaBankowa wyplata = new Wyplata(rachunek, roznica < 0.0 ? stanRach : wielkosc);
        rachunek.wykonajOperacje(wyplata);
        if(roznica < 0.0) {
            stanDebetu += -1.0 * roznica;
        }
    }
    
    @Override
    public void setSystemOdsetek(SystemOdsetek systemOdsetek) {
        rachunek.setSystemOdsetek(systemOdsetek);
    }

    @Override
    public SystemOdsetek getSystemOdsetek() {
        return rachunek.getSystemOdsetek();
    }
}
