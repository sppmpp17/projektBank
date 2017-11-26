/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.interfaces;

import java.util.List;
import java.util.Map;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;

/**
 *
 * @author fenix
 */
public interface Historia {
    public void addHistoria(RachunekBankowy rachunek, String opis);
    public Map<RachunekBankowy, List<String>> getHistoria();
}
