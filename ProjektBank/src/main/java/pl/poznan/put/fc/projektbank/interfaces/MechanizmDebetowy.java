/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.interfaces;

import pl.poznan.put.fc.projektbank.implementations.produkty.KontoDebetowe;

/**
 *
 * @author fenix
 */
public interface MechanizmDebetowy {
    public void obciazKonto(KontoDebetowe kontoDebetowe, double obciazenie);
}
