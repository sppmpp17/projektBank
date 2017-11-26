/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.produkty;

import pl.poznan.put.fc.projektbank.interfaces.MechanizmDebetowy;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;
import pl.poznan.put.fc.projektbank.interfaces.SystemOdsetek;

/**
 *
 * @author inf83973
 */
public class KontoDebetowe extends AbstraktRachunekBankowyDekorator {
    private MechanizmDebetowy mechanizmDebetowy;
    private double maksymalnyDebet;

    public KontoDebetowe(long id, SystemOdsetek systemOdsetek, MechanizmDebetowy mechanizmDebetowy, double maksymalnyDebet) {
        super(id, systemOdsetek);
        this.mechanizmDebetowy = mechanizmDebetowy;
        this.maksymalnyDebet = maksymalnyDebet;
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

    public void setMaksyalnyDebet(double maksyalnyDebet) {
        this.maksymalnyDebet = maksyalnyDebet;
    }
    
    @Override
    public double getStanRachunku() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStanRachunku(double stan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void wykonajOperacje(OperacjaBankowa opracjaBankowa) {
        super.wykonajOperacje(opracjaBankowa);
        // Dodatkowa operacja debetowa !!!!
    }
}
