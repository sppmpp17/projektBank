/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations.operacje;

import pl.poznan.put.fc.projektbank.implementations.produkty.Kredyt;
import pl.poznan.put.fc.projektbank.interfaces.OperacjaBankowa;

/**
 *
 * @author fenix
 */
public class SplataKredytu implements OperacjaBankowa {
    private static final TypOperacji TYP = TypOperacji.SPLATA_KREDYTU;
    private final Kredyt kredyt;

    public SplataKredytu(Kredyt kredyt) {
        this.kredyt = kredyt;
    }
    
    @Override
    public void wykonaj() {
        kredyt.getSystemOdsetek().naliczOdsetki();
    }
    
}
