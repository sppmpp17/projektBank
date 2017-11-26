/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.interfaces;

/**
 *
 * @author inf83973
 */
public interface IRachunekBankowy {
    public double getStanRachunku();

    public void setStanRachunku(double stanRachunku);

    public void wykonajOperacje(OperacjaBankowa operacja);
    
    public void wykonajWplate(double wielkosc);
    
    public void wykonajWyplate(double wielkosc);
    
    public void setSystemOdsetek(SystemOdsetek systemOdsetek);

    public SystemOdsetek getSystemOdsetek();
}
