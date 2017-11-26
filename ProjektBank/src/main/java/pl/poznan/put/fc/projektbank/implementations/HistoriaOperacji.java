/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.poznan.put.fc.projektbank.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.poznan.put.fc.projektbank.implementations.produkty.RachunekBankowy;
import pl.poznan.put.fc.projektbank.interfaces.Historia;

/**
 *
 * @author inf83973
 */
public class HistoriaOperacji implements Historia {
    private final static Map<RachunekBankowy, List<String>> map = new HashMap<>();
    private static final HistoriaOperacji histOper;
    
    static {
        histOper = new HistoriaOperacji();
    }
    
    public static HistoriaOperacji getInstance() {
        return histOper;
    }
    
    @Override
    public void addHistoria(RachunekBankowy rachunek, String opis) {
        if(!map.containsKey(rachunek)) {
            List<String> list = new ArrayList<>();
            map.put(rachunek, list);
        }
        map.get(rachunek).add(opis);
    }
    
    @Override
    public Map<RachunekBankowy, List<String>> getHistoria() {
        return map;
    }
    
    private HistoriaOperacji() {}
}
